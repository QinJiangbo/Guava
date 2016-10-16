package com.qinjiangbo;

import com.google.common.collect.Lists;
import com.google.common.reflect.Reflection;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

interface People {
    void printPeople();
}

/**
 * Date: 17/10/2016
 * Author: qinjiangbo@github.io
 */
public class ReflectionTest {

    /**
     * 测试JDK的动态代理功能
     */
    @Test
    public void testJDKProxy() {
        People student = new Student("Qin Jiangbo", 23);
        People people = (People) Proxy.newProxyInstance(
                People.class.getClassLoader(),
                new Class[]{People.class},
                getHandler(student));
        people.printPeople();
    }

    /**
     * 测试Guava的动态代理
     */
    @Test
    public void testGuavaProxy() {
        People student = new Student("Qin Jiangbo", 23);
        People people = Reflection.newProxy(People.class, getHandler(student));
        people.printPeople();
    }

    public InvocationHandler getHandler(Object proxiedObject) {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method name: " + method.getName());
                System.out.println("args: " + (args == null ? "null" : args));
                return method.invoke(proxiedObject, args);
            }
        };
    }

    @Test
    public void testTypeToken() {
        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        // 类型被擦除了
        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));
        // 利用TypeToken解析原来的类型
        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {
        };
        TypeToken<?> genericType = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericType.getType());
    }

}

class Student implements People {

    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 打印People信息
     */
    public void printPeople() {
        System.out.println("name: " + name + ", age: " + age);
    }

}
