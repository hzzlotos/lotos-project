package javacore.draw;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class ColorTest
{
    public static void main(String[] args)
    {
        try
        {
            BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            Point2D p1 = new Point2D.Double(100, 200);
            Point2D p2 = new Point2D.Double(200, 300);
            GradientPaint gp = new GradientPaint(p1, Color.RED, p2, Color.GREEN);
            g2.setPaint(Color.RED);
            g2.setPaint(gp);
            new TexturePaint(bufferedImage, new Rectangle2D.Double());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // 透明与组合部分
    private static void test()
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        // red ,green ,blue ,alpha
        Color c = new Color(0.7F, 0.7F, 0.0F, 0.3F);
        System.out.println(c);
        Shape shape = new Area();

        int rule = AlphaComposite.SRC_OVER;
        float alpha = 0.5f;
        g2.setComposite(AlphaComposite.getInstance(rule, alpha));
        g2.setPaint(Color.blue);
        g2.fill(shape);

        g2.drawImage(bufferedImage, null, 0, 0);
    }
}