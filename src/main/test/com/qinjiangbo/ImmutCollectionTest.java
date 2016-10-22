package com.qinjiangbo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * Date: 9/18/16
 * Author: qinjiangbo@github.io
 */
public class ImmutCollectionTest {

    @Test
    public void testImmutableMapBuilder() {
        ImmutableMap<String, Integer> numbersMap = new ImmutableMap.Builder<String, Integer>()
                .put("one", 1)
                .put("two", 2)
                .put("three", 3)
                .build();
        System.out.println(numbersMap.get("two")); // 2
    }

    @Test
    public void testImmutableMapCreator() {
        ImmutableMap<String, Integer> numbersMap = ImmutableMap.of("one", 1, "two", 2,
                "three", 3, "four", 4);
        System.out.println(numbersMap.get("one")); // 1
    }

    @Test
    public void testImmutableSetBuilder() {
        ImmutableSet<String> nameSet = new ImmutableSet.Builder<String>()
                .add("hello", "I", "am", "Richard")
                .build();
        System.out.println(nameSet.toString());
    }

    @Test
    public void testImmutableSetCreator() {
        ImmutableSet<String> nameSet = ImmutableSet.of("Hello", "name", "Henry");
        System.out.println(nameSet.toString());
    }

    @Test
    public void testImmutableListBuilder() {
        ImmutableList<String> nameList = new ImmutableList.Builder<String>()
                .add("Hello", "World", "Guava", "Google")
                .build();
        System.out.println(nameList.toString());
    }

    @Test
    public void testImmutableListCreator() {
        ImmutableList<String> nameList = ImmutableList.of("Hello", "World", "Guava", "Google");
        System.out.println(nameList);
    }

}
