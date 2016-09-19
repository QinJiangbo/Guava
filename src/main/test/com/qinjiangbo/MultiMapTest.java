package com.qinjiangbo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class MultiMapTest {

    @Test
    public void testHowMultiMapWorks() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("China", "Beijing");
        multimap.put("China", "Tianjing");
        multimap.put("China", "Wuhan");

        multimap.put("US", "Washington DC");
        multimap.put("US", "LA");
        multimap.put("US", "Seattle");
        multimap.put("US", "Brooklyn");

        System.out.println("size:" + multimap.size());
    }
}
