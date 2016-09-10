package com.qinjiangbo;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Date: 9/10/16
 * Author: qinjiangbo@github.io
 */
public class SplitterTest {

    @Test
    public void testSplitOnSemicolons() {
        Iterable<String> iterable = Splitter.on(";").split("Java;Scala;Php;Haskell");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(2).equals("Php"));
    }

    @Test
    public void testSplitOnRegExp() {
        Iterable<String> iterable = Splitter.onPattern("\\d+").split("Java13Scala41Php5C#6");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(2).equals("Php"));
    }

    @Test
    public void testSplitUsingCharMatcher() {
        Iterable<String> iterable = Splitter.on(CharMatcher.inRange('3', '8')).split("Java3Scala4Haskell7Brain9Kotlin");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(2));
    }

    @Test
    public void testSplitOmitEmptyStrings() {
        Iterable<String> iterable = Splitter.on(";").omitEmptyStrings().split("Java;Scala; ;;Haskell;;Kotlin");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(2));
    }

    @Test
    public void testSplitTrimResults() {
        Iterable<String> iterable = Splitter.on(";").trimResults().omitEmptyStrings().split("Java;Scala; ;;Haskell;;Kotlin");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(2));
    }

    @Test
    public void testSplitOnFixedLength() {
        Iterable<String> iterable = Splitter.fixedLength(7).split("Someone once told me that I was lucky!");
        List<String> splittedList = Lists.newArrayList(iterable);
        System.out.println(splittedList.get(1));
    }

}
