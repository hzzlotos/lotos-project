package javacore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler
{
    private Object target;

    public MyHandler(Object t)
    {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object o = null;
        System.out.println("方法执行开始");
        o = method.invoke(this.target, args);
        System.out.println("方法执行完毕");
        return o;
    }

}
