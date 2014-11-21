package javacore.chapter11.cglib_online;

public class TestCglibProxy
{
    public static void main(String rags[])
    {
        CglibProxy proxy = new CglibProxy();
        Target proxyTarget = (Target) proxy.createProxy(Target.class);
        String res = proxyTarget.execute();
        System.out.println("the result is " + res);
    }
}