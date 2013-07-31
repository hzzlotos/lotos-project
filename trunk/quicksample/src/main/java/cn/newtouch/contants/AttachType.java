package cn.newtouch.contants;

import java.util.List;

import cn.newtouch.vo.KeyValue;

import com.google.common.collect.Lists;

public class AttachType
{
    public static final int      TYPE_AREA        = 1;

    public static final int      TYPE_BRANCH      = 2;

    public static List<KeyValue> ATTACH_TYPE_LIST = Lists.newArrayList();

    static
    {
        ATTACH_TYPE_LIST.add(new KeyValue(String.valueOf(TYPE_AREA), "地区"));
        ATTACH_TYPE_LIST.add(new KeyValue(String.valueOf(TYPE_BRANCH), "分公司"));
    }
}