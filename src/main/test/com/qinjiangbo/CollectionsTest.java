package com.qinjiangbo;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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

    }

    @Test
    public void testMultiSets() {

    }

    @Test
    public void testMultiMaps() {

    }
}
