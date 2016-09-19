package com.qinjiangbo;

import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class IntsTest {

    @Test
    public void testFindGivenNumberInArray() {
        final int[] array1 = new int[]{0, 15, 49};
        final int[] array2 = new int[]{5, 2, 4, -18, 450};
        System.out.println(Ints.contains(array1, 49));
        System.out.println(Ints.indexOf(array2, 4));
    }
}
