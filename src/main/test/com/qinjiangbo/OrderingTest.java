package com.qinjiangbo;

import com.google.common.collect.Ordering;
import org.junit.Test;

/**
 * Date: 20/10/2016
 * Author: qinjiangbo@github.io
 */
public class OrderingTest {

    @Test
    public void testNaturalOrdering() {
        Ordering ordering = Ordering.natural(); //自然顺序排序
        int result1 = ordering.compare("c", "b");
        System.out.println(result1); // 1
        int result2 = ordering.compare(11, 2);
        System.out.println(result2);
    }

    @Test
    public void testToStringOrdering() {

    }

    @Test
    public void testFromComparatorOrdering() {

    }
}
