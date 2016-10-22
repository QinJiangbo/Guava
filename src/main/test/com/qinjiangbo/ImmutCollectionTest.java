package com.qinjiangbo;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * Date: 9/18/16
 * Author: qinjiangbo@github.io
 */
public class ImmutCollectionTest {

    /**
     * Creator or Builder of Immutable Collections
     */

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
        System.out.println(nameSet.toString()); // [hello, I, am, Richard]
    }

    @Test
    public void testImmutableSetCreator() {
        ImmutableSet<String> nameSet = ImmutableSet.of("Hello", "name", "Henry");
        System.out.println(nameSet.toString()); // [Hello, name, Henry]
    }

    @Test
    public void testImmutableListBuilder() {
        ImmutableList<String> nameList = new ImmutableList.Builder<String>()
                .add("Hello", "World", "Guava", "Google")
                .build();
        System.out.println(nameList.toString()); // [Hello, World, Guava, Google]
    }

    @Test
    public void testImmutableListCreator() {
        ImmutableList<String> nameList = ImmutableList.of("Hello", "World", "Guava", "Google");
        System.out.println(nameList); // [Hello, World, Guava, Google]
    }

    /**
     * copyOf
     */
    @Test
    public void testImmutableCollectionCopyOf() {
        ArrayList<String> nameList = Lists.newArrayList("Hello", "I", "like", "you", "OK");
        ImmutableList<String> nameList2 = ImmutableList.copyOf(nameList);
        ImmutableList<String> nameList3 = ImmutableList.copyOf(nameList.subList(1, 4));
        System.out.println(nameList2); // [Hello, I, like, you, OK]
        System.out.println(nameList3); // [I, like, you]
    }

    @Test
    public void testImmutableCollectionAsList() {
        ImmutableSet<String> nameSet = ImmutableSet.of("Hello", "Guava", "ISS", "WHU");
        System.out.println(nameSet.asList().get(1)); // Guava
        System.out.println(nameSet.asList()); // [Hello, Guava, ISS, WHU]
    }

}
