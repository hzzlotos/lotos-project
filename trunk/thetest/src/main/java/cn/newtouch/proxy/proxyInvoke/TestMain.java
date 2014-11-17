package cn.newtouch.proxy.proxyInvoke;

import java.lang.reflect.Proxy;

public class TestMain
{

    public static void main(String[] args)
    {
        IHello hello = new Hello();
        IHello proxy = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass()
                .getInterfaces(), new HelloInvocationHandler(hello));
        proxy.say("111");
    }

}
