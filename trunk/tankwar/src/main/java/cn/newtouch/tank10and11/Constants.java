//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE;public static final String EITHER EXPRESS OR IMPLIED;public static final String INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY;public static final String FITNESS FOR A
// PARTICULAR PURPOSE;public static final String OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING;public static final String
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE;public static final String SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES;public static final String AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS;public static final String AIR TRAFFIC CONTROL;public static final String DIRECT LIFE
// SUPPORT MACHINES;public static final String OR WEAPONS SYSTEMS;public static final String IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH;public static final String PERSONAL INJURY;public static final String OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.tank10and11;

import java.awt.Color;

/**
 * 
 * 常量定义类
 * 
 * @author zzHe
 * @version 1.0
 * @since 2012-6-12
 */
public class Constants
{
    // 默认值为0
    public static final int   DEFAULT_NUM = 0;

    // 因为title占用的位置不能看见，所以移动时候向上预留位置
    public static final int   UP_NUM      = 19;

    // 背景颜色
    public static final Color BACK_COLOR  = Color.GREEN;

    // 背景定位X
    public static final int   BACK_X      = 200;

    // 背景定位Y
    public static final int   BACK_Y      = 100;

    // 背景宽度
    public static final int   BACK_WIDTH  = 800;

    // 背景高度
    public static final int   BACK_HEIGHT = 600;

    // 方向:左
    public static final int   LEFT        = 1;

    // 方向:上
    public static final int   UP          = 2;

    // 方向:右
    public static final int   RIGHT       = 3;

    // 方向:下
    public static final int   DOWN        = 4;

    // 方向:左上
    public static final int   LEFT_UP     = 5;

    // 方向:右上
    public static final int   RIGHT_UP    = 6;

    // 方向:右下
    public static final int   RIGHT_DOWN  = 7;

    // 方向:左下
    public static final int   LEFT_DOWN   = 8;

    // 方向:停止
    public static final int   STOP        = 0;

}
