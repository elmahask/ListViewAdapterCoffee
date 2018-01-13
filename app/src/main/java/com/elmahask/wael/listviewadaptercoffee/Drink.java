package com.elmahask.wael.listviewadaptercoffee;

/**
 * Created by elmahask on 12/8/17.
 */

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public Drink() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        // String str=String.format(name);
        return this.name;
    }
}
