package cn.newtouch.image.implement;

import java.io.File;

public final class FileConstants
{
    /**
     * 图片默认透明度
     */
    public static float        ALPHA               = 0.8F;

    /**
     * 英文字符点号
     */
    public static final String DOT                 = ".";

    /**
     * 图片格式：JPG
     */
    public static final String PICTRUE_FORMATE_JPG = "jpg";

    /**
     * 正则表达式所需英文字符点号
     */
    public static final String REGULAR_DOT         = "\\.";

    /**
     * 正斜杠
     */
    public static final String ASTERISK            = "*";

    /**
     * 正斜杠
     */
    public static final String SEPARATOR           = "/";

    /**
     * 下划线
     */
    public static final String UNDER_LINE          = "_";

    /**
     * 图片路径
     */
    public static final String WATERIMG            = "E:" + File.separator + "test" + File.separator + "imagetest"
                                                           + File.separator + "origin" + File.separator
                                                           + "steelgt_logo.png";

    /**
     * 图片水印左上角默认X坐标
     */
    public static final int    X                   = 30;

    /**
     * 图片水印左上角默认Y坐标
     */
    public static final int    Y                   = 30;

}