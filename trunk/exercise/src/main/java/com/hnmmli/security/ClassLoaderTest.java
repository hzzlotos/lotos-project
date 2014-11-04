package com.hnmmli.security;

import java.net.URL;

public class ClassLoaderTest
{
    public static void main(String[] args)
    {
        systemJarTest();
        System.out.println("========================");
        testClassLoader();
    }

    private static void systemJarTest()
    {
        // 打印系统jar的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls)
        {
            System.out.println(url.toExternalForm());
        }
    }

    private static void testClassLoader()
    {
        System.out.println("user.home-----------" + System.getProperty("user.home"));
        System.out.println("java.home-----------" + System.getProperty("java.home"));
        System.out.println("java.ext.dirs-----------" + System.getProperty("java.ext.dirs"));
        System.out.println("Thread.getContextClassLoader()=====" + Thread.currentThread().getContextClassLoader());
        System.out.println("当前class.getClassLoader()=========" + ClassLoaderTest.class.getClassLoader());
        System.out.println("当前应用系统AppClassLoader==========" + ClassLoader.getSystemClassLoader());
        System.out.println("当前ext系统ExtClassLoader==========" + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("当前系统系统SysClassLoader=========="
                + ClassLoader.getSystemClassLoader().getParent().getParent());
        TestSysClassLoader tscl = new TestSysClassLoader();
        tscl.getSysClassLoader();
        /*
         * Thread.currentThread().getContextClassLoader()
         * ClassLoaderTest.class.getClassLoader()-->该应用下启动main下所有class得到的getClassLoader都是当前的应用AppClassLoader
         * ClassLoader.getSystemClassLoader()
         * 三者是一致的
         */
    }
}