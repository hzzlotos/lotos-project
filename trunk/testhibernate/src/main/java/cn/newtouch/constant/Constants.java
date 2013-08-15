//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: LoToS
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.constant;

public class Constants
{
    /**
     * role
     */
    // 项目级别
    public static final int     LEVEL_SYSTEM         = 1;                  // 系统管理员

    public static final int     LEVEL_SUBJECT        = 2;                  // 科目管理员

    public static final int     LEVEL_SPECIAL        = 3;                  // 专家管理员

    private static final String LEVEL_STRING         = "管理员";

    // 项目级别
    public static final String  LEVEL_SYSTEM_STRING  = "系统" + LEVEL_STRING; // 系统管理员

    public static final String  LEVEL_SUBJECT_STRING = "科目" + LEVEL_STRING; // 科目管理员

    public static final String  LEVEL_SPECIAL_STRING = "专家" + LEVEL_STRING; // 专家管理员

    public static final Long    LEVEL_SYSTEM_ID      = 1L;                 // 系统管理员ID

    /**
     * Authority
     */
    // springsecurity需要
    public static final String  AUTHORITY_PREFIX     = "ROLE_";

    public static final String  AUTHORITY_1          = "科目库管理";

    public static final String  AUTHORITY_2          = "用户管理";

    public static final String  AUTHORITY_3          = "试题基础管理";

    public static final String  AUTHORITY_4          = "知识体系管理";

    public static final String  AUTHORITY_5          = "试题添加";

    public static final String  AUTHORITY_6          = "试题审核";

    public static final String  AUTHORITY_7          = "试题管理";

}
