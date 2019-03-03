package com.yvaldm.myday.mydaybackend.entity;

public class Action {

    private final long id;
    private final String name;
    private final int rating;
    private final String image;

    public Action(long id, String name, int rating, String image) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }
}


