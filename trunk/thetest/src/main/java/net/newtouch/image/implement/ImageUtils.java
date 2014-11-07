package net.newtouch.image.implement;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.im4java.core.GMOperation;
import org.im4java.core.GraphicsMagickCmd;
import org.im4java.process.Pipe;

import com.google.common.collect.Maps;

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

    /**
     * 
     * 压缩图片
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param originImg 需压缩的图片字节数组
     * @param formatName 图片压缩格式
     * @param width 图片压缩所要达到宽度
     * @param height 图片压缩所要达到高度
     * @return 返回压缩图片字节数组
     * @throws Exception
     */
    public static byte[] compress(byte[] originImg, String formatName, int width, int height) throws Exception
    {
        return compress(originImg, formatName, width, height, BufferedImage.TYPE_INT_RGB, Image.SCALE_FAST);
    }

    public static byte[] compressByGM(byte[] originImg, String formatName, int width, int height) throws Exception
    {
        GMOperation op = new GMOperation();
        op.resize(width, height, '!');
        op.addImage("-");
        op.addImage(formatName + ":-");
        Pipe pipeIn = new Pipe(new ByteArrayInputStream(originImg), null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Pipe pipeOut = new Pipe(null, out);
        GraphicsMagickCmd cmd = new GraphicsMagickCmd("convert");
        cmd.setInputProvider(pipeIn);
        cmd.setOutputConsumer(pipeOut);
        cmd.run(op);
        return out.toByteArray();
    }

    /**
     * 
     * 压缩图片
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param originImg 需压缩的图片字节数组
     * @param formatName 图片压缩格式
     * @param width 图片压缩所要达到宽度
     * @param height 图片压缩所要达到高度
     * @param imageType BufferedImage所需的imageType类型
     * @param scaleType BufferedImage的drawImage方法所需的ImageObserver类型
     * @return 返回压缩图片字节数组
     * @throws Exception
     */
    public static byte[] compress(byte[] originImg, String formatName, int width, int height, int imageType,
            int scaleType) throws Exception
    {
        Image img = getImage(originImg);
        BufferedImage bufferedImage = new BufferedImage(width, height, imageType);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(img.getScaledInstance(width, height, scaleType), 0, 0, null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(bufferedImage, StringUtils.isNotEmpty(formatName) ? formatName
                    : FileConstants.PICTRUE_FORMATE_JPG, out);
            byte[] result = out.toByteArray();
            return result;
        }
        finally
        {
            if (null != out)
            {
                out.close();
            }
        }
    }

    /**
     * 
     * 压缩图片,根据图片类型进行相对应的图片压缩
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param originImg 需压缩的图片字节数组
     * @param name 图片名称
     * @param type 图片类型
     * @return 返回压缩图片Map；Key为图片路径，Value为图片字节数组
     * @throws Exception
     */
    public static Map<String, byte[]> compress(byte[] originImg, String name, ImageType type) throws Exception
    {
        Map<String, byte[]> map = Maps.newHashMap();
        String formatName = getExtension(name);
        switch (type)
        {
        case MATERIAL:
            map.put(getName(name, formatName, 265, 265), compressByGM(originImg, formatName, 265, 265));
            map.put(getName(name, formatName, 220, 220), compressByGM(originImg, formatName, 220, 220));
            map.put(getName(name, formatName, 118, 118), compressByGM(originImg, formatName, 118, 118));
            map.put(getName(name, formatName, 45, 45), compressByGM(originImg, formatName, 45, 45));
            map.put(getName(name, formatName, 30, 30), compressByGM(originImg, formatName, 30, 30));
            break;
        case WAREHOUSE:
            map.put(getName(name, formatName, 620, 390), compressByGM(originImg, formatName, 620, 390));
            map.put(getName(name, formatName, 150, 120), compressByGM(originImg, formatName, 150, 120));
            break;
        case PORTRAIT:
            map.put(getName(name, formatName, 70, 70), compressByGM(originImg, formatName, 70, 70));
            map.put(getName(name, formatName, 50, 50), compressByGM(originImg, formatName, 50, 50));
            map.put(getName(name, formatName, 20, 20), compressByGM(originImg, formatName, 20, 20));
            break;
        case SESSION:
            map.put(getName(name, formatName, 158, 158), compressByGM(originImg, formatName, 158, 158));
            map.put(getName(name, formatName, 54, 54), compressByGM(originImg, formatName, 54, 54));
            break;
        case CERTIFICATE:
            map.put(getName(name, formatName, 134, 90), compressByGM(originImg, formatName, 134, 90));
            map.put(getName(name, formatName, 980, 700), compressByGM(originImg, formatName, 980, 700));
            map.put(getName(name, formatName, 140, 104), compressByGM(originImg, formatName, 140, 104));
            break;
        case ID_CARD:
            map.put(getName(name, formatName, 186, 118), compressByGM(originImg, formatName, 186, 118));
            map.put(getName(name, formatName, 300, 190), compressByGM(originImg, formatName, 300, 190));
            break;
        case LOGISTICS:
            map.put(getName(name, formatName, 100, 100), compressByGM(originImg, formatName, 100, 100));
            map.put(getName(name, formatName, 880, 880), compressByGM(originImg, formatName, 880, 880));
            break;
        case LOGO:
            map.put(getName(name, formatName, 102, 30), compressByGM(originImg, formatName, 102, 30));
            break;
        default:
            break;
        }
        return map;
    }

    /**
     * 将图片进行裁剪
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param originImg 需压缩的图片字节数组
     * @param formatName 图片压缩格式
     * @param x 图片裁剪的x坐标
     * @param y 图片裁剪的y坐标
     * @param width 截取的宽
     * @param height 截取的高
     * @param balance_width 比例宽
     * @param balance_height 比例高
     * @throws IOException
     * */
    public static byte[] cutImage(byte[] originImg, String formatName, int x, int y, int width, int height,
            int balance_width, int balance_height) throws Exception
    {
        InputStream is = new ByteArrayInputStream(originImg);
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        try
        {
            // 读取源图片文件
            BufferedImage sourceImage = ImageIO.read(is);
            int ori_width = sourceImage.getWidth();
            int ori_height = sourceImage.getHeight();
            int x_ = x * ori_width / balance_width;
            int y_ = y * ori_height / balance_height;
            int width_ = width * ori_width / balance_width;
            int height_ = height * ori_height / balance_height;
            // System.out.println(x_);
            // System.out.println(y_);
            // System.out.println(width_);
            // System.out.println(height_);

            // 生成过滤器
            ImageFilter cropFilter = new CropImageFilter(x_, y_, width_, height_);
            // 生成图片
            Image image = Toolkit.getDefaultToolkit().createImage(
                    new FilteredImageSource(sourceImage.getSource(), cropFilter));
            // 生成新的画板
            BufferedImage targerImage = new BufferedImage(width_, height_, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = targerImage.createGraphics();
            // 画出最新的图片
            g.drawImage(image, 0, 0, null);
            ImageIO.write(targerImage, StringUtils.isNotEmpty(formatName) ? formatName
                    : FileConstants.PICTRUE_FORMATE_JPG, fos);
            return fos.toByteArray();
        }
        finally
        {
            if (null != is)
            {
                is.close();
            }
            if (null != fos)
            {
                fos.close();
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
            // int imageWidth = 600;
            // int imageHeight = 401;
            // int x = 264;
            // int y = 147;
            // int imageTagWidth = 180;
            // int imageTagHeight = 180;

            FileInputStream fis = new FileInputStream("G:\\DSC_0287.JPG");
            byte[] bs = new byte[fis.available()];
            fis.read(bs);
            // byte[] bs2 = cutImage(bs, "jpg", x, y, imageTagWidth, imageTagHeight, imageWidth, imageHeight);
            byte[] bs2 = compress(bs, "jpg", 100, 100);
            FileOutputStream fos = new FileOutputStream("G:\\DSC_0287_123.jpg");
            fos.write(bs2);
            fis.close();
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String aaa = "asd.Jpg";
        System.out.println(getExtension(aaa));
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
        String[] strs = originImg.split(FileConstants.REGULAR_DOT);
        targerPath = strs[0] + "_" + "watermark" + FileConstants.DOT + FileConstants.PICTRUE_FORMATE_JPG;
        waterMark(originImg, BufferedImage.TYPE_INT_RGB, targerPath, FileConstants.WATERIMG, FileConstants.X,
                FileConstants.Y, AlphaComposite.SRC_ATOP, FileConstants.ALPHA, FileConstants.PICTRUE_FORMATE_JPG);
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
     * 生成Image对象
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param imgBs 图片字节数组
     * @return Image对象
     * @throws Exception
     */
    private static Image getImage(byte[] imgBs) throws Exception
    {
        InputStream is = new ByteArrayInputStream(imgBs);
        try
        {
            return ImageIO.read(is);
        }
        finally
        {
            if (null != is)
            {
                is.close();
            }
        }
    }

    /**
     * 生成Image对象
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param imgPath 图片路径
     * @return Image对象
     * @throws Exception
     */
    private static Image getImage(String imgPath) throws Exception
    {
        return ImageIO.read(new File(imgPath));
    }

    /**
     * 根据所传尺寸建立图片名称
     * 
     * @since 2014年6月23日
     * @author hezhengzheng
     * @param originName 需压缩的图片名称
     * @param width 图片压缩所要达到宽度
     * @param height 图片压缩所要达到高度
     * @return
     */
    public static String getName(String originName, String formatName, int width, int height)
    {
        String[] str = originName.split(FileConstants.REGULAR_DOT);
        return str[0] + FileConstants.UNDER_LINE + width + FileConstants.UNDER_LINE + height + FileConstants.DOT
                + (StringUtils.isNotEmpty(formatName) ? formatName : FileConstants.PICTRUE_FORMATE_JPG);
    }

    /**
     * 
     * 获取后缀名
     * 
     * @since 2014年8月13日
     * @author hezhengzheng
     * @param formatName 原文件名
     * @return
     */
    public static String getExtension(String formatName)
    {
        if (StringUtils.isEmpty(formatName))
        {
            return null;
        }
        int index = formatName.lastIndexOf(FileConstants.DOT);
        return formatName.substring(index + 1, formatName.length()).toLowerCase();
    }
}