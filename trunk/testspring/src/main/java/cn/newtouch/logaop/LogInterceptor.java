package cn.newtouch.logaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor
{
    // 如果所需切片类没有实现接口,需要cglib-nodep-2.2.jar
    @Pointcut("execution(public * cn.newtouch.service..*.do*(..))")
    public void myMethod()
    {
    };

    @Before("myMethod()")
    public void before()
    {
        System.out.println("method before");
    }

    @AfterReturning("myMethod()")
    public void afterReturning()
    {
        System.out.println("method after returning");
    }

    @Around("myMethod()")
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("method around start");
        pjp.proceed();
        System.out.println("method around end");
    }

}
