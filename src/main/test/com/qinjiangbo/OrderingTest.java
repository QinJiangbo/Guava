package com.qinjiangbo;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Comparator;

/**
 * Date: 20/10/2016
 * Author: qinjiangbo@github.io
 */
public class OrderingTest {

    @Test
    public void testNaturalOrdering() {
        Ordering ordering = Ordering.natural(); //自然顺序排序
        int result1 = ordering.compare("cd", "ys");
        System.out.println(result1); // -22, 字符串首字母字典相对顺序
        int result2 = ordering.compare(11, 2);
        System.out.println(result2); // 1
//        int result3 = ordering.compare(1, "hello");
//        System.out.println(result3); // class cast exception
        int result4 = ordering.compare('d', 'a');
        System.out.println(result4); // 3, 字符在字典中的相对顺序
        int result5 = ordering.compare(1.5, 6.8);
        System.out.println(result5); // -1

    }

    @Test
    public void testToStringOrdering() {
        Ordering ordering = Ordering.usingToString();
        int result = ordering.compare(578, "hello world");
        System.out.println(result);// 将所有比较元素转化为字符串再比较
    }

    @Test
    public void testFromComparatorOrdering() {
        Comparator<Worker> comparator = (o1, o2) -> o1.age - o2.age;
        Ordering ordering = Ordering.from(comparator);
        int result = ordering.compare(new Worker("Zhangsan", 23), new Worker("Lisi", 26));
        System.out.println(result); // -3,比较两人的年龄之差
    }

    @Test
    public void testAllEqualOrdering() {
        Ordering ordering = Ordering.allEqual();
        System.out.println(ordering.compare("a", "dd")); // 0, 所有元素都认为是相等的
    }

    @Test
    public void testOrderingDetails() {
        Ordering ordering = Ordering.natural();
        // min
        System.out.println(ordering.min(1, 5)); // 1
        // min
        System.out.println(ordering.min(5, 4, 7, 8)); // 4
        // min
        Iterable iterable = Iterables.concat(Lists.newArrayList(31, 5, 8, 49, 24));
        System.out.println(ordering.min(iterable)); // 5

        // max
        System.out.println(ordering.max(iterable)); // 49

        // binary search
        System.out.println(ordering.binarySearch(
                Lists.newArrayList(14, 18, 19, 45, 76, 78), 45)); // 3, 表示第四个元素

    }
}

class Worker {

    String name;
    int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
