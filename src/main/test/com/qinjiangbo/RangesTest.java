package com.qinjiangbo;

import com.google.common.collect.Range;
import org.junit.Test;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class RangesTest {

    @Test
    public void testCheckThatElementIsInRange() {
        Range<Integer> range = Range.closed(2, 20); // [2, 20]
        Range<Integer> rangeWithRightOpen = Range.closedOpen(2, 20); // [2, 20)
        System.out.println(range.contains(20));
        System.out.println(rangeWithRightOpen.contains(20));
    }
}
