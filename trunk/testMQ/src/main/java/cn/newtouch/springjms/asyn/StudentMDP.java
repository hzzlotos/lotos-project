package cn.newtouch.springjms.asyn;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import cn.newtouch.Student;

/**
 * Title:
 * Description: 消息监听类
 * Copyright: Copyright (c)2010
 * Company: YeePay
 * 
 * @author qi.zhang
 * */
public class StudentMDP implements MessageListener
{
    @Override
    public void onMessage(Message message)
    {
        MapMessage mapMessage = (MapMessage) message;
        Student student = new Student();
        try
        {
            student.setName(mapMessage.getString("key1"));
            student.setAge(mapMessage.getString("key2"));
            System.out.println("我是异步消息出来的结果" + student.getName());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
}