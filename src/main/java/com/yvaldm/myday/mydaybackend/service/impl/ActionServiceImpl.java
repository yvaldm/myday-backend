package com.yvaldm.myday.mydaybackend.service.impl;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.service.ActionService;

import java.util.List;

/**
 * Implementation for action service
 *
 * @author valery.yakovlev
 */
public class ActionServiceImpl implements ActionService {

    private final ActionDao actionDao;

    public ActionServiceImpl(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    @Override
    public List<Action> findActions() {
        return actionDao.findActions();
    }
}
