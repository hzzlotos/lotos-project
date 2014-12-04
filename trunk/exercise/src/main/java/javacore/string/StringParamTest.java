package javacore.string;
//String作为参数时非引用而是值copy
public class StringParamTest
{
    String str  = new String("111");

    String str2 = new String("222");

    char[] ch   = { 'a', 'b' };

    public static void main(String[] args)
    {
        StringParamTest st = new StringParamTest();
        System.out.println(st.str.hashCode());
        System.out.println("======================");
        st.change(st.str, st.str2, st.ch);

        System.out.print(st.str + "---" + st.str2 + "---");
        System.out.println(st.ch);
    }

    public void change(String str, String str2, char[] ch)
    {
        System.out.println(str.hashCode());
        str = "aaa";
        System.out.println(str);
        System.out.println(str.hashCode());
        str2 += "aaa";
        ch[0] = '1';
    }
}