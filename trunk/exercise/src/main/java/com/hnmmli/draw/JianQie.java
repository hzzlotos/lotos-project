package com.hnmmli.draw;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

public class JianQie
{
    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        int temp = 0;
        Shape clip = new Area();
        // --- 不应该被调用
        g2.setClip(temp, temp, temp, temp);
        g2.draw(clip);
        // --- 使用这个是合适
        g2.clip(clip);

        FontRenderContext context = g2.getFontRenderContext();

        TextLayout layout = new TextLayout("hello", new Font("宋体", Font.BOLD, 18), context);
        System.out.println(layout);
    }
}