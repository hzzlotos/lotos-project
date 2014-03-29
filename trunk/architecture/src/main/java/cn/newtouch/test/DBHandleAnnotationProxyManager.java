package cn.newtouch.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.newtouch.test.transactional.TransactionManager;
import cn.newtouch.test.transactional.Transactional;

public class DBHandleAnnotationProxyManager
{
    private TransactionManager transactionManager;

    public DBHandleAnnotationProxyManager(TransactionManager transactionManager)
    {

        this.transactionManager = transactionManager;
    }

    public Object proxyFor(Object object)
    {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new AnnotationTransactionInvocationHandler(object, this.transactionManager));
    }
}

class AnnotationTransactionInvocationHandler implements InvocationHandler
{

    private Object             proxied;

    private TransactionManager transactionManager;

    AnnotationTransactionInvocationHandler(Object object, TransactionManager transactionManager)
    {
        this.proxied = object;
        this.transactionManager = transactionManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable
    {
        Method originalMethod = this.proxied.getClass().getMethod(method.getName(), method.getParameterTypes());

        Object result = null;

        if (!originalMethod.isAnnotationPresent(Transactional.class))
        {
            result = method.invoke(this.proxied, objects);
            this.transactionManager.close();
            return result;
        }

        this.transactionManager.start();

        try
        {
            result = method.invoke(this.proxied, objects);
            this.transactionManager.commit();
        }
        catch (Exception e)
        {
            this.transactionManager.rollback();
            e.printStackTrace();
        }
        finally
        {
            this.transactionManager.close();
        }

        return result;
    }
}