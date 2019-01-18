package com.reflect.entity;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/17
 */
public class Person {

    String name;
    private int age;

    public void print(){
        System.out.println("print");
    }

    public void print(int a,int b){
        System.out.println(a+b);
    }

    public void print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
