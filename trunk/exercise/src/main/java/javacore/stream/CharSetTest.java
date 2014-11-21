package javacore.stream;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharSetTest
{
    public static void main(String[] args)
    {
        Charset cset = Charset.forName("UTF-8");
        String str1 = "你好! 我是lotos！";
        System.out.println("str1================" + str1);
        System.out.println(str1.length());
        ByteBuffer buffer = cset.encode(str1);
        int index = buffer.limit();
        byte[] bytes = buffer.array();

        String str3 = bytes.toString();
        System.out.println("str3================" + str3);

        ByteBuffer buffer2 = ByteBuffer.wrap(bytes, 0, index);
        CharBuffer cbuf = cset.decode(buffer2);
        String str2 = cbuf.toString();
        System.out.println("str2================" + str2);
        System.out.println(str2.length());
        System.out.println(str2.equals(str1));

        CharBuffer cbuf2 = cset.decode(buffer);
        String str4 = cbuf2.toString();
        System.out.println("str4================" + str4);
        System.out.println(str4.equals(str1));
    }
}
