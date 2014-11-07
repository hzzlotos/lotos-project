package net.newtouch.javamail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender
{
    // 邮件附件的文件名
    private String[] attachFileNames;

    // 邮件的文本内容
    private String   content;

    // 邮件发送者的地址
    private String   fromAddress;

    private boolean  isText;

    // 发送邮件的服务器的IP和端口
    private String   mailServerHost;

    private String   mailServerPort = "25";

    private String   password;

    // 邮件主题
    private String   subject;

    // 邮件接收者的地址
    private String   toAddress;

    // 登陆邮件发送服务器的用户名和密码
    private String   userName;

    public String[] getAttachFileNames()
    {
        return this.attachFileNames;
    }

    public String getContent()
    {
        return this.content;
    }

    public String getFromAddress()
    {
        return this.fromAddress;
    }

    public String getMailServerHost()
    {
        return this.mailServerHost;
    }

    public String getMailServerPort()
    {
        return this.mailServerPort;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public String getToAddress()
    {
        return this.toAddress;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public boolean isText()
    {
        return this.isText;
    }

    /**
     * 以文本格式发送邮件
     * 
     * @param mailInfo 待发送的邮件的信息
     */
    public boolean sendMail()
    {
        // 判断是否需要身份认证
        // 如果需要身份认证，则创建一个密码验证器
        MyAuthenticator authenticator = new MyAuthenticator(this.userName, this.password);
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(this.getProperties(), authenticator);
        try
        {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(this.fromAddress);
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(this.toAddress);
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(this.subject);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());

            if (this.isText)
            {
                // 设置邮件消息的主要内容
                String mailContent = this.content;
                mailMessage.setText(mailContent);
            }
            else
            {
                // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
                Multipart mainPart = new MimeMultipart();
                // 创建一个包含HTML内容的MimeBodyPart
                BodyPart html = new MimeBodyPart();
                // 设置HTML内容
                html.setContent(this.content, "text/html; charset=utf-8");
                mainPart.addBodyPart(html);
                // 将MiniMultipart对象设置为邮件内容
                mailMessage.setContent(mainPart);
            }

            // 发送邮件
            Transport.send(mailMessage);
            return true;
        }
        catch (MessagingException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public void setAttachFileNames(String[] fileNames)
    {
        this.attachFileNames = fileNames;
    }

    public void setContent(String textContent)
    {
        this.content = textContent;
    }

    public void setFromAddress(String fromAddress)
    {
        this.fromAddress = fromAddress;
    }

    public void setMailServerHost(String mailServerHost)
    {
        this.mailServerHost = mailServerHost;
    }

    public void setMailServerPort(String mailServerPort)
    {
        this.mailServerPort = mailServerPort;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setText(boolean isText)
    {
        this.isText = isText;
    }

    public void setToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * 获得邮件会话属性
     */
    private Properties getProperties()
    {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", this.mailServerHost);
        properties.setProperty("mail.smtp.port", this.mailServerPort);
        properties.setProperty("mail.smtp.socketFactory.port", this.mailServerPort);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    public static void main(String[] args)
    {
        // 这个类主要是设置邮件
        MailSender mail = new MailSender();
        mail.setMailServerHost("smtp.gmail.com");
        mail.setMailServerPort("465");
        mail.setUserName("hzzlotos@gmail.com");
        mail.setPassword("zhzh1shiwo");// 您的邮箱密码
        mail.setFromAddress("hzzlotos@gmail.com");
        mail.setToAddress("lotus_lotos@hotmail.com");
        mail.setSubject("设置邮箱标题 11111111111111111111111111111");
        mail.setContent("设置邮箱内容 2222222222222222222222222222222222222222222222222");
        mail.setText(true);
        mail.sendMail();// 发送文体格式
        mail.setText(false);
        mail.sendMail();// 发送html格式
    }
}

class MyAuthenticator extends Authenticator
{
    String userName = null;

    String password = null;

    public MyAuthenticator()
    {
    }

    public MyAuthenticator(String username, String password)
    {
        this.userName = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(this.userName, this.password);
    }
}