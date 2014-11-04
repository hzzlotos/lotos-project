package com.hnmmli.other11.javacore.compilerapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * A Java class that holds the bytecodes in a byte array.
 * 
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public class ByteArrayJavaClass extends SimpleJavaFileObject
{
    /**
     * Constructs a new ByteArrayJavaClass
     * 
     * @param name the name of the class file represented by this file object
     */
    public ByteArrayJavaClass(String name)
    {
        super(URI.create("bytes:///" + name), Kind.CLASS);
        this.stream = new ByteArrayOutputStream();
    }

    @Override
    public OutputStream openOutputStream() throws IOException
    {
        return this.stream;
    }

    public byte[] getBytes()
    {
        return this.stream.toByteArray();
    }

    private ByteArrayOutputStream stream;
}
