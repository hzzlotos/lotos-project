package com.hnmmli.logger;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * 自定义日志文件处理器---日期及文件大小存储，并自动清除过期日志文件
 */
public class LogFileStreamHandler extends StreamHandler
{
    /**
     * 抄自FileHandler的实现，用于跟踪写入文件的字节数 这样以便提高效率
     */
    private class MeteredStream extends OutputStream
    {

        private OutputStream out;

        // 记录当前写入字节数
        private int          written;

        MeteredStream(OutputStream out, int written)
        {
            this.out = out;
            this.written = written;
        }

        @Override
        public void close() throws IOException
        {
            this.out.close();
        }

        @Override
        public void flush() throws IOException
        {
            this.out.flush();
        }

        @Override
        public void write(byte buff[]) throws IOException
        {
            this.out.write(buff);
            this.written += buff.length;
        }

        @Override
        public void write(byte buff[], int off, int len) throws IOException
        {
            this.out.write(buff, off, len);
            this.written += len;
        }

        @Override
        public void write(int b) throws IOException
        {
            this.out.write(b);
            this.written++;
        }
    }

    private class LogFile extends File
    {
        private static final long serialVersionUID = 952141123094287978L;

        private Date              date;

        private String            dateString;

        private int               sid;

        SimpleDateFormat          sdf              = new SimpleDateFormat("yyyy-MM-dd");

        public LogFile(String pathname)
        {
            super(pathname);
            try
            {
                int dot = pathname.lastIndexOf('.');
                int split = pathname.lastIndexOf(LogFileStreamHandler.this.splitDateIndexChar);
                int underline = pathname.lastIndexOf('_');
                this.dateString = pathname.substring(underline + 1, split);
                String numStr = pathname.substring(split + 1, dot);
                this.date = this.sdf.parse(this.dateString);
                this.sid = Integer.valueOf(numStr);
            }
            catch (Exception e)
            {
                System.err.println("log对应文件夹中包含了不符合XLLOG格式的文件!!");
                e.printStackTrace();
            }

        }

        @Override
        public int compareTo(File another)
        {
            LogFile ano = (LogFile) another;
            int dateComResult = this.date.compareTo(ano.getDate());
            if (dateComResult == 0)
            {
                return this.sid - ano.getSid();
            }
            return dateComResult;
        }

        public Date getDate()
        {
            return this.date;
        }

        public String getDateString()
        {
            return this.dateString;
        }

        public int getSid()
        {
            return this.sid;
        }

        public void setDate(Date date)
        {
            this.date = date;
        }

        public void setDateString(String dateString)
        {
            this.dateString = dateString;
        }

        public void setSid(int sid)
        {
            this.sid = sid;
        }
    }

    private static final String           undifine           = "xlcallcenter";

    // 是否将日志写入已存在的日志文件中
    private boolean                       append;

    // 保存几天之内的日志文件
    // 时间间隔小于等于0时表明不删除历史记录
    private int                           dateinterval       = 5;

    // 保存存在的日志文件
    private Map<String, TreeSet<LogFile>> files;

    // 每个日志希望写入的最大字节数，如果日志达到最大字节数则当天日期的一个新的编号的日志文件将被创建，最新的日志记录在最大编号的文件中
    // 文件大小为小于等于0时表明不限制日志文件大小
    private int                           limit              = 1048576 * 5;

    // 输出流
    private MeteredStream                 msOut;

    // 文件路径， 可以是个目录或希望的日志名称，如果是个目录则日志为"callcenter_zd"
    // 指定日志名称时不需要包括日期，程序会自动生成日志文件的生成日期及相应的编号
    private String                        pattern            = "./log/xunleidemo";

    private char                          splitDateIndexChar = '#';

    public LogFileStreamHandler() throws Exception
    {
        this.configure();
        this.openWriteFiles();
    }

    /**
     * 初始化自定义文件流处理器
     * 
     * @param fileUrl
     *            文件路径， 可以是个目录或希望的日志名称，如果是个目录则日志为"callcenter_zd"
     *            指定日志名称时不需要包括日期，程序会自动生成日志文件的生成日期及相应的编号
     * @param limit
     *            每个日志希望写入的最大字节数，如果日志达到最大字节数则当天日期的一个新的编
     *            号的日志文件将被创建，最新的日志记录在最大编号的文件中
     * @param dateinterval
     *            保存几天之内的日志文件
     * @param append
     *            是否将日志写入已存在的日志文件中
     * @throws java.lang.Exception
     */
    public LogFileStreamHandler(String fileUrl, int limit, int dateinterval, boolean append) throws Exception
    {
        super();
        this.pattern = fileUrl;
        this.limit = limit;
        this.dateinterval = dateinterval;
        this.append = append;
        this.openWriteFiles();
    }

    public static void main(String[] args)
    {
        Logger fileLogger = Logger.getLogger(LogFileStreamHandler.class.getName());
        fileLogger.setLevel(Level.INFO);
        Handler[] hs = fileLogger.getHandlers();
        for (Handler h : hs)
        {
            h.close();
            fileLogger.removeHandler(h);
        }
        try
        {
            // 文件 日志文件名为mylog 日志最大写入为4000个字节 保存5天内的日志文件
            // 如果文件没有达到规定大小则将日志文件添加到已有文件
            LogFileStreamHandler fh = new LogFileStreamHandler("g:/logs/test", 200, 10, false);
            fh.setLevel(Level.OFF);
            fh.setEncoding("UTF-8");
            fh.setFormatter(new LogFormatter());
            fileLogger.setUseParentHandlers(false);
            fileLogger.addHandler(fh);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        for (int i = 0; i < 30; i++)
        {
            fileLogger.log(Level.INFO, "我被记录了吗?");
        }
    }

    /**
     * 发布日志信息
     */
    @Override
    public synchronized void publish(LogRecord record)
    {
        super.publish(record);
        super.flush();
        if (this.getLevel().equals(Level.OFF))
        {
            return;
        }
        if (this.limit > 0 && this.msOut.written >= this.limit)
        {
            this.openLastFile(false);
        }
    }

    /**
     * 检查当前日志时间,删除过期日志
     */
    // private void deleteExpiredLog() {
    //
    // try {
    // // 今天作为基准
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // String today = sdf.format(new Date().getTime());
    // // 删除过期日志
    // for (String keyDate : files.keySet()) {
    // if ((sdf.parse(today).getTime() - sdf.parse(keyDate).getTime())
    // / (86400 * 1000) > dateinterval) {
    // TreeSet<LogFile> traceDateFiles = files.get(keyDate);
    // for (File deletingFile : traceDateFiles) {
    // // if(deletingFile.exists()) {
    // deletingFile.delete();
    // // }
    // }
    // files.remove(today);
    // }
    // }
    // } catch (Exception ex) {
    // Logger.getLogger(LogFileStreamHandler.class.getName()).log(
    // Level.SEVERE, null, ex);
    // }
    // }

    // Private method to configure a FileHandler from LogManager
    // properties and/or default values as specified in the class
    // javadoc.
    private void configure()
    {
        LogManager manager = LogManager.getLogManager();
        String cname = this.getClass().getName();

        // 获得pattern
        this.pattern = manager.getProperty(cname + ".pattern");
        if (this.pattern == null)
        {
            this.pattern = "./log/xunleidemo";
        }

        // 获得limit
        String limitVal = manager.getProperty(cname + ".limit");
        if (limitVal == null)
        {
            this.limit = 1048576 * 5;
        }
        else
        {
            try
            {
                this.limit = Integer.parseInt(limitVal.trim());
                // if (limit < 0) {
                // limit = 1048576 * 5;
                // }
            }
            catch (Exception ex)
            {
                this.limit = 1048576 * 5;
            }
        }

        // 获得formatter
        String formatVal = manager.getProperty(cname + ".formatter");
        if (formatVal == null)
        {
            this.setFormatter(new LogFormatter());
        }
        else
        {
            try
            {
                Class clz = ClassLoader.getSystemClassLoader().loadClass(formatVal);
                this.setFormatter((Formatter) clz.newInstance());
            }
            catch (Exception ex)
            {
                // We got one of a variety of exceptions in creating the
                // class or creating an instance.
                // Drop through.
            }
        }

        // 获得append
        String appendVal = manager.getProperty(cname + ".append");
        if (appendVal == null)
        {
            this.append = false;
        }
        else
        {
            if (appendVal.equalsIgnoreCase("true") || appendVal.equals("1"))
            {
                this.append = true;
            }
            else
                if (appendVal.equalsIgnoreCase("false") || appendVal.equals("0"))
                {
                    this.append = false;
                }
        }

        // 获得level
        String levelVal = manager.getProperty(cname + ".level");
        if (levelVal == null)
        {
            this.setLevel(Level.ALL);
        }
        else
        {
            try
            {
                this.setLevel(Level.parse(levelVal.trim()));
            }
            catch (Exception ex)
            {
                this.setLevel(Level.ALL);
            }
        }

        // 获得dateinterval
        String dateintervalVal = manager.getProperty(cname + ".dateinterval");
        if (dateintervalVal == null)
        {
            this.dateinterval = 5;
        }
        else
        {
            try
            {
                this.dateinterval = Integer.parseInt(dateintervalVal.trim());
                if (this.dateinterval <= 0)
                {
                    this.dateinterval = 5;
                }
            }
            catch (Exception ex)
            {
                this.dateinterval = 5;
            }
        }

        // 获得filter
        String filterVal = manager.getProperty(cname + ".filter");
        if (filterVal == null)
        {
            this.setFilter(null);
        }
        else
        {
            try
            {
                Class clz = ClassLoader.getSystemClassLoader().loadClass(filterVal);
                this.setFilter((Filter) clz.newInstance());
            }
            catch (Exception ex)
            {
                // We got one of a variety of exceptions in creating the
                // class or creating an instance.
                // Drop through.
            }
        }

        // 获得encoding
        String encodingVal = manager.getProperty(cname + ".encoding");
        if (encodingVal == null)
        {
            try
            {
                this.setEncoding(null);
            }
            catch (Exception ex2)
            {
                // doing a setEncoding with null should always work.
                // assert false;
            }
        }
        else
        {
            try
            {
                this.setEncoding(encodingVal);
            }
            catch (Exception ex)
            {
                try
                {
                    this.setEncoding(null);
                }
                catch (Exception ex2)
                {
                    // doing a setEncoding with null should always work.
                    // assert false;
                }
            }
        }
    }

    /**
     * 根据logIndex要建立File
     * 
     * @param logIndex
     *            包含今天日期及编号,如2008-09-11#1
     * @return File
     */
    private LogFile getNewFile(String logIndex)
    {
        File file = new File(this.pattern);
        LogFile wantWriteFile = null;
        StringBuilder filePath = new StringBuilder(this.pattern);
        if (file.isDirectory())
        {
            filePath.append(File.separator);
            filePath.append(undifine);

        }
        filePath.append('_');
        filePath.append(logIndex);
        filePath.append(".log");
        wantWriteFile = new LogFile(filePath.toString());
        return wantWriteFile;
    }

    /**
     * 读取已经记录的日志的时间信息
     */
    private Map<String, TreeSet<LogFile>> getRecodedLog()
    {
        Map<String, TreeSet<LogFile>> filesMap = new HashMap<String, TreeSet<LogFile>>();
        try
        {
            // 建立相关目录
            File file = new File(this.pattern);
            File fileDir = null;
            if (this.pattern.endsWith("/") || this.pattern.endsWith("\\"))
            {
                // 是个目录
                fileDir = file;
                if (!file.exists())
                {
                    file.mkdirs();
                }
            }
            else
            {
                // 带了前缀
                File parentFile = new File(file.getParent());
                fileDir = parentFile;
                // 父目录不存在则新建目录
                if (!parentFile.exists())
                {
                    parentFile.mkdirs();
                }
            }

            // 加入到filesMap中
            for (File contentFile : fileDir.listFiles())
            {
                if (contentFile.isFile())
                {
                    LogFile newLogFile = new LogFile(contentFile.getAbsolutePath());
                    TreeSet<LogFile> fileListToDate = filesMap.get(newLogFile.getDateString());
                    if (fileListToDate == null)
                    {
                        fileListToDate = new TreeSet<LogFile>();
                    }
                    fileListToDate.add(newLogFile);
                    filesMap.put(newLogFile.getDateString(), fileListToDate);
                }
            }

            this.files = filesMap;
            return filesMap;
        }
        catch (Exception ex)
        {
            Logger.getLogger(LogFileStreamHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 打开需要写入的文件
     * 
     * @param file
     *            需要打开的文件
     * @param append
     *            是否将内容添加到文件末尾
     */
    private void openFile(File file, boolean append) throws Exception
    {
        int len = 0;
        if (append)
        {
            len = (int) file.length();
        }
        FileOutputStream fout = new FileOutputStream(file.toString(), append);
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        this.msOut = new MeteredStream(bout, len);
        this.setOutputStream(this.msOut);
    }

    /**
     * 将离现在最近的文件作为写入文件的文件 例如 xunleidemo_2008-02-19#30.log
     * xunleidemo表示自定义的日志文件名，2008-02-19表示日志文件的生成日期，30 表示此日期的第30个日志文件
     */
    private void openLastFile(boolean append)
    {
        try
        {
            super.close();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date().getTime());

            // 如果没有包含当天的日期，则添加当天日期的日志文件
            boolean isFirstLogToday = false;
            if (!this.files.containsKey(today))
            {
                String logIndex = today + this.splitDateIndexChar + 1;
                TreeSet<LogFile> todayFiles = new TreeSet<LogFile>();
                todayFiles.add(this.getNewFile(logIndex));
                this.files.put(today, todayFiles);
                isFirstLogToday = true;
            }

            // 获得今天最大的日志文件编号
            LogFile todayLastFile = this.files.get(today).last();
            int maxLogCount = todayLastFile.getSid();
            String logIndex = today + this.splitDateIndexChar
                    + (maxLogCount + (isFirstLogToday ? 0 : (append ? 0 : 1)));
            LogFile wantWriteFile = this.getNewFile(logIndex);
            this.files.get(today).add(wantWriteFile);
            this.openFile(wantWriteFile, append);
        }
        catch (Exception ex)
        {
            Logger.getLogger(LogFileStreamHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 获得将要写入的文件
     */
    private synchronized void openWriteFiles() throws Exception
    {
        if (!this.getLevel().equals(Level.OFF))
        {
            this.getRecodedLog();
            // deleteExpiredLog();
            this.openLastFile(this.append);
        }
    }
}
