package com.yvaldm.myday.mydaybackend.dao.impl;

import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;
import org.jooq.DSLContext;
import org.jooq.DatePart;
import org.jooq.impl.DSL;

import java.sql.Timestamp;
import java.util.List;

import static com.yvaldm.myday.mydaybackend.dao.generated.Tables.PERFORMED_ACTION;

public class ActionPerformedDaoImpl implements ActionPerformedDao {

    private final DSLContext dslContext;

    public ActionPerformedDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void insertActionTrack(String userId, long actionId) {

        dslContext.insertInto(PERFORMED_ACTION)
            .set(PERFORMED_ACTION.ACTION_ID, actionId)
            .set(PERFORMED_ACTION.USER_ID, userId)
            .execute();
    }

    @Override
    public List<ActionPerformed> findTrackedActionsOfToday(String userId) {

        return dslContext.selectFrom(PERFORMED_ACTION)
            .where(PERFORMED_ACTION.USER_ID.eq(userId))
            .and(PERFORMED_ACTION.CTS.ge(DSL.currentDate().cast(Timestamp.class)))
            .fetchInto(ActionPerformed.class);
    }

    @Override
    public List<ActionPerformed> findTrackedActions(String userId) {

        return dslContext.selectFrom(PERFORMED_ACTION)
            .where(PERFORMED_ACTION.USER_ID.eq(userId))
            .fetchInto(ActionPerformed.class);
    }

    @Override
    public List<ActionPerformed> findTrackedActionsByMonth(String userId, int year, int month) {

        return dslContext.selectFrom(PERFORMED_ACTION)
            .where(DSL.extract(PERFORMED_ACTION.CTS, DatePart.MONTH).eq(month))
            .and(DSL.extract(PERFORMED_ACTION.CTS, DatePart.YEAR).eq(year))
            .fetchInto(ActionPerformed.class);
    }
}
