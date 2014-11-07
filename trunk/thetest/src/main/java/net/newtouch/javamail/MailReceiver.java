package net.newtouch.javamail;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * 有一封邮件就需要建立一个ReciveMail对象
 */
public class MailReceiver
{
    private StringBuffer bodytext       = new StringBuffer(); // 存放邮件内容

    private String       dateformat     = "yy-MM-dd HH:mm";  // 默认的日前显示格式

    private MimeMessage  mimeMessage    = null;

    private String       saveAttachPath = "";                // 附件下载后的存放目录

    public MailReceiver(MimeMessage mimeMessage)
    {
        this.mimeMessage = mimeMessage;
    }

    /**
     * PraseMimeMessage类测试
     */
    public static void main(String args[]) throws Exception
    {
        Properties props = System.getProperties();
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session session = Session.getDefaultInstance(props, null);
        URLName urln = new URLName("pop3", "pop.gmail.com", 995, null, "hzzlotos@gmail.com", "zhzh1shiwo");
        Store store = session.getStore(urln);
        store.connect();
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message message[] = folder.getMessages();
        System.out.println("Messages's length: " + message.length);
        MailReceiver mr = null;
        for (int i = 0; i < message.length; i++)
        {
            System.out.println("======================");
            mr = new MailReceiver((MimeMessage) message[i]);
            System.out.println("Message " + i + " subject: " + mr.getSubject());
            System.out.println("Message " + i + " sentdate: " + mr.getSentDate());
            System.out.println("Message " + i + " replysign: " + mr.getReplySign());
            System.out.println("Message " + i + " hasRead: " + mr.isNew());
            System.out.println("Message " + i + "  containAttachment: " + mr.isContainAttach(message[i]));
            System.out.println("Message " + i + " form: " + mr.getFrom());
            System.out.println("Message " + i + " to: " + mr.getMailAddress("to"));
            System.out.println("Message " + i + " cc: " + mr.getMailAddress("cc"));
            System.out.println("Message " + i + " bcc: " + mr.getMailAddress("bcc"));
            mr.setDateFormat("yy年MM月dd日 HH:mm");
            System.out.println("Message " + i + " sentdate: " + mr.getSentDate());
            System.out.println("Message " + i + " Message-ID: " + mr.getMessageId());
            // 获得邮件内容===============
            mr.getMailContent(message[i]);
            System.out.println("Message " + i + " bodycontent: \r\n" + mr.getBodyText());
            mr.setAttachPath("c:\\");
            mr.saveAttachMent(message[i]);
        }
    }

    /**
     * 【获得附件存放路径】
     */
    public String getAttachPath()
    {
        return this.saveAttachPath;
    }

    /**
     * 获得邮件正文内容
     */
    public String getBodyText()
    {
        return this.bodytext.toString();
    }

    /**
     * 获得发件人的地址和姓名
     */
    public String getFrom() throws Exception
    {
        InternetAddress address[] = (InternetAddress[]) this.mimeMessage.getFrom();
        String from = address[0].getAddress();
        if (from == null)
        {
            from = "";
        }
        String personal = address[0].getPersonal();
        if (personal == null)
        {
            personal = "";
        }
        String fromaddr = personal + "<" + from + ">";
        return fromaddr;
    }

    /**
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址
     */
    public String getMailAddress(String type) throws Exception
    {
        String mailaddr = "";
        String addtype = type.toUpperCase();
        InternetAddress[] address = null;
        if (addtype.equals("TO") || addtype.equals("CC") || addtype.equals("BCC"))
        {
            if (addtype.equals("TO"))
            {
                address = (InternetAddress[]) this.mimeMessage.getRecipients(Message.RecipientType.TO);
            }
            else
                if (addtype.equals("CC"))
                {
                    address = (InternetAddress[]) this.mimeMessage.getRecipients(Message.RecipientType.CC);
                }
                else
                {
                    address = (InternetAddress[]) this.mimeMessage.getRecipients(Message.RecipientType.BCC);
                }
            if (address != null)
            {
                for (InternetAddress addres : address)
                {
                    String email = addres.getAddress();
                    if (email == null)
                    {
                        email = "";
                    }
                    else
                    {
                        email = MimeUtility.decodeText(email);
                    }
                    String personal = addres.getPersonal();
                    if (personal == null)
                    {
                        personal = "";
                    }
                    else
                    {
                        personal = MimeUtility.decodeText(personal);
                    }
                    String compositeto = personal + "<" + email + ">";
                    mailaddr += "," + compositeto;
                }
                mailaddr = mailaddr.substring(1);
            }
        }
        else
        {
            throw new Exception("Error emailaddr type!");
        }
        return mailaddr;
    }

    /**
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析
     */
    public void getMailContent(Part part) throws Exception
    {
        String contenttype = part.getContentType();
        int nameindex = contenttype.indexOf("name");
        boolean conname = false;
        if (nameindex != -1)
        {
            conname = true;
        }
        System.out.println("CONTENTTYPE: " + contenttype);
        if (part.isMimeType("text/plain") && !conname)
        {
            this.bodytext.append((String) part.getContent());
        }
        else
            if (part.isMimeType("text/html") && !conname)
            {
                this.bodytext.append((String) part.getContent());
            }
            else
                if (part.isMimeType("multipart/*"))
                {
                    Multipart multipart = (Multipart) part.getContent();
                    int counts = multipart.getCount();
                    for (int i = 0; i < counts; i++)
                    {
                        this.getMailContent(multipart.getBodyPart(i));
                    }
                }
                else
                    if (part.isMimeType("message/rfc822"))
                    {
                        this.getMailContent((Part) part.getContent());
                    }
                    else
                    {
                    }
    }

    /**
     * 获得此邮件的Message-ID
     */
    public String getMessageId() throws MessagingException
    {
        return this.mimeMessage.getMessageID();
    }

    /**
     * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false"
     */
    public boolean getReplySign() throws MessagingException
    {
        boolean replysign = false;
        String needreply[] = this.mimeMessage.getHeader("Disposition-Notification-To");
        if (needreply != null)
        {
            replysign = true;
        }
        return replysign;
    }

    /**
     * 获得邮件发送日期
     */
    public String getSentDate() throws Exception
    {
        Date sentdate = this.mimeMessage.getSentDate();
        SimpleDateFormat format = new SimpleDateFormat(this.dateformat);
        return format.format(sentdate);
    }

    /**
     * 获得邮件主题
     */
    public String getSubject() throws MessagingException
    {
        String subject = "";
        try
        {
            subject = MimeUtility.decodeText(this.mimeMessage.getSubject());
            if (subject == null)
            {
                subject = "";
            }
        }
        catch (Exception exce)
        {
        }
        return subject;
    }

    /**
     * 判断此邮件是否包含附件
     */
    public boolean isContainAttach(Part part) throws Exception
    {
        boolean attachflag = false;
        part.getContentType();
        if (part.isMimeType("multipart/*"))
        {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++)
            {
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE))))
                {
                    attachflag = true;
                }
                else
                    if (mpart.isMimeType("multipart/*"))
                    {
                        attachflag = this.isContainAttach(mpart);
                    }
                    else
                    {
                        String contype = mpart.getContentType();
                        if (contype.toLowerCase().indexOf("application") != -1)
                        {
                            attachflag = true;
                        }
                        if (contype.toLowerCase().indexOf("name") != -1)
                        {
                            attachflag = true;
                        }
                    }
            }
        }
        else
            if (part.isMimeType("message/rfc822"))
            {
                attachflag = this.isContainAttach((Part) part.getContent());
            }
        return attachflag;
    }

    /**
     * 【判断此邮件是否已读，如果未读返回返回false,反之返回true】
     */
    public boolean isNew() throws MessagingException
    {
        boolean isnew = false;
        Flags flags = ((Message) this.mimeMessage).getFlags();
        Flags.Flag[] flag = flags.getSystemFlags();
        System.out.println("flags's length: " + flag.length);
        for (Flag element : flag)
        {
            if (element == Flags.Flag.SEEN)
            {
                isnew = true;
                System.out.println("seen Message.......");
                break;
            }
        }
        return isnew;
    }

    /**
     * 【保存附件】
     */
    public void saveAttachMent(Part part) throws Exception
    {
        String fileName = "";
        if (part.isMimeType("multipart/*"))
        {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++)
            {
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE))))
                {
                    fileName = mpart.getFileName();
                    if (fileName.toLowerCase().indexOf("gb2312") != -1)
                    {
                        fileName = MimeUtility.decodeText(fileName);
                    }
                    this.saveFile(fileName, mpart.getInputStream());
                }
                else
                    if (mpart.isMimeType("multipart/*"))
                    {
                        this.saveAttachMent(mpart);
                    }
                    else
                    {
                        fileName = mpart.getFileName();
                        if ((fileName != null) && (fileName.toLowerCase().indexOf("GB2312") != -1))
                        {
                            fileName = MimeUtility.decodeText(fileName);
                            this.saveFile(fileName, mpart.getInputStream());
                        }
                    }
            }
        }
        else
            if (part.isMimeType("message/rfc822"))
            {
                this.saveAttachMent((Part) part.getContent());
            }
    }

    /**
     * 【设置附件存放路径】
     */

    public void setAttachPath(String attachpath)
    {
        this.saveAttachPath = attachpath;
    }

    /**
     * 【设置日期显示格式】
     */
    public void setDateFormat(String format) throws Exception
    {
        this.dateformat = format;
    }

    public void setMimeMessage(MimeMessage mimeMessage)
    {
        this.mimeMessage = mimeMessage;
    }

    /**
     * 【真正的保存附件到指定目录里】
     */
    private void saveFile(String fileName, InputStream in) throws Exception
    {
        String osName = System.getProperty("os.name");
        String storedir = this.getAttachPath();
        String separator = "";
        if (osName == null)
        {
            osName = "";
        }
        if (osName.toLowerCase().indexOf("win") != -1)
        {
            separator = "\\";
            if (storedir == null || storedir.equals(""))
            {
                storedir = "c:\\tmp";
            }
        }
        else
        {
            separator = "/";
            storedir = "/tmp";
        }
        File storefile = new File(storedir + separator + fileName);
        System.out.println("storefile's path: " + storefile.toString());
        // for(int i=0;storefile.exists();i++){
        // storefile = new File(storedir+separator+fileName+i);
        // }
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try
        {
            bos = new BufferedOutputStream(new FileOutputStream(storefile));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1)
            {
                bos.write(c);
                bos.flush();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("文件保存失败!");
        }
        finally
        {
            bos.close();
            bis.close();
        }
    }
}
