package com.qinjiangbo;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.qinjiangbo.vo.CountryEnum;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.*;

/**
 * Date: 9/14/16
 * Author: qinjiangbo@github.io
 */
public class CollectionsTest {

    @Test
    public void testTransformCollection() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);

        Collection<String> capitals = Collections2.transform(countries, new Function<CountryEnum, String>() {
            @Override
            public String apply(@Nullable CountryEnum country) {
                return Strings.isNullOrEmpty(country.getCapital()) ? "UNKNOWN" : country.getCapital();
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        });

        Iterator<String> iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testFilterCollections() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);
        Collection<CountryEnum> countriesFromAsia = Collections2.filter(countries, new Predicate<CountryEnum>() {
            @Override
            public boolean apply(@Nullable CountryEnum country) {
                return Objects.equal("ASIA", country.getContinent());
            }
        });

        Iterator<CountryEnum> iterator = countriesFromAsia.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    // "VIEW" OF THE PASSED COLLECTIONS?
    @Test
    public void testShowThatResultIsOnlyAView() {
        ArrayList<CountryEnum> countries = Lists.newArrayList(CountryEnum.CHINA, CountryEnum.FINLAND, CountryEnum.KOREA);

        Collection<String> capitals = Collections2.transform(countries, new Function<CountryEnum, String>() {
            @Override
            public String apply(@Nullable CountryEnum country) {
                return Strings.isNullOrEmpty(country.getCapital()) ? "UNKNOWN" : country.getCapital();
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        });

        Iterator<String> iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=======================");
        countries.add(CountryEnum.US);

        iterator = capitals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testLists() {
        // 创造集合类-->直接newArrayList就行了
        List<String> names = Lists.newArrayList("Richard", "Amy", "Lily", "Sarah");
        List<Integer> numbers = Lists.newArrayList(11, 78, 89, 45, 30);
        System.out.println(names); // [Richard, Amy, Lily, Sarah]
        System.out.println(numbers); // [11, 78, 89, 45, 30]

        // 操作集合类-->反转
        List<String> reverseNames = Lists.reverse(names);
        List<Integer> reverseNumbers = Lists.reverse(numbers);
        System.out.println(reverseNames); // [Sarah, Lily, Amy, Richard]
        System.out.println(reverseNumbers); // [30, 45, 89, 78, 11]

        // 分割集合类
        List<List<String>> nameParts = Lists.partition(names, 2);
        List<List<Integer>> numberParts = Lists.partition(numbers, 2);
        System.out.println(nameParts); // [[Richard, Amy], [Lily, Sarah]]
        System.out.println(numberParts); // [[11, 78], [89, 45], [30]]
    }

    @Test
    public void testSets() {
        Set<String> set1 = Sets.newHashSet("One", "Two", "Three", "Four");
        Set<String> set2 = Sets.newHashSet("Two", "Four", "Five", "Six");

        // 取交集
        Sets.SetView setView = Sets.intersection(set1, set2);
        System.out.println(setView.size()); // 2
        System.out.println(setView.toString()); // [Two, Four]

        // 取并集
        setView = Sets.union(set1, set2);
        System.out.println(setView.size()); // 6
        System.out.println(setView.toString()); // [Two, Three, One, Four, Five, Six]

        // 取差集
        setView = Sets.difference(set1, set2);
        System.out.println(setView.size()); // 2
        System.out.println(setView.toString()); // [Three, One]

        // 取笛卡尔积
        Set<List<String>> product = Sets.cartesianProduct(set1, set2);
        System.out.println(product); // [[Two, Five], [Two, Six], [Two, Two], [Two, Four], [Three, Five], [Three, Six], [Three, Two], [Three, Four], [One, Five], [One, Six], [One, Two], [One, Four], [Four, Five], [Four, Six], [Four, Two], [Four, Four]]

        // 集合所有子集
        Set<Set<String>> sets = Sets.powerSet(set1);
        System.out.println(sets); // powerSet({Two=0, Three=1, One=2, Four=3})


    }

    @Test
    public void testMaps() {
        // 创建Map -> 方法1
        ImmutableMap<String, Integer> left = ImmutableMap
                .of("Richard", 88, "Amy", 90, "Sarah", 87, "Lily", 89);
        ImmutableMap<String, Integer> right = ImmutableMap
                .of("Tom", 78, "Amy", 89, "Richard", 88);

        // 创建Map -> 方法2
        List<String> strings = Lists.newArrayList("Helloo", "World", "Beautiful", "good");
        ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings,
                string -> string.length());
        System.out.println(stringsByIndex); // {6=Helloo, 5=World, 9=Beautiful, 4=good}

        MapDifference<String, Integer> diff = Maps.difference(left, right);

        // 取相同的Entry键值都相同
        System.out.println(diff.entriesInCommon()); // {Richard=88}

        // 取键相同值不同的元素
        System.out.println(diff.entriesDiffering()); // {Amy=(90, 89)}

        // 取左边有右边没有的元素
        System.out.println(diff.entriesOnlyOnLeft()); // {Sarah=87, Lily=89}

        // 取右边有左边没有的元素
        System.out.println(diff.entriesOnlyOnRight()); // {Tom=78}
    }

    @Test
    public void testIterables() {
        List<Integer> ints1 = Lists.newArrayList(1, 2, 1, 4, 6, 9);
        List<Integer> ints2 = Lists.newArrayList(3, 7, 4, 6, 2, 1);

        // 融合两个列表
        Iterable<Integer> iterable = Iterables.concat(ints1, ints2);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        } // 1,2,1,4,6,9,3,7,4,6,2,1,

        // 获取列表中第一个和最后一个元素
        int last = Iterables.getLast(ints1);
        System.out.println(last); // 9

        int first = Iterables.getFirst(ints1, 10000);
        System.out.println(first); // 1

        // 出现频率统计
        int count = Iterables.frequency(ints1, 1);
        System.out.println(count); // 2
    }
}
