package com.hnmmli.chapter11.bcel_online;

public class StringBuilderTarget
{
    private String buildString(int length)
    {
        System.out.println("start start start");
        long starttime = System.currentTimeMillis();

        String result = "";
        for (int i = 0; i < length; i++)
        {
            result += (char) (i % 26 + 'a');
        }
        System.out.println(result);

        System.out.println("Call to buildString$impl took " + (System.currentTimeMillis() - starttime) + " ms.");
        System.out.println("end end end end");

        return result;
    }

    public static void main(String[] argv)
    {
        String[] argv1 = { "10", "15" };
        argv = argv1;
        StringBuilderTarget inst = new StringBuilderTarget();
        for (String element : argv)
        {
            String result = inst.buildString(Integer.parseInt(element));
            System.out.println("Constructed string of length " + result.length());
        }
    }
}
