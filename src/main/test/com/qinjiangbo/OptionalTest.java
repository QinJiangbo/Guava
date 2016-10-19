package com.qinjiangbo;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Set;

/**
 * Date: 19/10/2016
 * Author: qinjiangbo@github.io
 */
public class OptionalTest {

    @Test
    public void testOptional() {
        Optional<String> optional = Optional.of("Hello World!");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    @Test
    public void testOptional2() {
        Optional<Integer> optional1 = Optional.of(6);
        Optional<Integer> optional2 = Optional.absent();
        Optional<Integer> optional3 = Optional.fromNullable(null);
        Optional<Integer> optional4 = Optional.fromNullable(10);

        if (optional1.isPresent()) {
            System.out.println("Optional1 is " + optional1.get());
        }

        if (optional2.isPresent()) {
            System.out.println("Optional2 is " + optional2.get());
        }

        if (optional3.isPresent()) {
            System.out.println("Optional3 is " + optional3.get());
        }

        if (optional4.isPresent()) {
            System.out.println("Optional4 is " + optional4.get());
        }
    }

    @Test
    public void testOptional3() {
        Optional<String> name = getNameListFromDB(null);
        if (name.isPresent()) {
            System.out.println("name: " + name.get());
        }
        System.out.println("orNull: " + name.orNull());
        Optional<String> address = getNameListFromDB("Wuhan Bayi Road");
        Set<String> set = address.asSet();
        System.out.println("toString: " + set.toString());
        System.out.println("size: " + set.size());
    }

    /**
     * 获得这个Optional返回类型
     *
     * @param DB
     * @return
     */
    private Optional<String> getNameListFromDB(String DB) {
        return Optional.fromNullable(DB);
    }
}
