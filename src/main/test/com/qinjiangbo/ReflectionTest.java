package com.qinjiangbo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method name: " + method.getName());
                        System.out.println("args: " + (args == null ? "null" : args));
                        return method.invoke(student, args);
                    }
                });
        people.printPeople();
    }

    /**
     * 测试Guava的动态代理
     */
    @Test
    public void testGuavaProxy() {

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
