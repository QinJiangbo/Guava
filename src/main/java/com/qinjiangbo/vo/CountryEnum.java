package com.qinjiangbo.vo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Date: 9/4/16
 * Author: qinjiangbo@github.io
 */
public enum CountryEnum {
    CHINA("CHINA", "BEIJING", 2000, "ASIA"),
    US("US", "WASHINGTON DC", 200, "AMERICA"),
    KOREA("KOREA", "SEUL", 500, "ASIA"),
    GB("GB", "LONDON", 1000, "EURO"),
    FINLAND("FINLAND", "", 1000, "EURO");

    private String name;
    private String capital;
    private int age;
    private String continent;

    private CountryEnum(String name, String capital, int age, String continent) {
        this.name = name;
        this.capital = capital;
        this.age = age;
        this.continent = continent;
    }

    public static List<CountryEnum> findCountries() {
        return Lists.newArrayList(CHINA, US, KOREA, FINLAND, GB);
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
