package cn.newtouch.aop;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class PersonServiceTest
{

    @Test
    public void testProxy()
    {
        PersonDAO personDAO = new PersonDAOImpl();
        InterceptorImpl li = new InterceptorImpl();
        li.setTarget(personDAO);

        // 方法newProxyInstance(ClassLoader loader,Class<?>[]
        // interfaces,InvocationHandler h)

        // loader 实例的class.getClassLoader()
        // interfaces 实例的class.getClass()
        // h 预定义好的InvocationHandler
        PersonDAO personDAOProxy = (PersonDAO) Proxy.newProxyInstance(personDAO
                .getClass().getClassLoader(), personDAO.getClass()
                .getInterfaces(), li);
        System.out.println(personDAOProxy.getClass());
        personDAOProxy.delete(new Person());
        personDAOProxy.save(new Person());

    }

}
