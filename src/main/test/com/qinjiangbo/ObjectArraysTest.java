package com.qinjiangbo;

import com.google.common.collect.ObjectArrays;
import org.junit.Test;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class ObjectArraysTest {

    @Test
    public void concatTwoArrays() {
        String[] array1 = new String[]{"one", "two", "three"};
        String[] array2 = new String[]{"four", "five"};
        String[] array3 = ObjectArrays.concat(array1, array2, String.class);
        System.out.println(array3.length);
        System.out.println("array3[2] => " + array3[2]);
    }

    @Test
    public void testAppendElement() {
        String[] array1 = new String[]{"one", "two", "three"};
        String[] array2 = new String[]{"four", "five"};
        String[] array3 = ObjectArrays.concat(array2, "six");
        System.out.println(array3[2]);
    }

    @Test
    public void testPrependElement() {
        String[] array1 = new String[]{"one", "two", "three"};
        String[] array2 = new String[]{"four", "five"};
        String[] array3 = ObjectArrays.concat("zero", array1);
        System.out.println(array3[0]);
    }
}
