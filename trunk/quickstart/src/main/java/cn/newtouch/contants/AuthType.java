package cn.newtouch.contants;

import java.util.List;

import org.springside.examples.quickstart.vo.KeyValue;

import com.google.common.collect.Lists;

public class AuthType
{
    public final static int      AUTH_MANAGE    = 1;

    public final static int      AUTH_LOOKOVER  = 2;

    public static List<KeyValue> AUTH_TYPE_LIST = Lists.newArrayList();

    static
    {
        AUTH_TYPE_LIST.add(new KeyValue(String.valueOf(AUTH_MANAGE), "管理"));
        AUTH_TYPE_LIST.add(new KeyValue(String.valueOf(AUTH_LOOKOVER), "查看"));
    }
}
