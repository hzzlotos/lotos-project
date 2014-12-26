package com.andyao.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:com/andyao/activemq/applicationContext-activemq.xml");
        TopicMessageProducer fmpa = (TopicMessageProducer) context.getBean("topicMessageProducer");
        QueueMessageProducer fmpb = (QueueMessageProducer) context.getBean("queueMessageProducer");
        int count = 1;
        while (count < 100)
        {
            FooMessage fm = new FooMessage();
            fm.setId(count);
            fmpa.send(fm);
            fmpb.send(fm);
            count++;
            System.out.println(count);
        }
    }
}
