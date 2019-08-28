package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author ly
 * @date 2019/6/14 16:12
 */

class Dog {
    private String name;
    private int age;

    private Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


