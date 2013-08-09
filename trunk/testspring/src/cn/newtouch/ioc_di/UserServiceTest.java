package cn.newtouch.ioc_di;

import org.junit.Test;

public class UserServiceTest
{

    @Test
    public void testAdd() throws Exception
    {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext();

        UserService service = (UserService) applicationContext
                .getBean("userService");

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.add(u);
    }

}
