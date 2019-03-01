package com.yvaldm.myday.mydaybackend.entity;

public class Action {

    private final String name;
    private final int rating;

    public Action(String name, int rating) {
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


