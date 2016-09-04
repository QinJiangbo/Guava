package com.qinjiangbo.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.qinjiangbo.pojo.Country;
import com.qinjiangbo.vo.CountryList;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Date: 9/2/16
 * Author: qinjiangbo@github.io
 */
public class CountryService {

    private CountryList countryList = new CountryList();

    /**
     * 查找每个国家的首都信息
     * @return
     */
    public List<String> transformCapitalsInUpperCase() {
        Function<Country, String> capitalCityFunction = new Function<Country, String>() {
            @Override
            public String apply(@Nullable Country country) {
                if (country == null) {
                    return null;
                }
                return country.getCapital().toUpperCase();
            }
        };

        List<String> capitalList = Lists.transform(countryList.findCountries(), capitalCityFunction);
        return capitalList;
    }

    /**
     * 查找每个国家的首都信息并将其转换为大写以及倒排
     *
     * @return
     */
    public List<String> composeTwoFunctions() {
        Function<Country, String> upperCaseFunction = new Function<Country, String>() {
            @Override
            public String apply(@Nullable Country country) {
                if (country == null) {
                    return "";
                }
                return country.getCapital().toUpperCase();
            }
        };

        Function<String, String> reverseFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s == null) {
                    return null;
                }
                return new StringBuilder(s).reverse().toString();
            }
        };
        return null;
    }


}
