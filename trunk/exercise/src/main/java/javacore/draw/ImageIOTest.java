package javacore.draw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;

import javacore.draw.javacore.RenderQualityTest;

public class ImageIOTest
{

    public static void main(String[] args)
    {
        // base();
        // getOriginatingProvider();
        // getFormateNames();
        baseGIF();
    }

    private static void base()
    {
        try
        {
            File f = new File(RenderQualityTest.class.getClassLoader().getResource("").getPath() + "face.gif");
            BufferedImage image = ImageIO.read(f);
            File f2 = new File("g:/javacore's_text.jpeg");
            ImageIO.write(image, "JPEG", f2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * gif 不能成功
     * Description of this Method
     * 
     * @since 2014年8月15日
     * @author Administrator
     */
    private static void baseGIF()
    {
        try
        {
            File f = new File("g:/a8f99c7fjw1e1264vv9nxg.gif");
            BufferedImage image = ImageIO.read(f);
            File f2 = new File("g:/javacore's_text.gif");
            ImageIO.write(image, "gif", f2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void getOriginatingProvider()
    {

        try
        {
            ImageReader reader;
            Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("JPEG");
            if (iter.hasNext())
            {
                reader = iter.next();
                System.out.println(reader.getFormatName());
                ImageReaderSpi spi = reader.getOriginatingProvider();
                String vendor = spi.getVendorName();
                String version = spi.getVersion();
                System.out.println(vendor + "---" + version);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void getFormateNames()
    {
        String[] extensions = ImageIO.getWriterFileSuffixes();
        for (String str : extensions)
        {
            System.out.println("===------" + str);
        }
        System.out.println("==========================================================");
        String[] formateNames = ImageIO.getWriterFormatNames();
        for (String str : formateNames)
        {
            System.out.println("===------" + str);
        }
    }
}