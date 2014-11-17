package cn.newtouch.proxy.generics;

public class Test
{
    public static void main(String[] args)
    {
        Generics<?, ?> aaa = new GTest();
        System.out.println(aaa.init().getClass());
    }
}