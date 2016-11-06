package com.qinjiangbo;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class MathTest {

    @Test
    public void testSqrt() {
        System.out.println(IntMath.sqrt(26, RoundingMode.DOWN)); // 5
    }

    @Test
    public void testFactorial() {
        System.out.println(DoubleMath.factorial(10)); // 3628800.0
    }

    @Test
    public void testMean() {
        System.out.println(DoubleMath.mean(10, 276, 89, 46, 59)); // 96.0
    }

    @Test
    public void testDivide() {
        System.out.println(IntMath.divide(10, 3, RoundingMode.UP));
    }

    @Test
    public void testGcd() {
        System.out.println(IntMath.gcd(60, 24)); // 12
    }

    @Test
    public void testMod() {
        System.out.println(IntMath.mod(192, 54)); // 30
    }

    @Test
    public void testPow() {
        System.out.println(IntMath.pow(2, 10)); // 1024
    }

    @Test
    public void testIsPowerOfTwo() {
        System.out.println(IntMath.isPowerOfTwo(36)); // false
    }

    @Test
    public void testBinomial() {
        System.out.println(IntMath.binomial(10, 4)); // 210 [等于C(10, 4)]
    }

}
