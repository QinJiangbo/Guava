package com.qinjiangbo;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class IntsTest {

    @Test
    public void testFindGivenNumberInArray() {
        final int[] array1 = new int[]{0, 15, 49};
        final int[] array2 = new int[]{5, 2, 4, -18, 450};
        System.out.println(Ints.contains(array1, 49)); // true
        System.out.println(Ints.indexOf(array2, 4)); // 2
    }

    @Test
    public void testConcatArrays() {
        final int[] array1 = new int[]{0, 15, 4, 49};
        final int[] array2 = new int[]{5, 2, 4, -18, 450};
        System.out.println(Ints.concat(array1, array2).length); // 9
    }

    @Test
    public void testJoinArrayUsingSeprator() {
        final int[] array1 = new int[]{0, 15, 4, 49};
        final int[] array2 = new int[]{5, 2, 4, -18, 450};
        System.out.println(Ints.join(" : ", array2)); // 5 : 2 : 4 : -18 : 450
    }

    @Test
    public void testFindMaxAndMinInArray() {
        final int[] array = new int[]{5, 2, 4, -18, 450};
        System.out.println(Ints.min(array)); // -18
        System.out.println(Ints.max(array)); // 450
    }

    @Test
    public void testToArray() {
        List<Integer> ints = Lists.newArrayList(1, 45, 5, 76, 34, 26, 68);
        System.out.println(Ints.toArray(ints)); // [I@1b701da1
        System.out.println(Ints.toArray(ints)[2]); // 5
    }

    @Test
    public void testAsList() {
        final int[] ints = new int[]{1, 45, 36, 76, 23, 6};
        System.out.println(Ints.asList(ints)); // [1, 45, 36, 76, 23, 6]
    }
}
