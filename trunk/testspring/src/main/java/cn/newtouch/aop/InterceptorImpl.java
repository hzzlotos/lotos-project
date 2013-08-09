package cn.newtouch.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//实例的代理调用处理程序(方法)的接口。
//在代理对象执行方法时,可以在invoke方法中定义别的业务逻辑
public class InterceptorImpl implements InvocationHandler
{
    private Object target;

    public void setTarget(Object target)
    {
        this.target = target;
    }

    public void beforeMethod(Method m)
    {
        System.out.println(m.getName() + " start");
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        this.beforeMethod(m);
        m.invoke(this.target, args);
        return null;
    }
}
