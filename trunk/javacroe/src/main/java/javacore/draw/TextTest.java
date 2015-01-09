package javacore.draw;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class TextTest
{
    private static int NLINES = 10000;

    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        FontRenderContext context = g2.getFontRenderContext();
        TextLayout layout = new TextLayout("hello", new Font("宋体", Font.BOLD, 18), context);
        AffineTransform transform = AffineTransform.getTranslateInstance(0, 100);
        Shape outline = layout.getOutline(transform);

        GeneralPath clipShape = new GeneralPath();
        clipShape.append(outline, false);

        g2.setClip(clipShape);
        Point2D p2 = new Point2D.Double(0, 0);
        for (int i = 0; i < NLINES; i++)
        {
            double x = 100;
            double y = 100;
            Point2D q = new Point2D.Double(x, y);
            g2.draw(new Line2D.Float(p2, q));
        }
    }

}
