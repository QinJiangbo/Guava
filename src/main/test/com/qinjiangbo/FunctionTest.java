package com.qinjiangbo;

import com.qinjiangbo.service.CountryService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Date: 9/2/16
 * Author: qinjiangbo@github.io
 */
public class FunctionTest {

    private CountryService countryService;

    @Before
    public void init() {
        countryService = new CountryService();
    }

    @Test
    public void testTransformFunction() {
        List<String> capitalList = countryService.transformCapitalsInUpperCase();
        for (String capital : capitalList) {
            System.out.println(capital);
        }
    }

    @Test
    public void testComposeFunction() {
        List<String> capitalList = countryService.composeTwoFunctions();
        for (String capital : capitalList) {
            System.out.println(capital);
        }
    }

    @Test
    public void testForMapFunction() {
        List<String> capitalList = countryService.forMapFunction();
        for (String city : capitalList) {
            System.out.println(city);
        }
    }

}
