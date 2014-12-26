package cn.newtouch.springjms.asyn;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newtouch.Student;

//发送消息服务
public class SpringJMSProducerDemo
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:asyn_applicationContext.xml");
        JMS_Asyn_Producer jmsProducer = (JMS_Asyn_Producer) context.getBean("consumer");
        Student student = new Student();
        student.setName("zhangqi");
        student.setAge("25");
        jmsProducer.send(student);
        System.out.println("消息已经发送.....");
        context.close();
    }
}