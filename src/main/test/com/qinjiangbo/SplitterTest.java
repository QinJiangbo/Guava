package com.qinjiangbo;

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
}
