package com.qinjiangbo;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * Date: 9/18/16
 * Author: qinjiangbo@github.io
 */
public class ImmutableMapTest {

    @Test
    public void testUseMapBuilder() {
        ImmutableMap<String, Integer> numbersMap = new ImmutableMap.Builder<String, Integer>()
                .put("one", 1)
                .put("two", 2)
                .put("three", 3)
                .build();
        System.out.println(numbersMap.get("two"));
    }

    @Test
    public void testUseOfCreator() {
        ImmutableMap<String, Integer> numbersMap = ImmutableMap.of("one", 1, "two", 2,
                "three", 3, "four", 4);
        System.out.println(numbersMap.get("one"));
    }
}
