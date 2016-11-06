package com.qinjiangbo;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * Date: 9/19/16
 * Author: qinjiangbo@github.io
 */
public class RangesTest {

    @Test
    public void testCheckThatElementIsInRange() {
        Range<Integer> range = Range.closed(2, 20); // [2, 20]
        Range<Integer> rangeWithRightOpen = Range.closedOpen(2, 20); // [2, 20)
        System.out.println(range.contains(20)); // true
        System.out.println(rangeWithRightOpen.contains(20)); // false
    }

    @Test
    public void testCheckThatRangeIsEnclosedInOtherRange() {
        Range<Long> range = Range.openClosed(2L, 20L); // (2, 20]
        Range<Long> smallerRange = Range.closed(1L, 15L); // [1, 15]
        System.out.println(range.encloses(smallerRange)); // false
        Range newRange = range.span(smallerRange);
        System.out.println(newRange); // [1..20]
        Range newRange2 = range.intersection(smallerRange);
        System.out.println(newRange2); // (2..15]
    }

    @Test
    public void testCheckThatAllElementIsInRange() {
        Range<Integer> range = Range.closed(2, 20);
        System.out.println(range.containsAll(Lists.newArrayList(10, 20, 18, 8, 5, 19)));
    } // true

    @Test
    public void testGenerateSetOfElementInRange() {
        Range<Integer> range = Range.open(2, 20);
        Range<Integer> integers = range.canonical(DiscreteDomain.integers());
        System.out.println(integers); // [3..20)
        System.out.println(integers.contains(6)); // true
        System.out.println(integers.contains(7)); // true
    }

    @Test
    public void testCreateRangeForGivenNumbers() {
        ArrayList<Integer> numbers = Lists.newArrayList(4, 3, 6, 8, 5, 9);
        Range<Integer> range = Range.encloseAll(numbers);
        System.out.println(range.lowerEndpoint() == 3); // true
        System.out.println(range.upperEndpoint() == 9); // true
    }

    @Test
    public void testRangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 19), "foo");
        System.out.println("rangeMap: " + rangeMap); // rangeMap: [[1‥19]=foo]
        rangeMap.put(Range.open(3, 6), "bar");
        System.out.println("rangeMap: " + rangeMap); // rangeMap: [[1‥3]=foo, (3‥6)=bar, [6‥19]=foo]
        rangeMap.put(Range.open(10, 20), "foo");
        System.out.println("rangeMap: " + rangeMap); // rangeMap: [[1‥3]=foo, (3‥6)=bar, [6‥10]=foo, (10‥20)=foo]
        rangeMap.remove(Range.closed(5, 11));
        System.out.println("rangeMap: " + rangeMap); // rangeMap: [[1‥3]=foo, (3‥5)=bar, (11‥20)=foo]
    }

    @Test
    public void testRangeSet() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println("rangeSet: " + rangeSet); // rangeSet: [[1‥10]]
        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println("rangeSet: " + rangeSet); // rangeSet: [[1‥10], [11‥15)]
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet: " + rangeSet); // rangeSet: [[1‥10], [11‥15), (15‥20)]
        rangeSet.add(Range.closedOpen(20, 25));
        System.out.println("rangeSet: " + rangeSet); // rangeSet: [[1‥10], [11‥15), (15‥25)]
    }
}
