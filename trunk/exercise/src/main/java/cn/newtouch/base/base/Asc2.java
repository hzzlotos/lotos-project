package cn.newtouch.base.base;

public class Asc2
{
    public static void main(String[] args)
    {
        // 把ASC码放到数组中，char[] ascArray;
        // String str=new String(ascArray);
        // 这样就把ASC码转化为字符串了。

        // 比如要把字符串转化为ASCII码数组：
        String str = "三";
        byte[] byteArray = str.getBytes();
        // byteArray数组里就存储的是ASCII码。
        for (byte byte1 : byteArray)
        {
            System.out.println(byte1);
        }
        str = new String(byteArray);
        System.out.println("==========" + str);
    }
}