package cn.newtouch.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newtouch.model.User;

//Dependency Injection
//Inverse of Control
public class UserServiceTest_aopxml
{
    @Test
    public void testAdd() throws Exception
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_aopxml.xml");
        UserService service = (UserService) ctx.getBean("userService");
        System.out.println(service.getClass());
        service.doAdd(new User());
        ctx.destroy();
    }
}