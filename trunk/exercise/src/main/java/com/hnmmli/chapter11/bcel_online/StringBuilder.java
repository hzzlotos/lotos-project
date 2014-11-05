package com.hnmmli.chapter11.bcel_online;

public class StringBuilder
{
    private String buildString(int length)
    {
        String result = "";
        for (int i = 0; i < length; i++)
        {
            result += (char) (i % 26 + 'a');
        }
        return result;
    }

    public static void main(String[] argv)
    {
        StringBuilder inst = new StringBuilder();
        for (String element : argv)
        {
            String result = inst.buildString(Integer.parseInt(element));
            System.out.println("Constructed string of length " + result.length());
        }
    }
}