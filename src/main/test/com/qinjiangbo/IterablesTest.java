package com.qinjiangbo;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

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
}
