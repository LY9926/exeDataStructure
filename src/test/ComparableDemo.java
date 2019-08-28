package test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ly
 * @date 2019/6/11 10:36
 */
public class ComparableDemo{
    public static void main(String[] args) {
        Object[] objArray = {new Person(20,"jack"),new Person(17,"tom"),
                new Person(27,"aj")};
        for (Object object : objArray) {
            System.out.println(object.toString());
        }
        Arrays.sort(objArray);

        for (Object object : objArray) {
            System.out.println(object.toString());
        }

    }
}
