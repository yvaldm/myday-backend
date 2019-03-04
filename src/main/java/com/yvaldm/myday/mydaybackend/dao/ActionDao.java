package com.yvaldm.myday.mydaybackend.dao;

import com.yvaldm.myday.mydaybackend.entity.Action;

import java.util.List;

/**
 * @author valery.yakovlev
 */
public interface ActionDao {

    List<Action> findActions();

}
