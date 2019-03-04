package com.yvaldm.myday.mydaybackend.entity;

import java.time.LocalDate;

public class ActionPerformed {

    private long id;
    private long actionId;
    private String userId;
    private LocalDate cts;

    public ActionPerformed(long id, long actionId, String userId, LocalDate cts) {
        this.id = id;
        this.actionId = actionId;
        this.userId = userId;
        this.cts = cts;
    }

    public long getId() {
        return id;
    }

    public long getActionId() {
        return actionId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getCts() {
        return cts;
    }
}
