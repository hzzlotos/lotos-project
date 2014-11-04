package com.hnmmli.other11;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TheAnnotationTest
{

    public static void main(String[] args)
    {
        TheAnnotationTest test = new TheAnnotationTest();
        Class<?> clazz = test.getClass();
        for (Method m : clazz.getMethods())
        {
            System.out.println("aa===" + m.getName());
            for (Annotation a : m.getAnnotations())
            {
                if (a.annotationType().equals(AnnotationTest.class))
                {
                    System.out.println("一样的");
                }
            }
        }
        for (Method m : clazz.getDeclaredMethods())
        {
            System.out.println("bb===" + m.getName());
            AnnotationTest at = m.getAnnotation(AnnotationTest.class);
            if (null != at)
            {
                System.out.println(at.theString());
            }
        }
    }

    @AnnotationTest
    private static void test()
    {

    }
}
