package com.qinjiangbo.pojo;

/**
 * Date: 9/2/16
 * Author: qinjiangbo@github.io
 */
public class Country {

    private String name;
    private int time;
    private String capital;

    public Country() {

    }

    public Country(String name, int time, String capital) {
        this.name = name;
        this.time = time;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
