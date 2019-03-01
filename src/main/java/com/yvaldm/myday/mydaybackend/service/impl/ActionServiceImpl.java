package com.yvaldm.myday.mydaybackend.service.impl;

import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.service.ActionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for action service
 *
 * @author valery.yakovlev
 */
public class ActionServiceImpl implements ActionService {

    private static final List<Action> ACTION_LIST = new ArrayList<>();

    static {
        ACTION_LIST.add(new Action("Smoke", -20));
        ACTION_LIST.add(new Action("Run", 10));
        ACTION_LIST.add(new Action("Swim", 20));
        ACTION_LIST.add(new Action("Read", 10));
        ACTION_LIST.add(new Action("Drive car", -10));
        ACTION_LIST.add(new Action("Walk", 10));
        ACTION_LIST.add(new Action("Drink alcohol", -10));
    }

    @Override
    public List<Action> findActions() {
        return ACTION_LIST;
    }
}
