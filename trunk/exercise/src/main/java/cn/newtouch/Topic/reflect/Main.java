package cn.newtouch.Topic.reflect;

import java.lang.reflect.Method;

public class Main
{

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception
    {

        ArithmeticReflec arr = new ArithmeticReflec();

        int res = (Integer) arr.doMethod("com.drcl.reflect.Arithmetic",
                "addition", new Object[] { 1, 2 });

        Class clazz = Class.forName("com.drcl.reflect.Arithmetic");

        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("addition", int.class, int.class);
        int res2 = (Integer) method.invoke(obj, 1, 2);
        System.out.println(res);
        System.out.println(res2);
    }
}
