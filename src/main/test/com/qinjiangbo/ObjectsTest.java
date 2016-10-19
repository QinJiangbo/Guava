package com.qinjiangbo;

import com.google.common.base.Objects;
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

    @Test
    public void testObjectsHash() {
        Country country = new Country("CHINA", 2000, "BEIJING");
        System.out.println(country.hashCode());
    }

    @Test
    public void testObjectsToString() {
        Country country = new Country("CHINA", 2000, "BEIJING");
        System.out.println(country.toString());
    }

    @Test
    public void testObjectsFirstNonNull() {
        String name = null;
        String nickName = "Richard";
        /* 貌似这个方法目前不支持了 */
        System.out.println(Objects.firstNonNull(nickName, name));
    }

    @Test
    public void testObjectsEquals2() {
        System.out.println(Objects.equal("a", "b"));
    }

}
