package com.hnmmli.javanative;

public class HelloNative
{
    public static native void greeting();

    public static void main(String[] args)
    {
        HelloNative.greeting();
    }
}