package cn.newtouch.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import cn.newtouch.Student;
import cn.newtouch.StudentMessageConverter;

/**
 * Description: 消息接收类
 */
public class JmsReceiverDemo
{
    public static void main(String[] args)
    {
        // 产生连接工厂
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try
        {
            // 产生连接
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 设置消息目的地类型
            Destination destination = new ActiveMQQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            conn.start();
            Message message = consumer.receive();
            // 文本格式
            // TextMessage textMessage = (TextMessage) message;
            // System.out.println(textMessage.getText());

            // 使用消息转换
            StudentMessageConverter studentConverter = new StudentMessageConverter();
            System.out.println(((Student) studentConverter.fromMessage(message)).getName());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (session != null)
                {
                    session.close();
                }
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}