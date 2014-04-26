//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: Administrator
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package com.hnmmli.reflective;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectiveTest
{

    public static void main(String[] args)
    {
        // theClass();
        // newInstance();
        // field();
        // method();
    }

    private static void theClass()
    {
        System.out.println(long.class);
        System.out.println(Long.class);
        System.out.println("========class========");
        // 第一种
        Class clazz = Test.class;
        System.out.println(clazz.getName());
        // 第二种
        Test t = new Test();
        clazz = t.getClass();
        System.out.println("class===" + clazz.getName());
        System.out.println("========class========");
        // 第三种
        try
        {
            clazz = Class.forName("com.hnmmli.reflective.Itest");
            System.out.println(clazz.getName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("=========class=======");

        System.out.println(t.getClass().isInterface());

        Class parent = t.getClass().getSuperclass();// 显示所继承的父类
        System.out.println("parent class ===" + parent.getName());
        System.out.println("=========parent class=======");

        Class[] iClazz = t.getClass().getInterfaces(); // 显示直接实现的借口
        for (Class temp : iClazz)
        {
            System.out.println(temp.isAnnotation());
            System.out.println(temp.isInterface());
            System.out.println(temp.toString());
        }
        System.out.println("----------------------------");
    }

    private static void newInstance()
    {
        try
        {
            Itest test = Test.class.newInstance();

            System.out.println(test.getI_a() + "===" + test.i_z);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void field()
    {
        // 取得所有对外的公开属性,包括父类继承来的的,接口继承来的
        Field[] fields = Test.class.getFields();
        for (Field field : fields)
        {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println("=====================");
            // 其中输出有
            // iT_d
            // double
            // public static final 父类属性在子类中是静态且不可修改的
        }
        System.out.println("--------------------------");
        // 取得当前类中的所有属性,包括私有的
        fields = Test.class.getDeclaredFields();
        for (Field field : fields)
        {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println("=====================");
        }
    }

    private static void method()
    {
        // 取得所有对外的公开方法,包括父类继承来的
        Method[] methods = Test.class.getMethods();
        Class[] params;
        for (Method method : methods)
        {
            System.out.println("==========method start===========");
            System.out.println("name====" + method.getName());
            params = method.getParameterTypes();
            for (Class clazz : params)
            {
                System.out.println("==========ParameterType===========");
                System.out.println(clazz.getName());
                System.out.println("==========ParameterType===========");
            }
            System.out.println("ReturnType====" + method.getReturnType().getName());
            System.out.println("Modifier=====" + Modifier.toString(method.getModifiers()));
            System.out.println("==========method end===========");
        }
        System.out.println("--------------------------");
        // 取得当前类中的所有方法,包括私有的
        methods = Test.class.getDeclaredMethods();
        for (Method method : methods)
        {
            System.out.println("==========method start===========");
            System.out.println("name====" + method.getName());
            params = method.getParameterTypes();
            for (Class clazz : params)
            {
                System.out.println("==========ParameterType===========");
                System.out.println(clazz.getName());
                System.out.println("==========ParameterType===========");
            }
            System.out.println("ReturnType====" + method.getReturnType().getName());
            System.out.println("Modifier=====" + Modifier.toString(method.getModifiers()));
            System.out.println("==========method end===========");
        }
    }
}

interface ITemp<A, V>
{
    public double iT_d = 10D;
}

interface Itest
{
    public int i_z = 7;

    public String getI_a();
}

class SuperTest implements Itest
{

    protected String s_a;

    public String getI_a()
    {
        return "" + i_z;
    }
}

class Test extends SuperTest implements ITemp
{

    private String a = "hello";

    double         b;

    public int     c;

    @Override
    public String getI_a()
    {
        return this.a;
    }

    public void setI_a(String a)
    {
        this.a = a;
    }

    protected void show()
    {
        System.out.println(super.s_a);
    }

    private int addC(int x)
    {
        return this.c + x;
    }
}

@AnnotationTest()
class Anno1Test
{

}

@AnnotationTest(clazz = Integer.class, hello = "name")
class Anno2Test
{

}