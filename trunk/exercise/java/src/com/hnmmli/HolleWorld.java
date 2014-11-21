package com.hnmmli;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

//在src目录下执行 javac -encoding UTF-8 -d G:\eclipse\workspace\exercise\java\target com\hnmmli\HolleWorld.java
//在target目录下java javacore.HolleWorld
public class HolleWorld
{
    public static void main(String[] args)
    {
        System.out.println("HolleWorld!");
        try
        {
            // 这里只需指向跟目录即可
            File file = new File("G:\\eclipse\\workspace\\exercise\\java\\target\\");
            URL[] urls = { file.toURI().toURL() };
            ClassLoader classLoader = new URLClassLoader(urls);
            Thread.currentThread().setContextClassLoader(classLoader);
            // 这里的域名带路径
            Class<?> clazz = classLoader.loadClass("cn.newtouch.TheTest");
            Method taskMethod = clazz.getMethod("getStr");
            String result = String.valueOf(taskMethod.invoke(clazz.newInstance()));
            System.out.println(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}