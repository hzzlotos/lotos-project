package cn.newtouch.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newtouch.model.User;

//Dependency Injection
//Inverse of Control
public class UserServiceTest
{

    @Test
    public void testAdd() throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserService service = (UserService) ctx.getBean("us");

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.doAdd(u);
    }

}
