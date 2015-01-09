package javacore.draw;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class RenderingHintTest
{

    public static void main(String[] args)
    {
        BufferedImage bufferedImage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();

        /*
         * KEY_ALPHA_INTERPOLATION Alpha 插值提示键。
         * VALUE_ALPHA_INTERPOLATION_DEFAULT
         * Alpha 插值提示值——由实现选择对性能和质量进行良好权衡的 alpha 混合算法
         * VALUE_ALPHA_INTERPOLATION_QUALITY
         * Alpha 插值提示值——选择偏重于精确度和视觉质量的 alpha 混合算法。
         * VALUE_ALPHA_INTERPOLATION_SPEED
         * Alpha 插值提示值——选择偏重于计算速度的 alpha 混合算法。
         */

        /*
         * KEY_ANTIALIASING 抗锯齿提示键。
         * VALUE_ANTIALIAS_DEFAULT
         * 抗锯齿提示值——使用由实现选择的默认抗锯齿模式完成呈现。
         * VALUE_ANTIALIAS_OFF
         * 抗锯齿提示值——在不使用抗锯齿模式的情况下完成呈现。
         * VALUE_ANTIALIAS_ON
         * 抗锯齿提示值——使用抗锯齿模式完成呈现。
         */

        /*
         * KEY_COLOR_RENDERING 颜色呈现提示键。
         * VALUE_COLOR_RENDER_DEFAULT
         * 颜色呈现提示值——根据实现的选择执行颜色转换计算，以表示可用的性能和精确度之间的最佳权衡。
         * VALUE_COLOR_RENDER_QUALITY
         * 颜色呈现提示值——用最高的精确度和视觉质量执行颜色转换计算。
         * VALUE_COLOR_RENDER_SPEED
         * 颜色呈现提示值——最快地执行输出设备格式的颜色转换。
         */

        /*
         * KEY_DITHERING 抖动提示键。
         * VALUE_DITHER_DEFAULT
         * 抖动提示值——对该实现选择的抖动使用默认值。
         * VALUE_DITHER_DISABLE
         * 抖动提示值——呈现几何形状时不抖动。
         * VALUE_DITHER_ENABLE
         * 抖动提示值——如果需要，在呈现几何形状时抖动。
         */

        /*
         * KEY_FRACTIONALMETRICS 字体小数规格提示键。
         * VALUE_FRACTIONALMETRICS_DEFAULT
         * 字体小数规格提示值——用实现选择的精度定位字符字形。
         * VALUE_FRACTIONALMETRICS_OFF
         * 字体小数规格提示值——用舍入为像素边界的 advance width 定位字符字形。
         * VALUE_FRACTIONALMETRICS_ON
         * 字体小数规格提示值——用子像素精确度定位字符字形。
         */

        /*
         * KEY_INTERPOLATION 插值提示键。
         * VALUE_INTERPOLATION_BICUBIC
         * 插值提示值—— 使用 X 和 Y 中的立方函数插入图像中整数坐标附近的 9 个样本，以生成一个颜色样本。
         * VALUE_INTERPOLATION_BILINEAR
         * 插值提示值——图像中最接近整数坐标样本的 4 种颜色样本被线性地插入，以生成一个颜色样本。
         * VALUE_INTERPOLATION_NEAREST_NEIGHBOR
         * 插值提示值——使用图像中最接近整数坐标样本的颜色样本。
         */

        /*
         * KEY_RENDERING 呈现提示键。
         * VALUE_RENDER_DEFAULT
         * 呈现提示值——由实现选择对性能和质量进行良好权衡的呈现算法。
         * VALUE_RENDER_QUALITY
         * 呈现提示值——选择偏重输出质量的呈现算法。
         * VALUE_RENDER_SPEED
         * 呈现提示值——选择偏重输出速度的呈现算法。
         */

        /*
         * KEY_STROKE_CONTROL 笔划规范化控制提示键。
         * VALUE_STROKE_DEFAULT
         * 笔划规范化控制提示值——根据给定实现的权衡，可以修改几何形状或保留原来的几何形状。
         * VALUE_STROKE_NORMALIZE
         * 笔划规范化控制提示值——几何形状应当规范化，以提高均匀性或直线间隔和整体美观。
         * VALUE_STROKE_PURE
         * 笔划规范化控制提示值——几何形状应该保持不变并使用子像素精确度呈现。
         */

        /*
         * KEY_TEXT_ANTIALIASING 文本抗锯齿提示键。
         * VALUE_TEXT_ANTIALIAS_DEFAULT
         * 文本抗锯齿提示值——根据 KEY_ANTIALIASING 提示或由实现选择的默认值完成文本呈现。
         * VALUE_TEXT_ANTIALIAS_GASP
         * 文本抗锯齿提示值——文本呈现需要使用字体资源中的信息，这些信息指定了每个点大小是否适合应用 VALUE_TEXT_ANTIALIAS_ON 或 VALUE_TEXT_ANTIALIAS_OFF。
         * VALUE_TEXT_ANTIALIAS_LCD_HBGR
         * 文本抗锯齿提示值——要求针对 LCD 显示器优化文本显示，子像素按从左到右为 B、G、R 的顺序显示，从而使水平子像素分辨率是全部水平像素分辨率 (HBGR) 的三倍。
         * VALUE_TEXT_ANTIALIAS_LCD_HRGB
         * 文本抗锯齿提示值——要求针对 LCD 显示器优化文本显示，该 LCD 显示器子像素按从左到右为 R、G、B 的顺序显示，从而使水平子像素分辨率是全部水平像素分辨率 (HRGB) 的三倍。
         * VALUE_TEXT_ANTIALIAS_LCD_VBGR
         * 文本抗锯齿提示值——要求针对 LCD 显示器优化文本显示，子像素组织按从顶部到底部为 R、G、B 的顺序显示，从而使垂直子像素分辨率是全部垂直像素分辨率 (VBGR) 的三倍。
         * VALUE_TEXT_ANTIALIAS_LCD_VRGB
         * 文本抗锯齿提示值——要求针对 LCD 显示器优化文本显示，子像素组织按从顶部到底部为 R、G、B 的顺序显示，从而使垂直子像素分辨率是全部垂直像素分辨率 (VRGB) 的三倍。
         * VALUE_TEXT_ANTIALIAS_OFF
         * 文本抗锯齿提示值——不使用任何抗锯齿形式完成文本呈现。
         * VALUE_TEXT_ANTIALIAS_ON
         * 文本抗锯齿提示值——使用某种抗锯齿形式完成文本呈现。
         */

        /* KEY_TEXT_LCD_CONTRAST LCD 文本对比呈现提示键。 */

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
