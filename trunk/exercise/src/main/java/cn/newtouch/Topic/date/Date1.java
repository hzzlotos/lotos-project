package cn.newtouch.Topic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Date1
{

    public static void main(String[] args)
    {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 100);

        Date datee = calendar.getTime();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(datee));

        double bb = 123.12;

        int aa = 757;

        int cc = (int) bb;

        System.out.println(cc);

        String ss = String.valueOf(aa);

        float ff = Float.valueOf(ss);

        System.out.println(ff);

        float fff = (float) bb;

        System.out.println(fff);

        float ffas = 1321.58f;

        System.out.println(ffas);

        System.out.println("=======================");

        Date dd = new Date();
        System.out.println(dd);

        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("//////////////////////////");

        String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .format(new Date());

        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            Date dd2 = sdf.parse(date);

            System.out.println(dd2);

        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("=======================");

        Map<String, String> map = new HashMap<String, String>();

        map.put("123", "abc");

        map.put("345", "cde");

        map.put("567", "efg");

        Set<Map.Entry<String, String>> set = map.entrySet();

        for (Map.Entry<String, String> aaa : set)
        {

            System.out.println("Key is " + aaa.getKey() + ", Value is "
                    + aaa.getValue() + ".");
        }
    }
}