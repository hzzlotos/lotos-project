package javacore.draw.javacore;

import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintJobAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintJobAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;

/**
 * This program demonstrates the use of print services. The program lets you print a GIF image to
 * any of the print services that support the GIF document flavor.
 * 
 * @version 1.10 2007-08-16
 * @author Cay Horstmann
 */
public class PrintServiceTest // implements ActionListener, Printable
{
    public static void main(String[] args)
    {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
        // DocFlavor flavor = new DocFlavor(DocFlavor.URL.GIF.toString(), InputStream.class.getName());
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        // if (args.length == 0)
        // {
        if (services.length == 0)
        {
            System.out.println("No printer for flavor " + flavor);
        }
        else
        {
            System.out.println("Specify a file of flavor " + flavor
                    + "\nand optionally the number of the desired printer.");
            for (int i = 0; i < services.length; i++)
            {
                System.out.println((i + 1) + ": " + services[i].getName());
            }
        }
        // System.exit(0);
        // }
        // String fileName = args[0];
        String fileName = "g:/ce8wbQXWT9qI.jpg";
        if (args.length > 1)
        {
            Integer.parseInt(args[1]);
        }
        try
        {
            if (fileName == null)
            {
                return;
            }
            FileInputStream in = new FileInputStream(fileName);
            Doc doc = new SimpleDoc(in, flavor, null);
            for (PrintService service : services)
            {
                try
                {
                    DocPrintJob job = service.createPrintJob();
                    job.print(doc, null);
                }
                catch (Exception e)
                {
                    System.out.println("--------------" + service.getName() + " is bad--------------------");
                    e.printStackTrace();
                    System.out.println("----------------------------------");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // ==========================================================
    /**
     * Interface
     */
    private AttributeSet                 interSet1;

    private PrintRequestAttributeSet     interSet2;

    private DocAttributeSet              interSet3;

    private PrintServiceAttributeSet     interSet4;

    private PrintJobAttributeSet         interSet5;

    /**
     * impl
     */
    private HashAttributeSet             implSet1;

    private HashPrintRequestAttributeSet implSet2;

    private HashDocAttributeSet          implSet3;

    private HashPrintServiceAttributeSet implSet4;

    private HashPrintJobAttributeSet     implSet5;
}