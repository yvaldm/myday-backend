package com.yvaldm.myday.mydaybackend.api;

import java.time.LocalDate;

/**
 * @author valery.yakovlev
 */
public class ActionPerformedResponse {

    private final long id;
    private final long actionId;
    private final String userId;
    private final LocalDate cts;

    public ActionPerformedResponse(long id, long actionId, String userId, LocalDate cts) {
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
