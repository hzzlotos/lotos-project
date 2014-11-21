package javacore.draw;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class BianHuan
{
    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        double temp = 0;
        // 缩放
        g2.scale(temp, temp);
        // 旋转
        g2.rotate(temp);
        // 平移
        g2.translate(temp, temp);
        // 剪裁
        g2.shear(temp, temp);

        // 2D 仿射变换
        AffineTransform af = new AffineTransform();
        af = AffineTransform.getRotateInstance(temp);
        af = AffineTransform.getScaleInstance(temp, temp);
        af = AffineTransform.getTranslateInstance(temp, temp);
        af = AffineTransform.getShearInstance(temp, temp);
        af.setToRotation(temp);
        af.setToScale(temp, temp);
        af.setToShear(temp, temp);
        af.setToTranslation(temp, temp);
    }
}