package com.yvaldm.myday.mydaybackend.service;

import com.yvaldm.myday.mydaybackend.entity.Action;

import java.util.List;

/**
 * @author valery.yakovlev
 */
public interface ActionService {

    List<Action> findActions();

}
