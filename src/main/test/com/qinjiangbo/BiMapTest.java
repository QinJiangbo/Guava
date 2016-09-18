package com.qinjiangbo;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * Date: 9/18/16
 * Author: qinjiangbo@github.io
 */
public class BiMapTest {

    @Test
    public void testNotAllowToPutExistingValue() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "one");
        biMap.put(2, "two");
        biMap.put(10, "ten");
    }

    @Test
    public void testAllowToPutExistingValue() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "one");
        biMap.put(2, "two");
        biMap.put(3, "three");
        biMap.forcePut(10, "one");
        System.out.println(biMap.get(1) + "-" + biMap.get(10));
    }

    @Test
    public void testInverseBiMap() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "one");
        biMap.put(2, "two");
        biMap.put(3, "three");
        biMap.put(4, "four");
        System.out.println(biMap.get(1));
        BiMap<String, Integer> inverseBiMap = biMap.inverse();
        System.out.println(inverseBiMap.get("four"));
    }
}
