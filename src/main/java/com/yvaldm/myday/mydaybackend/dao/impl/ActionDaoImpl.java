package com.yvaldm.myday.mydaybackend.dao.impl;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.generated.Tables;
import com.yvaldm.myday.mydaybackend.entity.Action;
import org.jooq.DSLContext;

import java.util.List;

public class ActionDaoImpl implements ActionDao {

    private final DSLContext dslContext;

    public ActionDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Action> findActions() {
        return dslContext.selectFrom(Tables.ACTION).fetchInto(Action.class);
    }
}
