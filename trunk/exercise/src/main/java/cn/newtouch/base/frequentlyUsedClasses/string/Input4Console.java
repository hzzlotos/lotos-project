package cn.newtouch.base.frequentlyUsedClasses.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input4Console
{

    public String input()
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result = "";

        String str = null;

        try
        {

            System.out.println("input,please!");

            while (!"ok".equals(str = br.readLine()))
            {

                result = result.concat("\n").concat(str);
            }

            br.close();

        }
        catch (IOException e)
        {

            e.printStackTrace();
        }

        return result;
    }
}
