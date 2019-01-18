package com.reflect.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/18
 */
public class FieldClassTest {

    @Test
    public void test01() {
        String str = "haha";
        printFieldMessage(new Integer(1));
    }


    /**
     * 打印成员变量的信息
     * <p>
     * 成员变量也是对象，所属Field对象，一个成员变量对应一个Field对象
     * Field类封装了关于成员变量的操作
     * java.lang.reflect.Field
     * <p>
     * getFields()方法获取修饰符为public的成员变量
     * getDeclaredFields()获取所有成员变量（包括private）
     *
     * @param obj 该对象所属的类
     */
    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //获取成员变量的类类型
            Class type = fields[i].getType();
            String typeName = type.getName();
            //获取成员变量名称
            String fieldName = fields[i].getName();
            System.out.println(typeName + "\t" + fieldName + ";");
        }
    }

}
