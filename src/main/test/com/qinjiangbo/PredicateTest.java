package com.qinjiangbo;

import com.google.common.base.*;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qinjiangbo.pojo.Country;
import com.qinjiangbo.vo.CountryEnum;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Date: 9/5/16
 * Author: qinjiangbo@github.io
 */
public class PredicateTest {

    @Test
    public void testHasCapitalDefined() {
        Predicate<CountryEnum> capitalCityProvidedPredicate = new Predicate<CountryEnum>() {
            @Override
            public boolean apply(@Nullable CountryEnum country) {
                return !Strings.isNullOrEmpty(country.getCapital());
            }
        };

        boolean allCountriesSpecifyCapital = Iterables.all(
                Lists.newArrayList(CountryEnum.CHINA, CountryEnum.GB, CountryEnum.FINLAND), capitalCityProvidedPredicate
        );

        System.out.println(allCountriesSpecifyCapital);
    }

    @Test
    public void testComposedPredicate() {
        Predicate<CountryEnum> fromAsiaPredicate = new Predicate<CountryEnum>() {
            @Override
            public boolean apply(@Nullable CountryEnum country) {
                return country.getContinent().equals("ASIA");
            }
        };

        Predicate<CountryEnum> historyPredicate = new Predicate<CountryEnum>() {
            @Override
            public boolean apply(@Nullable CountryEnum country) {
                return country.getAge() > 1000;
            }
        };

        Predicate<CountryEnum> composedPredicate = Predicates.and(fromAsiaPredicate, historyPredicate);

        Iterable<CountryEnum> filteredCountries = Iterables.filter(CountryEnum.findCountries(), composedPredicate);

        Iterator iterator = filteredCountries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testContainsPredicate() {
        Predicate<CharSequence> containsPredicate = Predicates.containsPattern("\\d\\d");
        boolean isContained = containsPredicate.apply("hello world 21!");
        System.out.println(isContained);
    }

    @Test
    public void testJoinerOn() {
        List<String> languages = Arrays.asList("Java", "Haskell", "Scala", "Brainfuck");
        System.out.println(Joiner.on(',').join(languages));
    }

    @Test
    public void testJoinerJoinWithCommasAndOmitNulls() {
        List<String> countriesWithNullValue = Arrays.asList("Poland", "Brazil", "Ukraine", null, "China");
        System.out.println(Joiner.on(',').skipNulls().join(countriesWithNullValue));
    }

    @Test
    public void testJoinerJoinWithCommasAndReplaceNullWithDefaultValue() {
        List<String> countriesWithNullValue = Arrays.asList("Poland", "Brazil", "Ukraine", null, "China");
        System.out.println(Joiner.on(',').useForNull("NONE").join(countriesWithNullValue));
    }

    @Test
    public void testJoinerJoinMap() {
        Map<Integer, String> numberWords = Maps.newHashMap();
        numberWords.put(1, "one");
        numberWords.put(2, "two");
        numberWords.put(3, null);
        numberWords.put(4, "four");
        System.out.println(Joiner.on(" | ").withKeyValueSeparator(" -> ").useForNull("Unknown").join(numberWords));
    }

}
