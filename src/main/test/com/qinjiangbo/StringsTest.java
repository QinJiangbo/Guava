package com.qinjiangbo;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Date: 9/12/16
 * Author: qinjiangbo@github.io
 */
public class StringsTest {

    @Test
    public void testNullOrEmptyString() {
        System.out.println(Strings.isNullOrEmpty(""));
    }

    @Test
    public void testNullOrEmptyString2() {
        System.out.println(Strings.isNullOrEmpty(null));
    }

    @Test
    public void testStringsPadEnd() {
        System.out.println(Strings.padEnd("Hello World", 20, '-'));
    }

    @Test
    public void testStringsPadStart() {
        System.out.println(Strings.padStart("Hello World", 20, '*'));
    }
}
