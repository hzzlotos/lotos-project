package com.hnmmli.draw;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageFilterTest
{
    public static void main(String[] args)
    {
        // test();
        // javacore_aop();
        // javacore_rop();
        // javacore_lop();
        javacore_cop();
    }

    private static void javacore_aop()
    {
        try
        {
            // BufferedImage biTemp= ImageIO.read(new File("G:/DSC_0275.jpg"));
            BufferedImage biSrc = ImageIO.read(new File("G:/DSC_0275.jpg"));
            AffineTransform atf = AffineTransform.getRotateInstance(Math.toRadians(30), biSrc.getWidth() / 2,
                    biSrc.getHeight() / 2);
            BufferedImageOp aop = new AffineTransformOp(atf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            // BufferedImage bi = aop.filter(biSrc, biTemp);
            BufferedImage bi = aop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-Rotate-temp.jpg"));
            // 旋转
            // -------------------------------------------------------------------------------------
            atf = AffineTransform.getScaleInstance(1.5, 1.5);
            aop = new AffineTransformOp(atf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            bi = aop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-Scale-temp.jpg"));
            // 缩放
            // ---------------------------------------------------------------------------------------
            atf = AffineTransform.getQuadrantRotateInstance(3, biSrc.getWidth() / 2, biSrc.getHeight() / 2);
            aop = new AffineTransformOp(atf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            bi = aop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-QuadrantRotate-temp.jpg"));
            // 90度转换
            // -----------------------------------------------------------------------------------------
            atf = AffineTransform.getTranslateInstance(500, 500);
            aop = new AffineTransformOp(atf, null);
            bi = aop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-Translate-temp.jpg"));
            // 平移
            // ======================================================================================
            BufferedImageOp rop = new RescaleOp(1.1f, 20.0f, null);
            bi = rop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-RescaleOp-temp.jpg"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void javacore_rop()
    {
        // 公式为X[new] = aX+b; 即RescaleOp(a,b,null); 当a>1时图片增亮
        try
        {
            BufferedImage biSrc = ImageIO.read(new File("G:/DSC_0275.jpg"));
            BufferedImageOp rop = new RescaleOp(1.1f, 100.0f, null);
            BufferedImage bi = rop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-RescaleOp-temp.jpg"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void javacore_lop()
    {
        try
        {
            BufferedImage biSrc = ImageIO.read(new File("G:/DSC_0275.jpg"));
            BufferedImage newPic = new BufferedImage(biSrc.getWidth(), biSrc.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            short[] brighten = new short[256]; // 查找表的数据数组
            short pixelValue;
            for (int i = 0; i < 256; i++)
            {
                pixelValue = (short) (i + 100);// 加亮源像素10 个单位值
                if (pixelValue > 255)
                {
                    pixelValue = 255;
                }
                else
                    if (pixelValue < 0)
                    {
                        pixelValue = 0;
                    }
                brighten[i] = pixelValue; // 赋值
            }
            LookupTable lt = new ShortLookupTable(0, brighten); // 创建新的查找表，该表加亮源图像
            BufferedImageOp lop = new LookupOp(lt, null);
            BufferedImage bi = lop.filter(biSrc, newPic);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-LookupOp-temp.jpg"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void javacore_cop()
    {
        try
        {
            BufferedImage biSrc = ImageIO.read(new File("G:/DSC_0275.jpg"));
            // BufferedImage newPic = new BufferedImage(biSrc.getWidth(), biSrc.getHeight(),
            // BufferedImage.TYPE_3BYTE_BGR);
            float[] elements = { -0.5f, 0.5f, -0.5f, 0.5f, 2.0f, 0.5f, -0.5f, 0.5f, -0.5f };
            Kernel kernel = new Kernel(3, 3, elements);
            BufferedImageOp lop = new ConvolveOp(kernel);
            BufferedImage bi = lop.filter(biSrc, null);
            ImageIO.write(bi, "jpg", new File("G:/DSC_0275-ConvolveOp-temp.jpg"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void test()
    {
        try
        {
            File src = new File("G:/DSC_0275.jpg");
            File dst = new File("G:/DSC_0275-temp.jpg");
            BufferedImage biSrc = ImageIO.read(src);
            AffineTransform atf = new AffineTransform();
            atf.scale(0.5, 0.5);
            BufferedImageOp op = new AffineTransformOp(atf, null);
            System.out.println(op);
            BufferedImage bi = op.filter(biSrc, null);
            ImageIO.write(bi, "jpg", dst);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}