package com.hnmmli.local;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceTest
{
    public static void main(String[] args)
    {
        ResourceBundle resource = ResourceBundle.getBundle("resource", Locale.CHINA);
        System.out.println(resource.getString("java.util.logging.ConsoleHandler.level"));
        resource = ResourceBundle.getBundle("resource", Locale.ENGLISH);
        System.out.println(resource.getString("java.util.logging.ConsoleHandler.level"));
    }

}
