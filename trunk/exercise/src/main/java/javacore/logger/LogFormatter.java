package javacore.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter
{
    private static String        lineSeparator = System.getProperty("line.separator");

    static long                  startTime     = System.currentTimeMillis();

    private static DecimalFormat threeDigFmt   = new DecimalFormat("000");

    private static DecimalFormat twoDigFmt     = new DecimalFormat("00");

    // private final static String format = "{0,date} {0,time}";
    // private MessageFormat formatter;
    // Date dat = new Date();
    // private Object args[] = new Object[1];
    @Override
    public synchronized String format(LogRecord record)
    {
        StringBuilder sb = new StringBuilder();
        // dat.setTime(record.getMillis());
        // args[0] = dat;
        // StringBuffer text = new StringBuffer();
        // if (formatter == null) {
        // formatter = new MessageFormat(format);
        // }
        // formatter.format(args, text, null);
        // sb.append(text);
        // current time
        // Calendar cal = Calendar.getInstance();
        // int millis = cal.get(Calendar.MILLISECOND);
        // sb.append('.').append(threeDigFmt.format(millis)).append(' ');

        // current time
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        int millis = cal.get(Calendar.MILLISECOND);
        sb.append(twoDigFmt.format(hour)).append(':');
        sb.append(twoDigFmt.format(minutes)).append(':');
        sb.append(twoDigFmt.format(seconds)).append('.');
        sb.append(threeDigFmt.format(millis)).append(' ');

        // log level
        sb.append(record.getLevel().getLocalizedName());
        sb.append(": ");

        // caller method
        int lineNumber = this.inferCaller(record);
        String loggerName = record.getLoggerName();

        if (loggerName == null)
        {
            loggerName = record.getSourceClassName();
        }

        if (loggerName.startsWith("com.xunlei.callcenter."))
        {
            sb.append(loggerName.substring("com.xunlei.callcenter.".length()));
        }
        else
        {
            sb.append(record.getLoggerName());
        }

        if (record.getSourceMethodName() != null)
        {
            sb.append('.');
            sb.append(record.getSourceMethodName());

            // include the line number if we have it.
            if (lineNumber != -1)
            {
                sb.append("().").append(Integer.toString(lineNumber));
            }
            else
            {
                sb.append("()");
            }
        }
        sb.append(' ');
        sb.append(record.getMessage());
        sb.append(lineSeparator);
        if (record.getThrown() != null)
        {
            try
            {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                record.getThrown().printStackTrace(pw);
                pw.close();
                sb.append(sw.toString());
            }
            catch (Exception ex)
            {
            }
        }
        return sb.toString();
    }

    private int inferCaller(LogRecord record)
    {
        // Get the stack trace.
        StackTraceElement stack[] = (new Throwable()).getStackTrace();

        // the line number that the caller made the call from
        int lineNumber = -1;

        // First, search back to a method in the XLCallCenter Logger class.
        int ix = 0;
        while (ix < stack.length)
        {
            StackTraceElement frame = stack[ix];
            String cname = frame.getClassName();
            if (cname.equals("com.xunlei.demo.util.Logger"))
            {
                break;
            }
            ix++;
        }
        // Now search for the first frame before the XLCallCenter Logger class.
        while (ix < stack.length)
        {
            StackTraceElement frame = stack[ix];
            lineNumber = stack[ix].getLineNumber();
            String cname = frame.getClassName();
            if (!cname.equals("com.xunlei.demo.util.Logger"))
            {
                // We've found the relevant frame.
                record.setSourceClassName(cname);
                record.setSourceMethodName(frame.getMethodName());
                break;
            }
            ix++;
        }

        return lineNumber;
    }
}
