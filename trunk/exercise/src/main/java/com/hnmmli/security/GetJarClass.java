package com.hnmmli.security;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

//holle.jar为同一级别的项目holle
public final class GetJarClass
{
    public static void main(String[] args)
    {
        try
        {
            URL[] urls = { new File("F:\\holle.jar").toURI().toURL() };
            URLClassLoader classLoader = new URLClassLoader(urls);
            Thread.currentThread().setContextClassLoader(classLoader);
            Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass("cn.newtouch.Holle");
            Method taskMethod = clazz.getMethod("say", String.class);
            String result = String.valueOf(taskMethod.invoke(clazz.newInstance(), "123"));
            System.out.println(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}