package com.qinjiangbo;

import com.google.common.collect.Lists;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.Reflection;
import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

interface People {
    void printPeople();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ABC {
    String value() default "Hello";
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
        return (proxy, method, args) -> {
            System.out.println("method name: " + method.getName());
            System.out.println("args: " + (args == null ? "null" : args));
            return method.invoke(proxiedObject, args);
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
        System.out.println(genericType.getType()); // class java.lang.String
    }

    @Test
    public void testInvokable() throws NoSuchMethodException {
        Invokable invokable = Invokable.from(Student.class.getMethod("add", int.class, int.class));
        System.out.println(invokable.isPublic()); // true
        System.out.println(invokable.getDeclaringClass()); // class com.qinjiangbo.Student
        System.out.println(invokable.getParameters()); // [int arg0, int arg1]
        System.out.println(invokable.getOwnerType()); // com.qinjiangbo.Student
        System.out.println(invokable.getExceptionTypes()); // [java.lang.NumberFormatException]
        System.out.println(invokable.getReturnType()); // int
        System.out.println(invokable.getModifiers()); // 1
        System.out.println(invokable.getName()); // add
        System.out.println(invokable.isOverridable()); // true
        System.out.println(invokable.isVarArgs()); // false
        System.out.println(invokable.isPublic()); // true
        System.out.println(invokable.isAbstract()); // false
        System.out.println(invokable.isAccessible()); // false
        System.out.println(invokable.isAnnotationPresent(ABC.class)); // true
        System.out.println(invokable.isStatic()); // false
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

    /**
     * 两个数之和
     *
     * @param a
     * @param b
     * @return
     */
    @ABC
    public int add(int a, int b) throws NumberFormatException {
        return a + b;
    }
}
