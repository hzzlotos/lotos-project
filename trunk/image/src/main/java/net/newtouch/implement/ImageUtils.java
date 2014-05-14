package net.newtouch.implement;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片处理服务
 * 
 * @author hezhengzheng
 * @version 1.0
 * @since 2014年5月5日
 */
public class ImageUtils
{

    private static String       waterImg            = "E:" + File.separator + "test" + File.separator + "imagetest"
                                                            + File.separator + "origin" + File.separator
                                                            + "steelgt_logo.png";

    private static int          x                   = 30;

    private static int          y                   = 30;

    private static float        alpha               = 0.8F;

    /** 图片格式：JPG */
    private static final String PICTRUE_FORMATE_JPG = "jpg";

    private static Image getImage(String imgPath) throws Exception
    {
        return ImageIO.read(new File(imgPath));
    }

    /**
     * 
     * 图片添加水印 参数为默认值
     * 
     * @since 2014年5月13日
     * @author hezhengzheng
     * @param originImg 源图片地址
     * @return 已加水印图片地址
     * @throws Exception
     */
    public static String waterMark(String originImg) throws Exception
    {
        String targerPath = null;
        String[] strs = originImg.split("\\.");
        targerPath = strs[0] + "_" + "watermark" + "." + PICTRUE_FORMATE_JPG;
        waterMark(originImg, BufferedImage.TYPE_INT_RGB, targerPath, waterImg, x, y, AlphaComposite.SRC_ATOP, alpha,
                PICTRUE_FORMATE_JPG);
        return targerPath;
    }

    /**
     * 
     * 图片添加水印
     * 
     * @since 2014年5月13日
     * @author hezhengzheng
     * @param originImg 源图片地址
     * @param imageType 图片type 参照BufferedImage的TYPE静态字段
     * @param targerPath 目标图片地址
     * @param waterImg 水印图片地址
     * @param x 水印左上角横坐标
     * @param y 水印左上角竖坐标
     * @param rule 合成规则 参照AlphaComposite
     * @param alpha 将乘源色的 alpha 值的常量 alpha 值。alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字。
     * @param formatName 图片格式 参照本类的PICTRUE_FORMATE字段
     * @throws Exception
     */
    public static void waterMark(String originImg, int imageType, String targerPath, String waterImg, int x, int y,
            int rule, float alpha, String formatName) throws Exception
    {
        Image image = getImage(originImg);
        Image waterImage = getImage(waterImg); // 水印文件
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int width_w = waterImage.getWidth(null);
        int height_w = waterImage.getHeight(null);
        BufferedImage bufferedImage = new BufferedImage(width, height, imageType);
        Graphics2D g = bufferedImage.createGraphics();
        g.setComposite(AlphaComposite.getInstance(rule, alpha));
        g.drawImage(image, 0, 0, width, height, null);
        g.drawImage(waterImage, getCoordinate(x, width, width_w), getCoordinate(x, height, height_w), width_w,
                height_w, null); // 水印文件结束
        g.dispose();
        ImageIO.write(bufferedImage, formatName, new File(targerPath));
    }

    private static int getCoordinate(int coordinate, int org, int water)
    {
        int result = coordinate;
        int diff = org - water;
        if (coordinate < 0)
        {
            result = diff / 2;
        }
        else
            if (coordinate > diff)
            {
                result = diff;
            }
        return result;
    }

    /**
     * 
     * 压缩图片，根据物资类型进行指定压缩
     * 
     * @since 2014年5月13日
     * @author hezhengzheng
     * @param originImg 需压缩的图片路径
     * @param type 图片类型
     * @throws Exception
     */
    public static void compress(String originImg, ImageType type) throws Exception
    {
        switch (type)
        {
        case MATERIAL:
            compress(originImg, 265, 265);
            compress(originImg, 220, 220);
            compress(originImg, 118, 118);
            compress(originImg, 45, 45);
            compress(originImg, 30, 30);
            break;
        case STORE:
            compress(originImg, 620, 390);
            compress(originImg, 150, 120);
            break;
        case PORTRAIT:
            compress(originImg, 70, 70);
            compress(originImg, 50, 50);
            compress(originImg, 20, 20);
            break;
        case MARKET:
            compress(originImg, 158, 158);
            compress(originImg, 54, 54);
            break;
        case CREDENTIAL:
            compress(originImg, 134, 90);
            compress(originImg, 140, 104);
            break;
        default:
            break;
        }
    }

    public static void compress(String originImg, int width, int height) throws Exception
    {
        String[] str = originImg.split("\\.");
        String targerPath = str[0] + "_" + width + "_" + height + "." + str[1];
        compress(originImg, targerPath, width, height);
    }

    public static void compress(String originImg, String targerImg, int width, int height) throws Exception
    {
        compress(originImg, BufferedImage.TYPE_INT_RGB, Image.SCALE_SMOOTH, targerImg, width, height);
    }

    public static void compress(String originImg, int imageType, int scaleType, String targerImg, int width, int height)
            throws Exception
    {
        Image img = getImage(originImg);
        // double rate1 = ((double) img.getWidth(null)) / (double) width + 0.1;
        // double rate2 = ((double) img.getHeight(null)) / (double) height + 0.1;
        // double rate = rate1 > rate2 ? rate1 : rate2;
        // int newWidth = (int) ((img.getWidth(null)) / rate);
        // int newHeight = (int) ((img.getHeight(null)) / rate);
        BufferedImage tag = new BufferedImage(width, height, imageType);
        tag.getGraphics().drawImage(img.getScaledInstance(width, height, scaleType), 0, 0, null);
        // FileOutputStream out = new FileOutputStream(targerPath);
        ImageIO.write(tag, "jpg", new File(targerImg));
        // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        // encoder.encode(tag);
        // out.close();
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println("===========================" + waterMark("E:/test/imagetest/target/yuantu.jpg"));
            compress("E:/test/imagetest/target/yuantu.jpg", 1024, 768);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
