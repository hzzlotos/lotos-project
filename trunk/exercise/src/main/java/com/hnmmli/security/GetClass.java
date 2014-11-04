package com.hnmmli.security;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class GetClass
{
    public static void main(String[] args)
    {
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