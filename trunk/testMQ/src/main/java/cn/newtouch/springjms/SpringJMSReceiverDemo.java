package cn.newtouch.springjms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//消息消费测试类
public class SpringJMSReceiverDemo
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JMSReceiver jmsReceiver = (JMSReceiver) context.getBean("receiver");
        jmsReceiver.receive();
        context.close();
    }
}