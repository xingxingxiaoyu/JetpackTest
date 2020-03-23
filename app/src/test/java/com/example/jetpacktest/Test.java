package com.example.jetpacktest;

import java.lang.reflect.Method;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/28
 */
public class Test {
    @org.junit.Test
    public void test(){
        System.out.println(String.class.getCanonicalName());
        Method[] declaredMethods = Test.class.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            System.out.println(method.getName()+" "+method.getDeclaringClass().getName());
        }
        System.out.println("=============");

        Method[] methods = Test.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method.getName()+" "+method.getDeclaringClass().getName());
        }
    }

    private void ttt(){}
}
