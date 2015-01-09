package javacore.draw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import javacore.draw.gif.AnimatedGifEncoder;
import javacore.draw.gif.GifDecoder;

public class GIFTest
{
    public static void main(String[] args)
    {
        try
        {
            // javaRead(); // 该方法废弃
            // copyGif();
            cutGif();
            spellGif();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void cutGif() throws Exception
    {
        GifDecoder d = new GifDecoder();
        // file:///C:/Documents and Settings/Administrator/dk.JPEG
        d.read("G:/giftest/a.gif");
        int n = d.getFrameCount();
        for (int i = 0; i < n; i++)
        {
            ImageIO.write(d.getFrame(i), "gif", new File("g:/giftest/cut/split" + i + ".gif"));
        }
    }

    private static void spellGif() throws Exception
    {
        AnimatedGifEncoder e = new AnimatedGifEncoder();
        e.start("g:/giftest/spellGif.gif");// 开始处理
        // e.setQuality(256);
        e.setDelay(100); // 设置延迟时间
        for (int i = 0; i < 186; i++)
        {
            // System.out.println(d.getFrame(i));
            e.addFrame(ImageIO.read(new File("G:/giftest/cut/split" + i + ".gif")));// 加入Frame
            // System.out.println(d.getDelay(i));
        }
        e.finish();
    }

    private static void copyGif() throws Exception
    {
        GifDecoder d = new GifDecoder();
        // file:///C:/Documents and Settings/Administrator/dk.JPEG
        d.read("G:/giftest/a.gif");
        int n = d.getFrameCount();
        AnimatedGifEncoder e = new AnimatedGifEncoder();
        e.start("g:/giftest/copyGif.gif");// 开始处理
        // e.setQuality(256);
        e.setDelay(d.getDelay(0)); // 设置延迟时间
        for (int i = 0; i < n; i++)
        {
            // System.out.println(d.getFrame(i));
            e.addFrame(d.getFrame(i));// 加入Frame
            // System.out.println(d.getDelay(i));
        }
        e.finish();
    }

    /**
     * 该方法有问题，不能这样使用
     */
    @Deprecated
    private static void javaRead() throws Exception
    {
        InputStream in = new FileInputStream("g:/giftest/a.gif");
        ImageInputStream imageIn = ImageIO.createImageInputStream(in);
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("gif");
        ImageReader reader = readers.next();
        reader.setInput(imageIn);
        int n = reader.getNumImages(true);
        System.out.println(n);
        for (int i = 0; i < n; i++)
        {
            int width = reader.getWidth(i);
            int height = reader.getWidth(i);
            System.out.println("width===" + width + ";height===" + height);
            BufferedImage image = reader.read(i);
            ImageIO.write(image, "gif", new File("g:/giftest/split" + i + ".gif"));
        }
    }

}