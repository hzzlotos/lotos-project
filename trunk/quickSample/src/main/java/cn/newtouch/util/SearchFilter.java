package cn.newtouch.util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SearchFilter
{

    public static String IS_NULL = "null";

    public enum Operator {
        EQ, LIKE, GT, LT, GTE, LTE, IN, EQOR
    }

    /** 属性数据类型. */
    public enum PropertyType {
        S(String.class), I(Integer.class), L(Long.class), N(Double.class), D(
                Date.class), B(Boolean.class);

        private Class<?> clazz;

        private PropertyType(Class<?> clazz)
        {
            this.clazz = clazz;
        }

        public Class<?> getValue()
        {
            return clazz;
        }
    }

    public String       fieldName;

    public Object       value;

    public Operator     operator;

    public List<Object> listValue;

    public SearchFilter(String fieldName, Operator operator, Object value)
    {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    public SearchFilter(List<Object> listValue, String fieldName,
            Operator operator)
    {
        this.fieldName = fieldName;
        this.listValue = listValue;
        this.operator = operator;
    }

    /**
     * searchParams中key的格式为OPERATOR_FIELDNAME
     */
    public static Map<String, SearchFilter> parse(
            Map<String, Object> searchParams)
    {
        Map<String, SearchFilter> filters = Maps.newHashMap();

        for (Entry<String, Object> entry : searchParams.entrySet())
        {
            // 过滤掉空值
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || StringUtils.isBlank(String.valueOf(value)))
            {
                continue;
            }
            String[] names = StringUtils.split(key, "_");
            if (names.length != 2)
            {
                throw new IllegalArgumentException(key
                        + " is not a valid search filter name");
            }
            String firstPart = StringUtils.substringBefore(key, "_");
            String matchTypeCode = StringUtils.substring(firstPart, 0,
                    firstPart.length() - 1);
            String propertyTypeCode = StringUtils.substring(firstPart,
                    firstPart.length() - 1, firstPart.length());
            Operator operator = null;
            Class<?> propertyClass = null;
            // 拆分operator与filedAttribute
            try
            {
                operator = Operator.valueOf(matchTypeCode);
            }
            catch (RuntimeException e)
            {
                throw new IllegalArgumentException("filter名称" + names[1]
                        + "没有按规则编写,无法得到属性比较类型.", e);
            }
            try
            {
                propertyClass = PropertyType.valueOf(propertyTypeCode)
                        .getValue();
            }
            catch (RuntimeException e)
            {
                throw new IllegalArgumentException("filter名称" + names[1]
                        + "没有按规则编写,无法得到属性值类型.", e);
            }
            // 创建searchFilter
            SearchFilter filter = null;
            String name = names[1].replace("[]", "");
            if (operator == Operator.IN)
            {
                List<Object> list = Lists.newArrayList();
                if (value instanceof List)
                {
                    for (Object obj : (List<Object>) value)
                    {
                        list.add(ConvertUtils.convertStringToObject(obj
                                .toString(), propertyClass));
                    }
                }
                else
                {
                    try
                    {
                        for (String obj : Arrays.asList((String[]) value))
                        {
                            list.add(ConvertUtils.convertStringToObject(obj,
                                    propertyClass));
                        }
                    }
                    catch (Exception e)
                    {
                        list = Lists.newArrayList();
                        list.add(ConvertUtils.convertStringToObject(value
                                .toString(), propertyClass));
                    }
                }
                filter = new SearchFilter(list, name, operator);
            }
            else
            {
                if (null != propertyClass)
                {
                    if (!IS_NULL.equals(value))
                    {
                        filter = new SearchFilter(name, operator, ConvertUtils
                                .convertStringToObject(value.toString(),
                                        propertyClass));
                    }
                    else
                    {
                        filter = new SearchFilter(name, operator, value);
                    }
                }
            }
            filters.put(key, filter);
        }
        return filters;
    }
}