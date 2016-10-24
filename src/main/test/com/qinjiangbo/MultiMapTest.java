package com.qinjiangbo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

        System.out.println("size: " + multimap.size()); // size: 7
        System.out.println("elements list: " + multimap.get("China")); // elements list: [Beijing, Tianjing, Wuhan]
        System.out.println("keys length: " + multimap.keys().size()); // keys length: 7
    }

    @Test
    public void testMultiMapAsMap() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("US", "Washington DC");
        multimap.put("US", "LA");
        multimap.put("US", "Seattle");
        multimap.put("US", "Brooklyn");
        Map map = multimap.asMap();
        // map.put("US", "hello"); // java.lang.UnsupportedOperationException
        Set<Map.Entry> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
