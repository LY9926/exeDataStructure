package test;

/**
 * @author ly
 * @date 2019/6/11 10:35
 */
public class Person implements Comparable<Person>{
    private Integer age;
    private String name;
    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    //A与B比较 当A的年龄-B的年龄
    @Override
    public int compareTo(Person o) {
        Person p = (Person)o;
        return this.age - p.age;
    }
}
