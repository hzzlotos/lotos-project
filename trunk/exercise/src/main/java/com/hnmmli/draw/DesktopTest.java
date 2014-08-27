package com.hnmmli.draw;

import java.awt.Desktop;
import java.io.File;

public class DesktopTest
{
    public static void main(String[] args)
    {
        try
        {
            Desktop.getDesktop().open(new File("F:/exercise-1.0.jar"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}