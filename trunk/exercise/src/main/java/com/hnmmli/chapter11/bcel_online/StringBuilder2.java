package com.hnmmli.chapter11.bcel_online;

public class StringBuilder2
{
    private String buildString$impl(int length)
    {
        String result = "";
        for (int i = 0; i < length; i++)
        {
            result += (char) (i % 26 + 'a');
        }
        return result;
    }

    private String buildString(int length)
    {
        long start = System.currentTimeMillis();
        String result = this.buildString$impl(length);
        System.out.println("Call to buildString$impl took " + (System.currentTimeMillis() - start) + " ms.");
        return result;
    }

    public static void main(String[] argv)
    {
        StringBuilder2 inst = new StringBuilder2();
        for (String element : argv)
        {
            String result = inst.buildString(Integer.parseInt(element));
            System.out.println("Constructed string of length " + result.length());
        }
    }
}