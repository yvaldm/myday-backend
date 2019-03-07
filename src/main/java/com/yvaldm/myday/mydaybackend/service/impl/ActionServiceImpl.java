package com.yvaldm.myday.mydaybackend.service.impl;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;
import com.yvaldm.myday.mydaybackend.service.ActionService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

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
        return actionPerformedDao.findTrackedActions(userId);
    }

    @Override
    public List<ActionPerformed> findTrackedActionsOfToday(String userId) {
        return actionPerformedDao.findTrackedActionsOfToday(userId);
    }

    @Override
    public Map<Integer, Integer> loadSummaryByMonth(String userId, int year, int month) {

        Map<Long, Action> idToActionMap = actionDao.findActions().stream().collect(toMap(Action::getId, Function.identity()));
        List<ActionPerformed> trackedActions = actionPerformedDao.findTrackedActionsByMonth(userId, year, month);
        Map<Integer, List<ActionPerformed>> actionsGroupedByDay = trackedActions.stream().collect(groupingBy(ap -> ap.getCts().getDayOfMonth()));

        return actionsGroupedByDay
            .entrySet()
            .stream()
            .collect(toMap(Map.Entry::getKey,
                           key -> actionsGroupedByDay.get(key.getKey())
                               .stream()
                               .mapToInt(ap -> idToActionMap.get(ap.getActionId()).getRating()).sum()));
    }
}
