package com.yvaldm.myday.mydaybackend.api;

/**
 * @author valery.yakovlev
 */
public class ActionResponse {

    private final String name;
    private final int rating;

    public ActionResponse(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
