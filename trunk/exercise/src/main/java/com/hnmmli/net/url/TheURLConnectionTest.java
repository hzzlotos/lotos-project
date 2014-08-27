package com.hnmmli.net.url;

import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import sun.misc.BASE64Encoder;

public class TheURLConnectionTest
{
    public static void main(String[] args)
    {
        try
        {
            link4javacore();
            // post();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void post() throws Exception
    {
        URL url = new URL("http://192.168.100.114:8080/g2web/user/login");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print("userName");
        out.print("=");
        out.print(URLEncoder.encode("hiaas_admin", "UTF-8"));
        out.print("&");
        out.print("loginPassword");
        out.print("=");
        out.print(URLEncoder.encode("111111", "UTF-8"));
        out.close();

        Scanner in = new Scanner(connection.getInputStream());
        while (in.hasNextLine())
        {
            System.out.println(in.nextLine());
        }
        in.close();
    }

    private static void link4javacore() throws Exception
    {
        URL url = new URL("http://192.168.100.114:8080/g2web/");
        URLConnection urlconnection = url.openConnection();
        String input = "username" + ":" + "password";
        String encode = new BASE64Encoder().encode(input.getBytes());
        // String key = urlconnection.getHeaderFieldKey(n);
        // String value = urlconnection.getHeaderField(n);
        urlconnection.addRequestProperty("Authorization", "Basic " + encode);
        urlconnection.connect();
        Map<String, List<String>> fields = urlconnection.getHeaderFields();
        for (String temp : fields.keySet())
        {
            System.out.println("******************************name===" + temp);
            System.out.println("===============================");
            List<String> strs = fields.get(temp);
            for (String str : strs)
            {
                System.out.println(str);
            }
            System.out.println("-------------------------------");
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Scanner in = new Scanner(urlconnection.getInputStream());
        while (in.hasNextLine())
        {
            System.out.println(in.nextLine());
        }
        in.close();
    }
}