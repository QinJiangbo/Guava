package com.qinjiangbo;

import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.RoundingMode;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class MathTest {

    @Test
    public void testSqrt() {
        System.out.println(IntMath.sqrt(17, RoundingMode.DOWN));
    }
}
