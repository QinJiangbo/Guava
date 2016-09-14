package com.qinjiangbo;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.qinjiangbo.vo.CountryEnum;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Date: 9/14/16
 * Author: qinjiangbo@github.io
 */
public class Collections2Test {

    @Test
    public void testTransformCollection() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);

        Collection<String> capitals = Collections2.transform(countries, new Function<CountryEnum, String>() {
            @Override
            public String apply(@Nullable CountryEnum country) {
                return Strings.isNullOrEmpty(country.getCapital()) ? "UNKNOWN" : country.getCapital();
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        });

        Iterator<String> iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testFilterCollections() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);
        Collection<CountryEnum> countriesFromAsia = Collections2.filter(countries, new Predicate<CountryEnum>() {
            @Override
            public boolean apply(@Nullable CountryEnum country) {
                return Objects.equal("ASIA", country.getContinent());
            }
        });

        Iterator<CountryEnum> iterator = countriesFromAsia.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    // "VIEW" OF THE PASSED COLLECTIONS?
    @Test
    public void testShowThatResultIsOnlyAView() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);

        Collection<String> capitals = Collections2.transform(countries, new Function<CountryEnum, String>() {
            @Override
            public String apply(@Nullable CountryEnum country) {
                return Strings.isNullOrEmpty(country.getCapital()) ? "UNKNOWN" : country.getCapital();
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        });

        Iterator<String> iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=======================");
        countries.add(CountryEnum.US);

        iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
