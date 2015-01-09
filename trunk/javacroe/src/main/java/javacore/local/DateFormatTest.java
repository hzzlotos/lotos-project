package javacore.local;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest
{
    public static void main(String[] args)
    {
        Date now = new Date();
        DateFormat dft = DateFormat.getDateInstance(DateFormat.ERA_FIELD, Locale.CHINA);
        System.out.println("=======ERA_FIELD======" + dft.format(now));
        dft = DateFormat.getDateInstance(DateFormat.YEAR_FIELD, Locale.CHINA);
        System.out.println("=======YEAR_FIELD======" + dft.format(now));
        dft = DateFormat.getDateInstance(DateFormat.MONTH_FIELD, Locale.CHINA);
        System.out.println("=======MONTH_FIELD======" + dft.format(now));
        dft = DateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.CHINA);
        System.out.println("=======DATE_FIELD======" + dft.format(now));
        dft = DateFormat.getDateInstance(DateFormat.HOUR_OF_DAY1_FIELD, Locale.CHINA);
        System.out.println("=======HOUR_OF_DAY1_FIELD======" + dft.format(now));
    }
}