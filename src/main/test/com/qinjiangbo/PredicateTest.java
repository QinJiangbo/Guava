package com.qinjiangbo;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.qinjiangbo.pojo.Country;
import com.qinjiangbo.vo.CountryEnum;
import com.sun.istack.internal.Nullable;

/**
 * Date: 9/5/16
 * Author: qinjiangbo@github.io
 */
public class PredicateTest {

    /**
     *
     */
    public void testHasCapitalDefined() {
        Predicate<Country> capitalCityProvidedPredicate = new Predicate<Country>() {
            @Override
            public boolean apply(@Nullable Country country) {
                return !Strings.isNullOrEmpty(country.getCapital());
            }
        };

        boolean allCountriesSpecifyCapital = Iterables.all(
                Lists.newArrayList(CountryEnum.CHINA, CountryEnum.GB, CountryEnum.KOREA), capitalCityProvidedPredicate
        );
    }
}
