package com.qinjiangbo;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.qinjiangbo.vo.CountryEnum;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Iterator;

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
    public void testNotMatchChar() {
        System.out.println(CharMatcher.noneOf("xZ").matchesAnyOf("anything"));
    }

    @Test
    public void testMatchAny() {
        System.out.println(CharMatcher.ANY.matchesAllOf("anything"));
    }

    @Test
    public void testMatchBreakingWhiteSpace() {
        System.out.println(CharMatcher.BREAKING_WHITESPACE.matchesAllOf("\r\n\r\n"));
    }

    @Test
    public void testMatchDigits() {
        System.out.println(CharMatcher.DIGIT.matchesAllOf("1212121"));
    }

    @Test
    public void testMatchDigits2() {
        System.out.println(CharMatcher.DIGIT.matchesAnyOf("123abc123"));
    }

    @Test
    public void testMatchJavaDigits() {
        System.out.println(CharMatcher.JAVA_DIGIT.matchesAllOf("123456"));
    }

    @Test
    public void testMatchJavaLetter() {
        System.out.println(CharMatcher.JAVA_LETTER.matchesAllOf("Opera"));
    }

    @Test
    public void testMatchAscii() {
        System.out.println(CharMatcher.ASCII.matchesAllOf("azt*1"));
    }

    @Test
    public void testMatchUpperCase() {
        System.out.println(CharMatcher.JAVA_UPPER_CASE.matchesAllOf("JAVAC"));
    }

    @Test
    public void testMatchDigitsWithWhiteSpaces() {
        System.out.println(CharMatcher.DIGIT.matchesAnyOf("1111 abc"));
    }

    @Test
    public void testMatchRetainsDigits() {
        System.out.println(CharMatcher.DIGIT.retainFrom("123gb6789"));
    }

    @Test
    public void testMatchRetainsDigitsOrWhiteSpaces() {
        System.out.println(CharMatcher.DIGIT.or(CharMatcher.WHITESPACE).retainFrom("Hello world 123 javac!"));
    }

    @Test
    public void testMatchRetainsNothingAsConstrainsAreExcluding() {
        System.out.println(CharMatcher.DIGIT.and(CharMatcher.JAVA_LETTER).retainFrom("hello 123 abc!"));
    }

    @Test
    public void testMatchRetainsDigitsAndLetters() {
        System.out.println(CharMatcher.DIGIT.or(CharMatcher.JAVA_LETTER).retainFrom("hello 123 abc!"));
    }


}
