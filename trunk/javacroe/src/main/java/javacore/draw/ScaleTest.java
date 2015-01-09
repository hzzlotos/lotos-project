package javacore.draw;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class ScaleTest
{

    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        // 可以将图形上下文中的坐标变换设置为一个比例变换，这种变换能够将用户坐标转换成设备坐标

        // 将当前 Graphics2D Transform 与缩放转换连接。
        g2.scale(100, 200);
        // 将当前的 Graphics2D Transform 与旋转转换连接。
        g2.rotate(50);
        // 将当前 Graphics2D Transform 与平移转换连接。
        g2.translate(30, 70);
        // 将当前 Graphics2D Transform 与剪裁转换连接。
        g2.shear(150, 200);
        g2.draw(new Line2D.Double());
    }
}