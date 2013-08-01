package cn.newtouch.contants;

import java.util.List;

import cn.newtouch.vo.KeyValue;

import com.google.common.collect.Lists;

public class RoleType
{
    public final static int      ROLE_ADMIN          = 1;

    public final static int      ROLE_AREA_MANAGER   = 2;

    public final static int      ROLE_BRANCH_MANAGER = 3;

    public static List<KeyValue> ROLE_TYPE_LIST      = Lists.newArrayList();

    public static List<KeyValue> ROLE_BASE_TYPE_LIST = Lists.newArrayList();

    static
    {
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_ADMIN), "超级管理员"));
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_AREA_MANAGER),
                "地区管理员"));
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_BRANCH_MANAGER),
                "分公司管理员"));

        ROLE_BASE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_ADMIN),
                "admin"));
        ROLE_BASE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_AREA_MANAGER),
                "area"));
        ROLE_BASE_TYPE_LIST.add(new KeyValue(String
                .valueOf(ROLE_BRANCH_MANAGER), "branch"));
    }

    public static String getTypeName(int type)
    {
        for (KeyValue keyValue : ROLE_TYPE_LIST)
        {
            if (Integer.valueOf(keyValue.getKey()) == type)
            {
                return keyValue.getValue().toString();
            }
        }
        return null;
    }

    public static String getBaseTypeName(int type)
    {
        for (KeyValue keyValue : ROLE_BASE_TYPE_LIST)
        {
            if (Integer.valueOf(keyValue.getKey()) == type)
            {
                return keyValue.getValue().toString();
            }
        }
        return null;
    }
}
