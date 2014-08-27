package com.hnmmli.draw;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class BasePrintServiceTest
{
    public static void main(String[] args)
    {
        try
        {
            DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
            PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
            for (PrintService service : services)
            {
                DocPrintJob job = service.createPrintJob();
                InputStream in = new FileInputStream("g:/ce8wbQXWT9qI.jpg");
                Doc doc = new SimpleDoc(in, flavor, null);
                job.print(doc, null);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}