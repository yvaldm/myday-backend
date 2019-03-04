package com.yvaldm.myday.mydaybackend.api;

/**
 * @author valery.yakovlev
 */
public class ActionResponse {

    private final long id;
    private final String name;
    private final int rating;

    public ActionResponse(long id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
