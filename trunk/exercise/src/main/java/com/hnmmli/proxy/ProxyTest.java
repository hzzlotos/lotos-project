package com.hnmmli.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest
{

    public static void main(String[] args)
    {
        InvocationInterface invocation = new Invocation();

        InvocationInterface proxy = (InvocationInterface) Proxy.newProxyInstance(
                invocation.getClass().getClassLoader(), invocation.getClass().getInterfaces(),
                new MyHandler(invocation));
        proxy.sayHello();
        System.out.println("========================");
        proxy.sayBye();
    }
}
