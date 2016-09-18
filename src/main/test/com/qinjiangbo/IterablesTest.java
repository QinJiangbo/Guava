package com.qinjiangbo;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Iterator;

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
}
