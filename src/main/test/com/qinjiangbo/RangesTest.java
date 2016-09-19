package com.qinjiangbo;

import com.google.common.collect.Lists;
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

    @Test
    public void testCheckThatRangeIsEnclosedInOtherRange() {
        Range<Long> range = Range.openClosed(2L, 20L); // (2, 20]
        Range<Long> smallerRange = Range.closed(1L, 15L); // [1, 15]
        System.out.println(range.encloses(smallerRange));
        Range newRange = range.span(smallerRange);
        System.out.println(newRange);
        Range newRange2 = range.intersection(smallerRange);
        System.out.println(newRange2);
    }

    @Test
    public void testCheckThatAllElementIsInRange() {
        Range<Integer> range = Range.closed(2, 20);
        System.out.println(range.containsAll(Lists.newArrayList(10, 20, 18, 8, 5, 19)));
    }


}
