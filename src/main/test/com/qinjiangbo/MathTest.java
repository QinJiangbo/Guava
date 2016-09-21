package com.qinjiangbo;

import com.google.common.math.DoubleMath;
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
        System.out.println(IntMath.sqrt(26, RoundingMode.DOWN));
    }

    @Test
    public void testFactorial() {
        System.out.println(DoubleMath.factorial(10));
    }

    @Test
    public void testMean() {
        System.out.println(DoubleMath.mean(10, 276, 89, 46, 59));
    }

}
