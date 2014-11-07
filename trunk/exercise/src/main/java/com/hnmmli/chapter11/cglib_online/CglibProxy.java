package com.hnmmli.chapter11.cglib_online;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy
{
    public Object createProxy(Class<?> targetClass)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new MyMethodInterceptorImpl());
        return enhancer.create();
    }
}

class MyMethodInterceptorImpl implements MethodInterceptor
{
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable
    {
        System.out.println(">>>MethodInterceptor start...");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println(">>>MethodInterceptor ending...");
        return result + "hahaha";
    }
}