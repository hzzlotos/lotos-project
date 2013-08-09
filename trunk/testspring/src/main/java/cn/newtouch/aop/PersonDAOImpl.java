package cn.newtouch.aop;

import org.springframework.stereotype.Component;

@Component
public class PersonDAOImpl implements PersonDAO
{
    public void save(Person user)
    {
        System.out.println("user saved!");
    }

    public void delete(Person user)
    {
        System.out.println("user deleted!");
    }

}
