package cn.newtouch.proxy.proxyInvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler
{
    private Object obj = null;

    public HelloInvocationHandler(Object real)
    {
        this.obj = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        try
        {
            System.out.println("proxy say hello!");
            method.invoke(this.obj, args);
            System.out.println("parameter===" + args[0]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
