package com.hnmmli.other11.javacore.compilerapi;

import java.util.Map;

/**
 * A class loader that loads classes from a map whose keys are class names and whose values are byte
 * code arrays.
 * 
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public class MapClassLoader extends ClassLoader
{
    public MapClassLoader(Map<String, byte[]> classes)
    {
        this.classes = classes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        byte[] classBytes = this.classes.get(name);
        if (classBytes == null)
        {
            throw new ClassNotFoundException(name);
        }
        Class<?> cl = this.defineClass(name, classBytes, 0, classBytes.length);
        if (cl == null)
        {
            throw new ClassNotFoundException(name);
        }
        return cl;
    }

    private Map<String, byte[]> classes;
}