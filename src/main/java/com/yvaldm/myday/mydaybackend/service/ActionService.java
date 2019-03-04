package com.yvaldm.myday.mydaybackend.service;

import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;

import java.util.List;

/**
 * @author valery.yakovlev
 */
public interface ActionService {

    List<Action> findActions();

    void trackAction(String userId, long actionId);

    List<ActionPerformed> findTrackedActions(String userId);
}
