package com.hnmmli.reflective;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.hnmmli.enumtest.EnumTest;

public class ReflectiveTest
{

    public static void main(String[] args)
    {
        // theClass();
        // newInstance();
        // field();
        // method();
        // annoTest();
        invoke();
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
        Field field = null;
        for (Field temp : fields)
        {
            System.out.println(temp.getName());
            System.out.println(temp.getType());
            System.out.println(Modifier.toString(temp.getModifiers()));
            System.out.println("=====================");
            // 其中输出有
            // iT_d
            // double
            // public static final 父类属性在子类中是静态且不可修改的
        }
        System.out.println("--------------------------");
        // 取得当前类中的所有属性,包括私有的
        fields = Test.class.getDeclaredFields();
        for (Field temp : fields)
        {
            System.out.println(temp.getName());
            System.out.println(temp.getType());
            System.out.println(Modifier.toString(temp.getModifiers()));
            System.out.println("=====================");
        }
        System.out.println("--------------------------");
        try
        {
            Test test = Test.class.newInstance();
            field = Test.class.getDeclaredField("a");
            // field.set(test, "haha"); // 私有属性不可赋值
            // System.out.println(field.get(test));// 私有属性不可取值
            field = Test.class.getField("c");
            Object c = field.get(test);
            System.out.println(c);
            field.set(test, 5);
            System.out.println(field.get(test));
        }
        catch (Exception e)
        {
            e.printStackTrace();
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

    private static void annoTest()
    {
        Annotation[] annos = AnnoTest.class.getAnnotations();
        for (Annotation anno : annos)
        {
            System.out.println(anno.annotationType());
        }
        if (AnnoTest.class.isAnnotationPresent(AnnotationTest.class))
        {
            System.out.println("class have AnnotationTest");
            AnnotationTest annotationTest = AnnoTest.class.getAnnotation(AnnotationTest.class);
            EnumTest enumTest = annotationTest.lamp();
            System.out.println(annotationTest.hello());
            System.out.println(enumTest);
            int[] i = annotationTest.array();
            System.out.println(i[0] + " " + i[1]);
        }
        System.out.println("=======================================");
        try
        {
            Field field = AnnoTest.class.getDeclaredField("name");
            Method method = AnnoTest.class.getDeclaredMethod("showName");
            if (field.isAnnotationPresent(Annotation2Test.class))
            {
                System.out.println("field have Annotation2Test");
                Annotation2Test annotation2Test = field.getAnnotation(Annotation2Test.class);
                System.out.println("annotation2Test.show()========" + annotation2Test.show());
            }
            if (method.isAnnotationPresent(Annotation2Test.class))
            {
                System.out.println("method have Annotation2Test");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void invoke()
    {
        try
        {
            Test t = Test.class.newInstance();
            // 需将参数类型带上,顺序必须匹配好
            Method method = Test.class.getMethod("setI_a", String.class, int.class);
            // 参数不匹配
            // Method method = Test.class.getMethod("setI_a");
            // 参数顺序不匹配
            // Method method = Test.class.getMethod("setI_a", int.class, String.class);
            method.invoke(t, "aaa", 0);
            System.out.println(t.getI_a());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

// =======================================================================
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

    public void setI_a(String a, int k)
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

@AnnotationTest(clazz = Integer.class, hello = "hello,id")
class AnnoTest
{
    @Annotation2Test(show = "hello show")
    private String name  = "hehe";

    public String  name2 = "hehe";

    @Annotation2Test()
    public void showName()
    {
        System.out.println("name is " + this.name);
    }
}