package com.qinjiangbo;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.hash.*;
import org.junit.Test;

import java.util.List;

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
        List<String> ips = Lists.newArrayList("192.168.1.100",
                "192.168.1.110", "192.168.1.120");
        long ipHashCode1 = Hashing.md5().newHasher().putString(ips.get(0), Charsets.UTF_8).hash().asLong();
        long ipHashCode2 = Hashing.md5().newHasher().putString(ips.get(1), Charsets.UTF_8).hash().asLong();
        long ipHashCode3 = Hashing.md5().newHasher().putString(ips.get(2), Charsets.UTF_8).hash().asLong();

        System.out.println("ip1: " + Hashing.consistentHash(ipHashCode1, 3));
        System.out.println("ip2: " + Hashing.consistentHash(ipHashCode2, 3));
        System.out.println("ip3: " + Hashing.consistentHash(ipHashCode3, 3));
    }

    @Test
    public void testGoodFastHash() {
        System.out.println(Hashing.goodFastHash(1));
        System.out.println(Hashing.goodFastHash(10));
        System.out.println(Hashing.goodFastHash(100));
        System.out.println(Hashing.goodFastHash(1000));
        System.out.println(Hashing.goodFastHash(10000));
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
