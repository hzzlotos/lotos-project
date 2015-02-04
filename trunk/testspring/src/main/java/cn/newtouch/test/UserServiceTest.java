package cn.newtouch.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newtouch.model.User;
import cn.newtouch.service.UserService;

//Dependency Injection
//Inverse of Control
public class UserServiceTest
{
    public static void main(String[] args) throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = (UserService) ctx.getBean("us");
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.doAdd(u);
    }
}