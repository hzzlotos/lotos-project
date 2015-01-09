package javacore.draw;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class GraphicsTest
{
    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        // 设置绘画质量 提供了速度与绘图质量之间的一种平衡

        // KEY_ANTIALIASING 决定是否使用抗锯齿。当着色有倾斜角度的线时，通常会得到一组阶梯式的像素排列，使这条线看上去不平滑，经常被称为
        // 锯齿状图形。抗锯齿是一种技术，它设置有倾斜角度的线的像素亮度，以使线看起来更平滑。因此，这个微调是用来决定在着色有倾斜角度的线时是否在减少锯齿状图形上花费时间。可能的值有 VALUE_ANTIALIAS_ON,
        // _OFF 或 _DEFAULT。
        // KEY_COLOR_RENDERING 控制颜色着色的方式。可能的值有 VALUE_COLOR_RENDER_SPEED, _QUALITY 或 _DEFAULT。
        // KEY_DITHERING 控制如何处理抖动。抖动是用一组有限的颜色合成出一个更大范围的颜色的过程，方法是给相邻像素着色以产生不在该组颜色中的新的颜色幻觉。可能的值有 VALUE_DITHER_ENABLE,
        // _DISABLE 或 _DEFAULT。
        // KEY_FRACTIONALMETRICS 控制显示文本的质量。可能的值有 VALUE_FRACTIONALMETRICS_ON, _OFF 或 _DEFAULT。
        // KEY_INTERPOLATION
        // 确定怎样做内插。在对一个源图像做变形时，变形后的像素很少能够恰好对应目标像素位置。在这种情况下，每个变形后的像素的颜色值不得不由四周的像素决定。内插就是实现上述过程。有许多可用的技术。可能的值，按处理时间从最多到最少，是
        // VALUE_INTERPOLATION_BICUBIC, _BILINEAR 或 _NEAREST_NEIGHBOR。
        // KEY_RENDERING 确定着色技术，在速度和质量之间进行权衡。可能的值有 VALUE_RENDERING_SPEED, _QUALITY 或 _DEFAULT。
        // KEY_TEXT_ANTIALIASING 确定对文本着色时是否抗锯齿。可能的值有 VALUE_TEXT_ANTIALIASING_ON, _OFF 或 _DEFAULT。
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
        g2.setRenderingHints(hints);

        // 设置笔画，笔画用于绘制形状的边框。可以选择边框的粗细与线段的虚实。
        Stroke stroke = new BasicStroke();
        g2.setStroke(stroke);

        // 设置着色法，着色法用于填充诸如笔划路径或者形状内部等区域的颜色。可以创建单色，渐变色或者平铺的填充模式。
        Paint paint = new Color(24);
        g2.setPaint(paint);

        // 使用clip方法来设置剪切区域
        Shape clip = new Area();
        g2.setClip(clip);

        // 使用transform方法设置一个从用户空间到设备空间的变换方法。如果使用变换方式比使用像素坐标更容易定义在定制坐标系统中的形状，那么就可以使用变换方式。
        AffineTransform transform = new AffineTransform();
        g2.transform(transform);

        // 设置组合规则，用来描述如何将新像素与现有像素组合起来
        Composite composite = AlphaComposite.Clear;
        g2.setComposite(composite);

        // 绘制或填充该形状。如果要绘制该形状，那么它的边框就会用笔划画出来。如果要填充该形状，那么它的内部就会被着色。
        Shape shape = null;
        g2.draw(shape);
        g2.fill(shape);

        // 绘制形状的若干方法
        // g2.drawLine(x1, y1, x2, y2);;
        // g2.drawRect(x, y, width, height);
        // g2.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
        // g2.draw3DRect(x, y, width, height, raised);
        // g2.drawPolygon(xPoints, yPoints, nPoints);
        // g2.drawPolyline(xPoints, yPoints, nPoints);
        // g2.drawOval(x, y, width, height);
        // g2.drawArc(x, y, width, height, startAngle, arcAngle);

        g2.fill(shape);

        // 此类是所有存储 2D 矩形的对象的惟一抽象超类。
        // 通过位置 (x,y) 和尺寸 (w x h) 定义的矩形。
        Rectangle2D floatRect = new Rectangle2D.Float(5F, 10F, 7.5F, 15F);
        g2.draw(floatRect);

        Rectangle2D doubleRect = new Rectangle2D.Double(5, 10, 7.5, 15);
        g2.draw(doubleRect);

        // 此类是所有保存 2D 圆角矩形的对象的抽象超类。
        // RoundRectangle2D 类定义一个矩形，该矩形具有由位置 (x,y)、维度 (w x h) 以及圆角弧的宽度和高度定义的圆角。
        RoundRectangle2D round = new RoundRectangle2D.Double(150, 200, 100, 50, 20, 20);
        g2.draw(round);

        // Arc2D 是所有存储 2D 弧度的对象的抽象超类，其中 2D 弧度由窗体矩形、起始角度、角跨越（弧的长度）和闭合类型（OPEN、CHORD 或 PIE）定义。
        Arc2D arc = new Arc2D.Double(10, 10, 10, 10, 50, 50, Arc2D.OPEN);
        g2.draw(arc);

        // 构建二次曲线与三次曲线，需要给出两个端点与控制点的坐标
        QuadCurve2D q = new QuadCurve2D.Double(0, 0, 50, 50, 100, 100);
        g2.draw(q);
        CubicCurve2D c = new CubicCurve2D.Double(0, 0, 30, 30, 60, 60, 100, 100);
        g2.draw(c);

        // 建立路径，通过moveTo方法来制定第一个坐标
        GeneralPath path = new GeneralPath();
        // 若要绘制一个多边形，只需调用moveTo方法以到达第一个拐角点，
        // 然后反复调用lineTo方法，以便到达其他的拐角点。
        // 最后调用closePath方法来闭合多边形。
        // 普通枯井没有必要一定要连接在一起，随时都可以调用moveTo方法来创建一个新的路径段。
        // 可以使用append方法向普通路径添加任意个Shape对象。
        // 如果新建的形状应该连接到路径的最后一个端点，那么append方法的第二个仓参数就是true，如果不应该连接，那么该参数值就是false。
        path.moveTo(10, 20);
        path.lineTo(50, 70);
        path.quadTo(30, 80, 80, 90);
        path.curveTo(10, 20, 30, 40, 50, 60);
        Rectangle2D r = new Rectangle2D.Double();
        path.append(r, false);// 不闭合多边形
        path.append(r, true);// 闭合多边形，但是并不与现在的路径连接在一起。
        path.closePath();
        g2.draw(path);

        System.out.println(g2);
    }
}