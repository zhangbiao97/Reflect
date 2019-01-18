package com.reflect.test;

import com.reflect.entity.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/17
 */
public class ReflectTest {

    /**
     * 万物皆对象，类也是对象，是Class类的实例对象，这个对象我们称为该类的类类型
     * 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
     */
    @Test
    public void test01() {
        //Person实例对象
        Person p1 = new Person();

        //第一种表示方式：类名.class ——> 实际在告诉我们任何一个都有一个隐含的静态成员变量class
        Class c1 = Person.class;

        //第二种表达方式：对象名.getClass()
        Class c2 = p1.getClass();

        //c1,c2都代表了Person类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        //第三种表达方式：Class.forName("全类名");
        Class c3 = null;
        try {
            c3 = Class.forName("com.reflect.entity.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);


    }


}
