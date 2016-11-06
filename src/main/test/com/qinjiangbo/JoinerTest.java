package com.qinjiangbo;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Date: 9/10/16
 * Author: qinjiangbo@github.io
 */
public class JoinerTest {
    @Test
    public void testJoinerOn() {
        List<String> languages = Arrays.asList("Java", "Haskell", "Scala", "Brainfuck");
        System.out.println(Joiner.on(',').join(languages));
    } // Java,Haskell,Scala,Brainfuck

    @Test
    public void testJoinerJoinWithCommasAndOmitNulls() {
        List<String> countriesWithNullValue = Arrays.asList("Poland", "Brazil", "Ukraine", null, "China");
        System.out.println(Joiner.on(',').skipNulls().join(countriesWithNullValue));
    } // Poland,Brazil,Ukraine,China

    @Test
    public void testJoinerJoinWithCommasAndReplaceNullWithDefaultValue() {
        List<String> countriesWithNullValue = Arrays.asList("Poland", "Brazil", "Ukraine", null, "China");
        System.out.println(Joiner.on(',').useForNull("NONE").join(countriesWithNullValue));
    } // Poland,Brazil,Ukraine,NONE,China

    @Test
    public void testJoinerJoinMap() {
        Map<Integer, String> numberWords = Maps.newHashMap();
        numberWords.put(1, "one");
        numberWords.put(2, "two");
        numberWords.put(3, null);
        numberWords.put(4, "four");
        System.out.println(Joiner.on(" | ").withKeyValueSeparator(" -> ").useForNull("Unknown").join(numberWords));
    } // 1 -> one | 2 -> two | 3 -> Unknown | 4 -> four
}
