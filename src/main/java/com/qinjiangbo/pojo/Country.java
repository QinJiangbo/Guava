package com.qinjiangbo.pojo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.getName())
                && Objects.equals(time, country.getTime())
                && Objects.equals(capital, country.getCapital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time, capital);
    }

}
