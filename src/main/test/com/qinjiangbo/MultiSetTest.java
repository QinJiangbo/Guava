package com.qinjiangbo;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class MultiSetTest {

    @Test
    public void testAddElementsTwoTimes() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("one");
        multiset.add("one");
        System.out.println(multiset.count("one"));
    }
}
