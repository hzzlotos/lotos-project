package javacore.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class StrokeTest_bihua
{
    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        // 绘制了一条粗细为10个像素的线条
        // 无装饰地结束未封闭的子路径和虚线线段
        // 通过舍去半径为线长的一半的圆角，将路径线段连接在一起
        g2.setStroke(new BasicStroke(10.0F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2.draw(new Line2D.Double());
        float[] dashpatten = { 10, 10, 10, 10, 10, 10, 30, 10, 30 };
        g2.setStroke(new BasicStroke(10.0F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0F, dashpatten, 0F));
    }
}