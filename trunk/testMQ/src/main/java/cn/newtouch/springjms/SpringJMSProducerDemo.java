package cn.newtouch.springjms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newtouch.Student;
import cn.newtouch.Teacher;

//发送消息服务
public class SpringJMSProducerDemo
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JMSProducer jmsProducer = (JMSProducer) context.getBean("consumer");
        Student student = new Student();
        student.setName("student");
        student.setAge("16");
        jmsProducer.sendStudent(student);
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setAge("25");
        jmsProducer.sendTeacher(teacher);
        System.out.println("消息已经发送.....");
        context.close();
    }
}