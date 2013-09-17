package cn.newtouch.base.frequentlyUsedClasses;

public class TestString
{
    public static void main(String[] args)
    {

        String s = "AaaaABBBBcc&^%adfsfdCCOOkk99876 _haHA";
        int lCount = 0, uCount = 0, oCount = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') // 因为字符比较的是asc码的值
            {
                lCount++;
            }
            else
                if (c >= 'A' && c <= 'Z')
                {
                    uCount++;
                }
                else
                {
                    oCount++;
                }
        }

        // for (int i = 0; i < s.length(); i++)
        // {
        // char c = s.charAt(i);
        // if (Character.isLowerCase(c))
        // {
        // lCount++;
        // }
        // else
        // if (Character.isUpperCase(c))
        // {
        // uCount++;
        // }
        // else
        // {
        // oCount++;
        // }
        // }

        System.out.println(lCount + " " + uCount + " " + oCount);

        String s1 = "sunjavahpjavaokjavajjavahahajavajavagoodjava";

        String sToFind = "java";
        int count = 0;
        int index = -1;

        while ((index = s1.indexOf(sToFind)) != -1)
        {
            s1 = s1.substring(index + sToFind.length());
            count++;
        }

        System.out.println(count);

    }
}