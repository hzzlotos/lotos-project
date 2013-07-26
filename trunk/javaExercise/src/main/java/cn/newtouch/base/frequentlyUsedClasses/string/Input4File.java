package cn.newtouch.base.frequentlyUsedClasses.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input4File
{

    public String input(String str)
    {

        String result = "";

        String line = null;

        try
        {

            File file = new File(str);

            FileInputStream fis = new FileInputStream(file);

            InputStreamReader read = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(read);

            // br = new BufferedReader(new FileReader(str));

            while (null != (line = br.readLine()))
            {

                result = result.concat(line.concat("\n"));
            }

        }
        catch (FileNotFoundException e)
        {

            e.printStackTrace();

        }
        catch (IOException e)
        {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}
