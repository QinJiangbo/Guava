package com.qinjiangbo;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import org.junit.Test;

/**
 * Date: 06/11/2016
 * Author: qinjiangbo@github.io
 */
public class HashTest {

    @Test
    public void testMd5Hash() {
        Student student1 = new Student(2012302580314l, 21, "Richard");
        Student student2 = new Student(2012302580311l, 21, "Richard");
        HashFunction hashFunction = Hashing.md5();
        HashCode hashCod1 = hashFunction.newHasher()
                .putObject(student1, (Funnel<Student>) (from, into) -> into
                        .putLong(from.sid)
                        .putInt(from.age)
                        .putString(from.name, Charsets.UTF_8)).hash();
        HashCode hashCode2 = hashFunction.newHasher()
                .putObject(student2, (Funnel<Student>) (from, into) -> into
                        .putLong(from.sid)
                        .putInt(from.age)
                        .putString(from.name, Charsets.UTF_8)).hash();
        System.out.println(hashCod1.asInt());
        System.out.println(hashCode2.asInt());
    }

    @Test
    public void testConsistentHash() {

    }

    class Student {
        final long sid;
        final int age;
        final String name;

        Student(long sid, int age, String name) {
            this.sid = sid;
            this.age = age;
            this.name = name;
        }
    }
}
