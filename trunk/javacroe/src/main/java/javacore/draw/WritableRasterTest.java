package javacore.draw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class WritableRasterTest
{
    public static void main(String[] args)
    {
        BufferedImage image = new BufferedImage(0, 0, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = image.getRaster();
        int[] black = { 0, 0, 0, 225 };
        raster.setPixel(100, 100, black);

        float[] red = { 1F, 0F, 0F, 1F };
        raster.setPixel(100, 100, red);// ERROR
        // 无论数组属于什么类型，都必须提供介于0与255之间的某个值
        // image.flush();
        ColorModel cm = image.getColorModel();
        Object data = raster.getDataElements(100, 100, null);
        int argb = cm.getRGB(data);
        Color color = new Color(argb, true);
        int argbTemp = color.getRGB();
        Object dataTemp = cm.getDataElements(argbTemp, null);
        raster.setDataElements(100, 100, dataTemp);
    }
}