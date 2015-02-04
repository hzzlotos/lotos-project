package cn.newtouch.ioc_di;

import org.junit.Test;

public class UserServiceTest
{

    public static void main(String[] args)
    {
        UserServiceTest aaa = new UserServiceTest();
        try
        {
            aaa.testAdd();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd() throws Exception
    {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext();

        UserService service = (UserService) applicationContext.getBean("userService");

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.add(u);
    }

}
