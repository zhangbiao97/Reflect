package com.reflect.test;

import com.reflect.entity.Person;
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
     * 通过反射来调用方法
     *
     * invoke：调用方法
     */
    @Test
    public void test02(){
        Person p=new Person();
        Class c = p.getClass();
        try {
            //print(int,int)
            Method printMethod = c.getMethod("print", int.class, int.class);
            printMethod.invoke(p,10,20);
            System.out.println("---------------------");
            //print(String,String)
            Method printMethod2 = c.getMethod("print", String.class, String.class);
            printMethod2.invoke(p,"hello","WORLD");
            System.out.println("---------------------");
            Method printMethod3 = c.getMethod("print");
            printMethod3.invoke(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 打印类信息，包括类中的成员函数，成员函数的返回类型，成员函数的参数列表
     * <p>
     * 成员方法也是对象，Method类，方法对象
     * 一个成员方法就是一个Method对象
     * java.lang.reflect.Method
     * <p>
     * getMethods()方法获取所有public的方法，包括父类继承过来的
     * getDeclaredMethods()方法获取自己声明的方法（包括private）
     *
     * @param obj
     */
    public static void printClassMessage(Object obj) {
        Class c1 = obj.getClass();
        //打印类的名称
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
