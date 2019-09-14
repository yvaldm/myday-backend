package com.yvaldm.myday.mydaybackend.controller;

import static com.yvaldm.myday.server.jooq.Tables.PERFORMED_ACTION;
import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.yvaldm.myday.mydaybackend.config.TestEmbeddedConfig;
import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.hamcrest.Matchers;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class ActionsTrackingControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ActionDao actionDao;

  @Autowired
  private ActionPerformedDao actionPerformedDao;

  @Autowired
  private DSLContext dslContext;

  @Test
  public void shouldTrackActivityOfSpecificUser() throws Exception {

    // arrange
    Action action = actionDao.findActions().get(0);
    String userId = "some-user-id-123";

    // act
    mvc.perform(post("/user/{userId}/actions/{actionId}", userId, action.getId()));

    // assert

    List<ActionPerformed> userActionsOfToday = actionPerformedDao.findTrackedActionsOfToday(userId);
    assertThat(userActionsOfToday).hasSize(1);
  }

  @Test
  public void shouldLoadTrackedEventsOnToday() throws Exception {

    // arrange
    Action action = actionDao.findActions().get(0);
    Action action1 = actionDao.findActions().get(1);
    Action action2 = actionDao.findActions().get(2);
    String userId = "some-user-id-123";

    mvc.perform(post("/user/{userId}/actions/{actionId}", userId, action.getId()));
    mvc.perform(post("/user/{userId}/actions/{actionId}", userId, action1.getId()));
    mvc.perform(post("/user/{userId}/actions/{actionId}", userId, action2.getId()));

    insertActionPerformed("some-user-id-123", action.getId(), of(2014, Month.JANUARY, 1, 0, 0, 0));

    assertThat(dslContext.selectCount().from(PERFORMED_ACTION).fetchOneInto(Integer.class))
        .isEqualTo(4);

    // act
    mvc.perform(get("/user/{userId}/actions/today", userId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[*].id", containsInAnyOrder((int) action.getId(),
            (int) action1.getId(),
            (int) action2.getId())));
  }

  @Test
  public void shouldLoadSummaryByDayForMonth() throws Exception {

    // arrange
    Action action0 = actionDao.findActions().get(0);
    Action action1 = actionDao.findActions().get(1);
    Action action2 = actionDao.findActions().get(2);
    String userId = "some-user-id-666";

    insertActionPerformed(userId, action0.getId(), of(2019, Month.JANUARY, 1, 1, 1, 1));
    insertActionPerformed(userId, action2.getId(), of(2019, Month.JANUARY, 1, 1, 1, 1));

    insertActionPerformed(userId, action1.getId(), of(2019, Month.FEBRUARY, 14, 1, 1, 1));
    insertActionPerformed(userId, action2.getId(), of(2019, Month.FEBRUARY, 14, 2, 1, 1));

    insertActionPerformed(userId, action1.getId(), of(2019, Month.MARCH, 2, 3, 1, 1));
    insertActionPerformed(userId, action2.getId(), of(2019, Month.MARCH, 2, 3, 1, 1));
    insertActionPerformed(userId, action0.getId(), of(2019, Month.MARCH, 2, 3, 1, 1));

    // act
    // map<int, int> (day -> rating)

    mvc.perform(get("/user/{userId}/actions/year/{year}/month/{month}", userId, 2019, 1))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasKey("1")))
        .andExpect(jsonPath("$", Matchers.hasValue(action0.getRating() + action2.getRating())));

    mvc.perform(get("/user/{userId}/actions/year/{year}/month/{month}", userId, 2019, 2))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasKey("14")))
        .andExpect(jsonPath("$", Matchers.hasValue(action1.getRating() + action2.getRating())));

    mvc.perform(get("/user/{userId}/actions/year/{year}/month/{month}", userId, 2019, 3))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasKey("2")))
        .andExpect(jsonPath("$",
            Matchers.hasValue(action0.getRating() + action1.getRating() + action2.getRating())));
  }

  private void insertActionPerformed(String userId, long actionId, LocalDateTime dateTime) {
    dslContext.insertInto(PERFORMED_ACTION)
        .set(PERFORMED_ACTION.USER_ID, userId)
        .set(PERFORMED_ACTION.ACTION_ID, actionId)
        .set(PERFORMED_ACTION.CTS, Timestamp.valueOf(dateTime))
        .execute();
  }
}