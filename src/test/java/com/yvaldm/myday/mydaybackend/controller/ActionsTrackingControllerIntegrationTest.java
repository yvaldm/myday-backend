package com.yvaldm.myday.mydaybackend.controller;

import com.yvaldm.myday.mydaybackend.config.TestEmbeddedConfig;
import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void shouldTrackActivityOfSpecificUser() throws Exception {

        // arrange
        Action action = actionDao.findActions().get(0);
        String userId = "some-user-id-123";

        // act
        mvc.perform(post("/user/{userId}/actions/{actionId}", userId, action.getId())
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // assert

        List<ActionPerformed> userActionsOfToday = actionPerformedDao.findUserActionsOfToday(userId);
        assertThat(userActionsOfToday).hasSize(1);
    }
}