package cn.newtouch.transaction.proxy.commonutils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.newtouch.transaction.proxy.commonutils.connection.threadlocal.TransactionManager;

public class TransactionProxyManager
{
    private TransactionManager transactionManager;

    public TransactionProxyManager(TransactionManager transactionManager)
    {
        this.transactionManager = transactionManager;
    }

    public Object proxyFor(Object object)
    {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new TransactionInvocationHandler(object, this.transactionManager));
    }
}

class TransactionInvocationHandler implements InvocationHandler
{
    private Object             proxy;

    private TransactionManager transactionManager;

    TransactionInvocationHandler(Object object, TransactionManager transactionManager)
    {
        this.proxy = object;
        this.transactionManager = transactionManager;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable
    {
        Object result = null;
        Method m = this.proxy.getClass().getMethod(method.getName(), method.getParameterTypes());
        Transactional t = m.getAnnotation(Transactional.class);
        if (null == t)
        {
            System.out.println("没有写注释的是===" + m.getName());
            return method.invoke(this.proxy, objects);
        }

        this.transactionManager.start();
        try
        {
            result = method.invoke(this.proxy, objects);
            this.transactionManager.commit();
        }
        catch (Exception e)
        {
            this.transactionManager.rollback();
            throw e;
        }
        finally
        {
            this.transactionManager.close();
        }
        return result;
    }
}
