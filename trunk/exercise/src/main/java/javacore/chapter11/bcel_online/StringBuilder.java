package javacore.chapter11.bcel_online;

public class StringBuilder
{
    private String buildString(int length)
    {
        String result = "";
        for (int i = 0; i < length; i++)
        {
            result += (char) (i % 26 + 'a');
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv)
    {
        String[] argv1 = { "10", "15" };
        argv = argv1;
        StringBuilder inst = new StringBuilder();
        for (String element : argv)
        {
            String result = inst.buildString(Integer.parseInt(element));
            System.out.println("Constructed string of length " + result.length());
        }
    }
}
