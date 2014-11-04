package com.hnmmli.security;

public class TestSysClassLoader extends ClassLoader
{
    public void getSysClassLoader()
    {
        System.out.println("this getSystemClassLoader============" + ClassLoader.getSystemClassLoader());
        System.out.println("this getClassLoader============" + TestSysClassLoader.class.getClassLoader());
    }

    public TestSysClassLoader()
    {
        super(ClassLoader.getSystemClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        // 默认的实现,需开发者重新实现
        throw new ClassNotFoundException(name);
    }
}