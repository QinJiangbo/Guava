package com.qinjiangbo;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class MultiSetTest {

    @Test
    public void testJDK_WordCount() {
        String string = "I have a dream ! I dream one day I can go everywhere I wish !";
        String[] words = string.split(" ");
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, count + 1);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void testAddElementsTwoTimes() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("one");
        multiset.add("one");
        System.out.println(multiset.count("one")); // 2
    }

    @Test
    public void testUserCustomAddRemoveAndSetCount() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("ball");
        multiset.add("ball", 10);
        System.out.println(multiset.count("ball")); // 11

        multiset.remove("ball", 5);
        System.out.println(multiset.count("ball")); // 6

        multiset.setCount("ball", 8);
        System.out.println(multiset.count("ball")); // 8
    }

    @Test
    public void testRetainOnlySelectedKeys() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("ball");
        multiset.add("ball");
        multiset.add("cow");
        multiset.setCount("twelve", 12);

        multiset.retainAll(Arrays.asList("ball", "horse"));

        System.out.println("cow " + multiset.count("cow")); // cow 0
        System.out.println("ball " + multiset.count("ball")); // ball 2
    }
}
