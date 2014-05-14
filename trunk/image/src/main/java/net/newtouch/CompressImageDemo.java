package net.newtouch;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 *  缩略图实现，将图片(jpg、bmp、png、gif等等)真实的变成想要的大小
 */

/*******************************************************************************
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 */
public class CompressImageDemo
{

    // 图片处理
    public static String compressPic(String inputFileName, String outputFileName, int outputWidth, int outputHeight)
    {
        try
        {
            // 获得源文件
            File file = new File(inputFileName);
            if (!file.exists())
            {
                return "";
            }
            Image img = ImageIO.read(file);
            System.out.println(img.getWidth(null));
            System.out.println(img.getHeight(null));
            System.out.println("====================================");
            // 判断图片格式是否正确
            if (img.getWidth(null) == -1)
            {
                return null;
            }
            else
            {
                // 为等比缩放计算输出的图片宽度及高度
                double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;
                double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;
                // 根据缩放比率大的进行缩放控制
                double rate = rate1 > rate2 ? rate1 : rate2;
                int newWidth = (int) ((img.getWidth(null)) / rate);
                int newHeight = (int) ((img.getHeight(null)) / rate);
                BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                /*
                 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的
                 * 优先级比速度高 生成的图片质量比较好 但速度慢
                 */
                tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
                FileOutputStream out = new FileOutputStream(outputFileName);
                // JPEGImageEncoder可适用于其他图片类型的转换
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                encoder.encode(tag);
                out.close();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return "ok";
    }

    // main测试
    // compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
    public static void main(String[] arg)
    {
        CompressImageDemo mypic = new CompressImageDemo();
        mypic.compressPic("E:\\test\\imagetest\\origin\\DSC_0674.jpg",
                "E:\\test\\imagetest\\target\\DSC_0674_yasuo.jpg", 1024, 768);
    }

}
