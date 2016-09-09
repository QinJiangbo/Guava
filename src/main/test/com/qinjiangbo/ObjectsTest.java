package com.qinjiangbo;

import com.qinjiangbo.pojo.Country;
import org.junit.Test;

/**
 * Date: 9/9/16
 * Author: qinjiangbo@github.io
 */
public class ObjectsTest {

    @Test
    public void testObjectsEquals() {
        Country country = new Country("CHINA", 2000, "BEIJING");
        Country country2 = new Country("CHINA", 2000, "BEIJING");
        System.out.println(country.equals(country2));
    }
}
