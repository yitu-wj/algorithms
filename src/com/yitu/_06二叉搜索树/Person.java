package com.yitu._06二叉搜索树;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

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

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age-o.age;
    }

    @Override
    public String toString() {
        return name+"_"+age;
    }
}
