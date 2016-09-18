package com.qinjiangbo;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Date: 9/18/16
 * Author: qinjiangbo@github.io
 */
public class IterablesTest {

    @Test
    public void testIterablesAll() {

        Predicate<String> lengthPredicate = new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {
                if (input == null) {
                    return false;
                }
                return input.length() > 3;
            }
        };

        System.out.println(Iterables.all(Lists.newArrayList("Hello", "Java", "Haskell", "Python"), lengthPredicate));
    }

    @Test
    public void testIterablesAny() {

        Predicate<String> emptyOrNullPredicate = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return Strings.isNullOrEmpty(input);
            }
        };

        System.out.println(Iterables.any(Lists.newArrayList("Java", "Java", "Kotlin"), emptyOrNullPredicate));
    }

    @Test
    public void testCycleOverIterable() {
        Iterable<String> cycleIterables = Iterables.cycle("Right", "Left");
        Iterator<String> iterator = cycleIterables.iterator();
        for (int i = 0; i < 100; i++) {
            iterator.next();
        }
        System.out.println(iterator.next());
    }

    @Test
    public void testFilterOnlyLongs() {
        List<Number> numbersList = Lists.newArrayList();
        numbersList.add(1L);
        numbersList.add(11);
        numbersList.add(2L);
        Iterable<Long> filterList = Iterables.filter(numbersList, Long.class);
        filterList.forEach(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                System.out.println(aLong);
            }
        });
    }

    @Test
    public void testCountElementsInIterable() {
        List<Integer> numberList = Lists.newArrayList(1, 2, 3, 6, -9, 4, -3, -9, 7, 6);
        int frequency = Iterables.frequency(numberList, -9);
        System.out.println(frequency);
    }


}
