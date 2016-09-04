package com.qinjiangbo.service;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qinjiangbo.pojo.Country;
import com.qinjiangbo.vo.CountryEnum;
import com.qinjiangbo.vo.CountryList;
import com.sun.istack.internal.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        //改为大写
        Function<Country, String> upperCaseFunction = new Function<Country, String>() {
            @Override
            public String apply(@Nullable Country country) {
                if (country == null) {
                    return "";
                }
                return country.getCapital().toUpperCase();
            }
        };

        //倒排名称
        Function<String, String> reverseFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s == null) {
                    return null;
                }
                return new StringBuilder(s).reverse().toString();
            }
        };

        //混合方法
        Function<Country, String> composeFunction = Functions.compose(reverseFunction, upperCaseFunction);
        List<String> capitals = Lists.transform(countryList.findCountries(), composeFunction);
        return capitals;
    }

    /**
     * 测试从Map中加载数据到指定的List中
     *
     * @return
     */
    public List<String> forMapFunction() {
        Map<String, String> map = Maps.newHashMap();
        map.put(CountryEnum.CHINA.getName(), CountryEnum.CHINA.getCapital());
        map.put(CountryEnum.US.getName(), CountryEnum.US.getCapital());
        map.put(CountryEnum.KOREA.getName(), CountryEnum.KOREA.getCapital());
        map.put(CountryEnum.GB.getName(), CountryEnum.GB.getCapital());

        Function<String, String> capitalNameFromCountryFunction = Functions.forMap(map);

        List<String> countries = Lists.newArrayList();
        countries.add(CountryEnum.CHINA.getName());
        countries.add(CountryEnum.US.getName());

        List<String> capitals = Lists.transform(countries, capitalNameFromCountryFunction);
        return capitals;
    }

}
