package cn.newtouch.base.frequentlyUsedClasses;

import java.io.File;

public class FileList
{
    public static void main(String[] args)
    {
        File f = new File("d:/A");
        System.out.println(f.getName());
        tree(f, 1);
    }

    private static void tree(File f, int level)
    {

        String preStr = "";
        for (int i = 0; i < level; i++)
        {
            preStr += "    ";
        }

        File[] childs = f.listFiles();
        for (File child : childs)
        {
            System.out.println(preStr + child.getName());
            if (child.isDirectory())
            {
                tree(child, level + 1);
            }
        }
    }

}