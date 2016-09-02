package com.qinjiangbo.vo;

import com.google.common.collect.Lists;
import com.qinjiangbo.pojo.Country;

import java.util.List;

/**
 * Date: 9/2/16
 * Author: qinjiangbo@github.io
 */
public class CountryList {

    private List<Country> countries = Lists.newArrayList();

    {
        countries.add(new Country("China", 5000, "Beijing"));
        countries.add(new Country("US", 200, "Washington DC"));
        countries.add(new Country("Russia", 1000, "Moscow"));
    }


}
