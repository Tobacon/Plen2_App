package com.tobias.recyclerview;

/**
 * Created by Tobias
 */

public class Move {
    private String name;
    private int imagecode;

    public Move(String name, int imagecode) {
        this.name = name;
        this.imagecode = imagecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagecode() {
        return imagecode;
    }

    public void setImagecode(int imagecode) {
        this.imagecode = imagecode;
    }
}
