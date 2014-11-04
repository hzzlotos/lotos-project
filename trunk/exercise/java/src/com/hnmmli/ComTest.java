package com.hnmmli;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ComTest
{
    public static void main(String args[])
    {
        try
        {
            //在jdk目录下的jre/lib包中添加jdk/lib/tools.jar
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            
            int results = compiler.run(null, null, null, "-d", "G:\\eclipse\\workspace\\exercise\\java\\target\\" , "-sourcepath", 
                    "G:\\eclipse\\workspace\\exercise\\java\\src\\", "G:\\eclipse\\workspace\\exercise\\java\\src\\com\\hnmmli\\Test.java");
    
            System.out.println((results == 0) ? "success" : "error");
    
            // 在程序中运行test    
            Runtime run = Runtime.getRuntime();
            //必须在同一级classpath下才可以
            Process p = run.exec("java com.hnmmli.Test");
    
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
    
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
    
            String s;
    
            while ((s = br.readLine()) != null)
            {
                System.out.println("1:"+s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}