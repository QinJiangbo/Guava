package com.qinjiangbo;

import com.qinjiangbo.service.CountryService;
import org.junit.Assert;
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
    public void testFunction1() {
        List<String> capitalList = countryService.findCapitalsInUpperCase();
        capitalList.get(0);
        System.out.println(capitalList.get(2) + " parent iron!");
    }
}
