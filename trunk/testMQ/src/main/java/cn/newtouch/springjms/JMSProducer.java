package cn.newtouch.springjms;

import org.springframework.jms.core.JmsTemplate;

import cn.newtouch.Student;
import cn.newtouch.Teacher;

//Description: 利用Spring中的JmsTemplate产生消息

public class JMSProducer
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

    // 在这个示例中我们传送一个Student 对象（重写了toString()方法）
    public void sendStudent(final Student student)
    {
        // this.getJmsTemplate().send(new MessageCreator() {
        //
        // @Override
        // public Message createMessage(Session session) throws JMSException
        // {
        // MapMessage message = session.createMapMessage();
        // message.setString("key1", student.getName());
        // message.setString("key2", student.getAge());
        // return message;
        // }
        // });
        this.getJmsTemplate().convertAndSend(student);
    }

    // 在这个示例中我们传送一个Student 对象（重写了toString()方法）
    public void sendTeacher(final Teacher teacher)
    {
        // this.getJmsTemplate().send(new MessageCreator() {
        //
        // @Override
        // public Message createMessage(Session session) throws JMSException
        // {
        // MapMessage message = session.createMapMessage();
        // message.setString("key1", student.getName());
        // message.setString("key2", student.getAge());
        // return message;
        // }
        // });
        this.getJmsTemplate().convertAndSend(teacher);
    }
}