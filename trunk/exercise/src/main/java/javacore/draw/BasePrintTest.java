package javacore.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;

public class BasePrintTest implements Printable
{
    public static void main(String[] args)
    {
        Printable canvas = new BasePrintTest();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(canvas);
        HashPrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        if (job.printDialog(attributes))
        {
            try
            {
                job.print(attributes);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException
    {
        try
        {
            if (page >= 1)
            {
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            BufferedImage image = ImageIO.read(new File("g:/ce8wbQXWT9qI.jpg"));
            AffineTransform atf = AffineTransform.getScaleInstance(0.5, 0.5);
            BufferedImageOp aop = new AffineTransformOp(atf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            aop.filter(image, null);
            g2.drawImage(image, 0, 0, null);
            return Printable.PAGE_EXISTS;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}