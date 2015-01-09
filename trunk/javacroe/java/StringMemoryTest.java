import java.util.ArrayList;
import java.util.List;

public class StringMemoryTest
{
    // 该测试可以在eclipse的window->preferences->java->Installed JREs->默认jre->edit->Default VM arguments下填入如下设置
    // -Xms2m -Xmx8m -XX:MaxNewSize=4m -XX:MaxPermSize=4m
    public static void main(String[] args)
    {
        String str = "abc";
        char[] array = { 'a', 'b', 'c' };
        String str2 = new String(array);
        str2 = str2.intern();
        // 这个比较用来说明在使用intern处理后str2也指向了常量池中的"abc"
        System.out.println(str == str2);
        List<String> list = new ArrayList<String>();// 动态分配list大小 使用数组堆内存直接爆表
        for (int i = 0; i < 10000000; i++)
        {
            String temp = String.valueOf(i);// java.lang.OutOfMemoryError: Java heap space //堆内存爆表
            // String temp = String.valueOf(i).intern();// java.lang.OutOfMemoryError: PermGen space //永久保存区爆表
            list.add(temp);
        }
    }
}