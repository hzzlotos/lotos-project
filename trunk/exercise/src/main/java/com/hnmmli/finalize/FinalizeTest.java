package com.hnmmli.finalize;

public class FinalizeTest
{

    public static void main(String[] args)
    {
        System.out.println("111111111111");
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
    }
}
