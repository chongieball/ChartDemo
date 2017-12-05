package com.example.chongieball.chartdemo;

/**
 * Created by chongieball on 04/12/17.
 */

public class Model {
    private int x;
    private String y;

    public Model() {
    }

    public Model(int x, String y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
