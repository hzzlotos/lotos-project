package com.hnmmli.draw;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class ClipboardTest
{
    public static void main(String[] args)
    {
        // getByClip();
        setToClip();
        // showAll();
    }

    private static void showAll()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor[] flavors = clipboard.getAvailableDataFlavors();
        for (DataFlavor flavor : flavors)
        {
            System.out.println(flavor.getMimeType());
        }
    }

    private static void setToClip()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = "java clip";
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    private static void getByClip()
    {
        try
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor flavor = DataFlavor.stringFlavor;
            if (clipboard.isDataFlavorAvailable(flavor))
            {
                String text = (String) clipboard.getData(flavor);
                System.out.println(text);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}