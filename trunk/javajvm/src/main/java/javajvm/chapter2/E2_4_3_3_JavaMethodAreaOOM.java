package javajvm.chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * cglib代理的时候不要使用内部定义类！
 */
public class E2_4_3_3_JavaMethodAreaOOM
{
    public static void main(String[] args)
    {
        while (true)
        {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] methodParameters, MethodProxy methodProxy)
                        throws Throwable
                {
                    return methodProxy.invokeSuper(obj, methodParameters);
                }
            });
            enhancer.create();
        }
    }
}