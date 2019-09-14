package com.yvaldm.myday.mydaybackend.dao.impl;

import static com.yvaldm.myday.server.jooq.Tables.ACTION;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import java.util.List;
import org.jooq.DSLContext;

public class ActionDaoImpl implements ActionDao {

  private final DSLContext dslContext;

  public ActionDaoImpl(DSLContext dslContext) {
    this.dslContext = dslContext;
  }

  @Override
  public List<Action> findActions() {
    return dslContext.selectFrom(ACTION).fetchInto(Action.class);
  }
}
