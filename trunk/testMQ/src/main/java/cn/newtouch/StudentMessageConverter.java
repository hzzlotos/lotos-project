package cn.newtouch;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

// Description: 消息转换类
public class StudentMessageConverter implements MessageConverter
{
    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException
    {
        if (!(message instanceof MapMessage))
        {
            throw new MessageConversionException("Message is not a MapMessage");
        }
        MapMessage mapMessage = (MapMessage) message;
        Student student = new Student();
        student.setName(mapMessage.getString("key1"));
        student.setAge(mapMessage.getString("key2"));
        return student;
    }

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException
    {
        if (!(object instanceof Student))
        {
            throw new MessageConversionException("Object is not a student");
        }
        Student student = (Student) object;
        MapMessage message = session.createMapMessage();
        message.setString("key1", student.getName());
        message.setString("key2", student.getAge());
        return message;
    }
}