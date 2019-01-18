package com.reflect.test;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/18
 */
public class ConstructorClassTest {


    @Test
    public void test01() {
        printConstructorMessage(new Integer(1));
    }

    /**
     * 打印构造函数的信息
     * <p>
     * 构造函数也是对象，一个构造函数对应一个Constructor对象
     * Constructor类封装了对构造函数的操作
     * java.lang.reflect.Constructor
     * <p>
     * getConstructors()获取所有修饰符public的构造函数
     * getDeclaredConstructors()获取所有构造函数（包括private）
     *
     * @param obj
     */
    public static void printConstructorMessage(Object obj) {
        Class c = obj.getClass();
        //获取所有构造函数
        Constructor[] constructors = c.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            String name = constructors[i].getName();
            System.out.print(name + "(");
            //获取构造函数的参数的类类型
            Class[] parameterTypes = constructors[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                String typeName = parameterTypes[j].getName();
                System.out.print(typeName + ",");
            }
            System.out.println(")");
        }
    }

}
