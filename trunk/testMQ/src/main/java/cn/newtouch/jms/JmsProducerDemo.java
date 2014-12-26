package cn.newtouch.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import cn.newtouch.Student;
import cn.newtouch.StudentMessageConverter;

/**
 * Description: 消息产生类
 */
public class JmsProducerDemo
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
            // 设置消息目的地类型（ActiveMQTopic为订阅目的地）
            Destination destination = new ActiveMQQueue("myQueue");
            MessageProducer producer = session.createProducer(destination);
            // 文本格式
            // TextMessage message = session.createTextMessage();
            // message.setText("Just a simaple JMS Testing.");
            // producer.send(message);

            Student student = new Student();
            student.setName("zq");
            student.setAge("25");
            // 使用消息转换
            StudentMessageConverter studentConverter = new StudentMessageConverter();
            producer.send(studentConverter.toMessage(student, session));
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
        finally
        {

            if (session != null)
            {
                try
                {
                    session.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}