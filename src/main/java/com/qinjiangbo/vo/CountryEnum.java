package com.qinjiangbo.vo;

/**
 * Date: 9/4/16
 * Author: qinjiangbo@github.io
 */
public enum CountryEnum {
    CHINA("CHINA", "BEIJING", 2000),
    US("US", "WASHINGTON DC", 200),
    KOREA("KOREA", "SEUL", 500),
    GB("GB", "LONDON", 1000),
    FINLAND("FINLAND", "", 1000);

    private String name;
    private String capital;
    private int age;

    private CountryEnum(String name, String capital, int age) {
        this.name = name;
        this.capital = capital;
        this.age = age;
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
