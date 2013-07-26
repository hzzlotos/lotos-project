package cn.newtouch.base.file.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyStream
{

    private String str = null;

    public void input() throws IOException
    {

        FileReader f = new FileReader("d:\\mycourse_manage_schedule.htm");
        BufferedReader br = new BufferedReader(f);

        // =======================
        // FileInputStream fis = new FileInputStream(new File(
        // "d:\\mycourse_manage_schedule.htm"));
        //
        // InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        // System.out.println("getEncoding==============" + isr.getEncoding());

        while ((str = br.readLine()) != null)
        {
            System.out.println(str);
        }

        br.close();
        f.close();
        // isr.close();
        // fis.close();
    }

    public void output() throws IOException
    {

        FileWriter f = new FileWriter("d:\\aaa.html");

        // FileOutputStream fos = new FileOutputStream(f);

        // OutputStreamWriter osw = new OutputStreamWriter(fos);

        BufferedWriter bw = new BufferedWriter(f);

        Scanner scanner = new Scanner(System.in);

        while (((str = scanner.nextLine()) != null) && !"ok".equals(str))
        {

            bw.write(str.concat("\n"));
        }

        bw.close();
        f.close();
        // osw.close();
        // fos.close();
    }
}
