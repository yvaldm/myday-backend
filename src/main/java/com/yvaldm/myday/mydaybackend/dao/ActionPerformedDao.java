package com.yvaldm.myday.mydaybackend.dao;

import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;

import java.util.List;

public interface ActionPerformedDao {

    /**
     * Inserts entry that given user performed given operation
     *
     * @param userId   user identifier
     * @param actionId action identifier
     */
    void insertActionTrack(String userId, long actionId);

    /**
     * Retrieves list of user actions performed today
     *
     * @param userId user identifier
     * @return list of actions performed today
     */
    List<ActionPerformed> findTrackedActionsOfToday(String userId);

    /**
     * Load all user tracked actions
     *
     * @param userId user identifier
     * @return list of tracked user actions
     */
    List<ActionPerformed> findTrackedActions(String userId);

    /**
     * Load tracked actions of specific user on given month of the year
     *
     * @param userId user identification
     * @param year
     * @param month
     * @return list of actions performed by given user
     */
    List<ActionPerformed> findTrackedActionsByMonth(String userId, int year, int month);
}
