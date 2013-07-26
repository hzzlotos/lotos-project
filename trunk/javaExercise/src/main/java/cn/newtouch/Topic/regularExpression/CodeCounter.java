package cn.newtouch.Topic.regularExpression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CodeCounter
{

    static long normalLines  = 0;

    static long commentLines = 0;

    static long whiteLines   = 0;

    public static void main(String[] args) throws Exception
    {
        File f = new File("./src/cn/newtouch/Topic/regularExpression");
        File[] codeFiles = f.listFiles();
        for (File child : codeFiles)
        {
            if (child.getName().matches(".*\\.java$"))
            {
                parse(child);
            }
        }

        System.out.println("normalLines:" + normalLines);
        System.out.println("commentLines:" + commentLines);
        System.out.println("whiteLines:" + whiteLines);

    }

    private static void parse(File f) throws Exception
    {
        BufferedReader br = null;
        boolean comment = false;
        br = new BufferedReader(new FileReader(f));
        String line = "";
        while ((line = br.readLine()) != null)
        {
            line = line.trim();
            if (line.matches("^[\\s&&[^\\n]]*$"))
            {
                whiteLines++;
            }
            else
                if (line.startsWith("/*") && !line.endsWith("*/"))
                {
                    commentLines++;
                    comment = true;
                }
                else
                    if (line.startsWith("/*") && line.endsWith("*/"))
                    {
                        commentLines++;
                    }
                    else
                        if (true == comment)
                        {
                            commentLines++;
                            if (line.endsWith("*/"))
                            {
                                comment = false;
                            }
                        }
                        else
                            if (line.startsWith("//"))
                            {
                                commentLines++;
                            }
                            else
                            {
                                normalLines++;
                            }
        }
        br.close();

    }

}
