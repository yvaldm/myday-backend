package com.yvaldm.myday.mydaybackend.service.impl;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;
import com.yvaldm.myday.mydaybackend.service.ActionService;

import java.util.List;

/**
 * Implementation for action service
 *
 * @author valery.yakovlev
 */
public class ActionServiceImpl implements ActionService {

    private final ActionDao actionDao;
    private final ActionPerformedDao actionPerformedDao;

    public ActionServiceImpl(ActionDao actionDao, ActionPerformedDao actionPerformedDao) {
        this.actionDao = actionDao;
        this.actionPerformedDao = actionPerformedDao;
    }

    @Override
    public List<Action> findActions() {
        return actionDao.findActions();
    }

    @Override
    public void trackAction(String userId, long actionId) {
        actionPerformedDao.insertActionTrack(userId, actionId);
    }

    @Override
    public List<ActionPerformed> findTrackedActions(String userId) {
        return actionPerformedDao.findUserActions(userId);
    }
}
