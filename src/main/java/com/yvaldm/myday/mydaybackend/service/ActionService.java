package com.yvaldm.myday.mydaybackend.service;

import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;

import java.util.List;
import java.util.Map;

/**
 * @author valery.yakovlev
 */
public interface ActionService {

    /**
     * Retrieve the list of supported actions in the system
     *
     * @return list of supported actions
     */
    List<Action> findActions();

    /**
     * Track the user action for today
     *
     * @param userId   user identification
     * @param actionId action identification
     */
    void trackAction(String userId, long actionId);

    /**
     * Find all tracked actions for whole time period
     *
     * @param userId user identification
     * @return an overall list of performed actions for given user
     */
    List<ActionPerformed> findTrackedActions(String userId);

    /**
     * Find all tracked actions of specified user for today
     *
     * @param userId user identification
     * @return list of performed actions for today
     */
    List<ActionPerformed> findTrackedActionsOfToday(String userId);

    /**
     * Calculate summary for given month of the given year for given user
     *
     * @param userId user identification
     * @param year   year
     * @param month  month
     * @return map of day -> rating for given user
     */
    Map<Integer, Integer> loadSummaryByMonth(String userId, int year, int month);

}
