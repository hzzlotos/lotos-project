package org.springside.examples.quickstart.contants;

import java.util.List;

import org.springside.examples.quickstart.vo.KeyValue;

import com.google.common.collect.Lists;

public class RoleType
{
    public final static int      ROLE_ADMIN          = 1;

    public final static int      ROLE_AREA_MANAGER   = 2;

    public final static int      ROLE_BRANCH_MANAGER = 3;

    public static List<KeyValue> ROLE_TYPE_LIST      = Lists.newArrayList();

    static
    {
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_ADMIN), "超级管理员"));
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_AREA_MANAGER),
                "地区管理员"));
        ROLE_TYPE_LIST.add(new KeyValue(String.valueOf(ROLE_BRANCH_MANAGER),
                "分公司管理员"));
    }

    public static String getTypeName(int type)
    {
        for (KeyValue keyValue : ROLE_TYPE_LIST)
        {
            if (Integer.valueOf(keyValue.getKey()) == type)
            {
                return keyValue.getValue();
            }
        }
        return null;
    }
}
