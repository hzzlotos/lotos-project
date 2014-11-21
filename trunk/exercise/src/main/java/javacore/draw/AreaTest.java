package javacore.draw;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class AreaTest
{
    public static void main(String[] args)
    {
        // 区域
        Area area1 = new Area(new Rectangle2D.Double(100, 100, 100, 100));
        Area area2 = new Area(new Rectangle2D.Double(50, 50, 100, 100));
        area1.add(area2);
        area1.subtract(area2);
        area1.intersect(area2);
        area1.exclusiveOr(area2);
    }
}