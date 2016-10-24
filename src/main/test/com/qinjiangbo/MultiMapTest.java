package com.qinjiangbo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testMultiMapEntries() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("US", "Washington DC");
        multimap.put("US", "LA");
        multimap.put("US", "Seattle");
        multimap.put("US", "Brooklyn");
        Collection collections = multimap.entries();
        System.out.println(collections.toString());
        // 返回的是Multimap所有的键值对
        // [US=Washington DC, US=Brooklyn, US=Seattle, US=LA]
    }

    @Test
    public void testMultiMap() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("US", "Washington DC");
        multimap.put("US", "LA");
        multimap.put("US", "Seattle");
        multimap.put("US", "Brooklyn");
        Collection collections = multimap.entries();
        System.out.println(collections.toString());
        // 返回的是Multimap所有的键值对
        // [US=Washington DC, US=Brooklyn, US=Seattle, US=LA]
    }
}
