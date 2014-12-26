package cn.newtouch.springjms;

import org.springframework.jms.core.JmsTemplate;

import cn.newtouch.Student;

//Description: 利用Spring中的JmsTemplate消费消息

public class JMSReceiver
{
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate()
    {
        return this.jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate)
    {
        this.jmsTemplate = jmsTemplate;
    }

    public void receive()
    {
        // MapMessage message = (MapMessage) this.getJmsTemplate().receive();
        // try
        // {
        // if (message != null)
        // {
        // System.out.println(message.getString("key1") + message.getString("key2"));
        // }
        // else
        // {
        // System.out.println("未接收到内容");
        // }
        // }
        // catch (JMSException e)
        // {
        // e.printStackTrace();
        // }
        Student s = (Student) this.getJmsTemplate().receiveAndConvert();
        System.out.println(s.getName());
    }
}