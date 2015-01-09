package javacore.generics;

import java.io.Serializable;

public class GenericsTest
{
    public static void main(String[] args)
    {
        GenericsExtend<A> ga = new GenericsExtend<A>();

        GenericsExtend<B> gb = new GenericsExtend<B>();

        if (ga.getClass().equals(gb.getClass()))
        {
            // 说明并不比较泛型,比较的只是GenericsExtend的类型
            System.out.println("居然是一样的");
        }
        A a = new A();
        B b = new B();
        MethodGenerics.get(new Pair<A, A>(a, a));
        System.out.println("=============");
        MethodGenerics.get(new Pair<B, A>(b, a));
    }
}

class A implements Comparable, Serializable
{
    public int compareTo(Object o)
    {
        return 0;
    }
}

class B extends A
{
}