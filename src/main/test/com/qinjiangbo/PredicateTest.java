package com.qinjiangbo;

import com.google.common.base.*;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

    @Test
    public void testMatchCollapseAllDigitsByX() {
        System.out.println(CharMatcher.DIGIT.collapseFrom("Hello 167 j176", 'x'));
    }

    @Test
    public void testMatchReplaceAllDigitsByX() {
        System.out.println(CharMatcher.DIGIT.replaceFrom("Hello 17689 jik009", 'x'));
    }

    @Test
    public void testMatchReplaceAllLettersByX() {
        System.out.println(CharMatcher.JAVA_LETTER.or(CharMatcher.is('*')).replaceFrom("password 97321321 **65", 'X'));
    }

    @Test
    public void testMatchCountIn() {
        System.out.println(CharMatcher.DIGIT.countIn("*** 121 * a ** b"));
    }

    @Test
    public void testMatchCountIn2() {
        System.out.println(CharMatcher.is('*').countIn("*** 121 * a ** b"));
    }

    @Test
    public void testMatchIndexIn() {
        System.out.println(CharMatcher.is('*').indexIn("666 *** 121 * a ** b"));
    }

    @Test
    public void testMatchLastIndexIn() {
        System.out.println(CharMatcher.is('*').lastIndexIn("666 *** 121 * a ** b"));
    }

    @Test
    public void testMatchRemoveDigitsBetween3And6() {
        System.out.println(CharMatcher.inRange('3', '8').removeFrom("117787321daa096aa453aa299"));
    }

    @Test
    public void testNegateMatchingAbove() {
        System.out.println(CharMatcher.inRange('3', '8').negate().removeFrom("117787321daa096aa453aa299"));
    }

    @Test
    public void testRemoveStartingAndEndingDollarsAndKeepOthersUnchanged() {
        System.out.println(CharMatcher.is('$').trimFrom("$$$ This is a $ sign $$$"));
    }

    @Test
    public void testRemoveOnlyStartingDollarsAndKeepOthersUnchanged() {
        System.out.println(CharMatcher.is('$').trimLeadingFrom("$$$ This is a $ sign $$$"));
    }

    @Test
    public void testRemoveOnlyEndingDollarsAndKeepOthersUnchanged() {
        System.out.println(CharMatcher.is('$').trimTrailingFrom("$$$ This is a $ sign $$$"));
    }

    @Test
    public void testRemoveStartingAndEndingDollarsAndReplaceOtherDollarsWithX() {
        System.out.println(CharMatcher.is('$').trimAndCollapseFrom("$$$ This is a $$ and $ sign $$$", 'X'));
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
