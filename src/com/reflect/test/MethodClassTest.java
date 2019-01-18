package com.reflect.test;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/18
 */
public class MethodClassTest {


    @Test
    public void test01() {
        String str = "haha";
        printClassMessage(str);
    }


    /**
     * 打印类信息，包括类中的成员函数，成员函数的返回类型，成员函数的参数列表
     * @param obj
     */
    public static void printClassMessage(Object obj) {
        Class c1 = obj.getClass();
        System.out.println("类的名称是：" + c1.getName());
        //获取修饰符为public的方法
        Method[] methods = c1.getMethods();
        //获取所有的方法（包括private,protected）
        //Method[] declaredMethods = c1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            //获取返回类型的类类型
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + "\t");
            //获取方法名称
            String methodName = methods[i].getName();
            System.out.print(methodName + "(");
            //获取每个方法中的参数类型，
            Class[] parameterTypes = methods[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                //参数类型名称（不包括包名）
                System.out.print(parameterTypes[j].getSimpleName() + ",");
            }
            System.out.print(")");
            System.out.println();
        }
    }
}
