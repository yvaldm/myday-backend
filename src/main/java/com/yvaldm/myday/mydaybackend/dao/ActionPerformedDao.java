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
    List<ActionPerformed> findUserActionsOfToday(String userId);

    /**
     * Load all user tracked actions
     *
     * @param userId user identifier
     * @return list of tracked user actions
     */
    List<ActionPerformed> findUserActions(String userId);
}
