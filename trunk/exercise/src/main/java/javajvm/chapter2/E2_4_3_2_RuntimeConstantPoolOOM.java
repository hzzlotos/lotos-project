package javajvm.chapter2;

public class E2_4_3_2_RuntimeConstantPoolOOM
{
    public static void main(String[] args)
    {
        String str1 = new String("中国") + "钓鱼岛";
        System.out.println(str1.intern() == str1);

        String str2 = new String("ja") + "va";
        System.out.println(str2.intern() == str2);
    }
}
