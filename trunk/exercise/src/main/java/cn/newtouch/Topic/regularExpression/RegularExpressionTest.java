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
package cn.newtouch.Topic.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest
{
    // 常用类
    // java.util.regex.Pattern 规则
    // java.util.regex.Matcher 结果
    /**
     * Description of this Method
     * 
     * @since 2012-1-17
     * @author zzHe
     * @param args
     */
    public static void main(String[] args)
    {
        // no1();
        // no2();
        // no3();
        // no4();
        // no5();
        no67();

        // email.com
        // p("asdsa_231@hotmail.com", "aa@163.com"
        // .matches("[\\w[.-]]+@\\w+\\.\\w+"));

        // no89();
        // no10();
        // no11();
    }

    private static void no1()
    {
        // .代表一位字符
        System.out.println("abc===========" + "abc".matches("..."));
        System.out.println("123===========" + "123".matches("..."));
        System.out.println("abcdefg===========" + "abcdefg".matches("..."));
        System.out.println("================================");
    }

    private static void no2()
    {
        // \d代表数字
        String str = "a342b34234b3121";
        System.out.println(str.replaceAll("\\d", "_"));
        System.out.println("================================");
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("fgh");
        System.out.println(m.matches());
        m = p.matcher("fghasd");
        System.out.println(m.matches());
    }

    private static void no3()
    {
        // 初步认识. * + ?
        // . 表示一位字符
        // * 表示0次或多次
        // + 表示1次或多次
        // ? 表示没有或者1次
        // {n} 恰好 n 次
        // {n,} 至少 n 次
        // {n,m} 至少 n 次，但是不超过 m 次
        p("a||.", "a".matches("."));
        p("aa||aa", "aa".matches("aa"));
        p("aaaa||a*", "aaaa".matches("a*"));
        p("aaaa||a+", "aaaa".matches("a+"));
        p("||a*", "".matches("a*"));
        p("aaaa||a?", "aaaa".matches("a?"));
        p("||a?", "".matches("a?"));
        p("a||a?", "a".matches("a?"));
        p("214523145234532||\\d{3,100}", "214523145234532".matches("\\d{3,100}"));
        p("192.168.0.aaa||\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",
                "192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        p("192||[0-2][0-9][0-9]", "192".matches("[0-2][0-9][0-9]"));
    }

    private static void no4()
    {
        // 范围
        p("a".matches("[abc]"));
        p("a".matches("[^abc]"));
        p("A".matches("[a-zA-Z]"));
        p("A".matches("[a-z]|[A-Z]"));
        p("A".matches("[a-z[A-Z]]"));
        p("R".matches("[A-Z&&[RFG]]"));
    }

    private static void no5()
    {
        // 认识\s \w \d \
        // \d 数字：[0-9]
        // \D 非数字： [^0-9]
        // \s 空白字符：[ \t\n\x0B\f\r]
        // \S 非空白字符：[^\s]
        // \w 单词字符：[a-zA-Z_0-9]包含下划线
        // \W 非单词字符：[^\w]
        p(" \n\r\t".matches("\\s{4}"));
        p(" ".matches("\\S"));
        p("a_8".matches("\\w{3}"));
        p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        p("\\".matches("\\\\"));

    }

    private static void no67()
    {
        // \\p{}
        p("a".matches("\\p{Lower}"));
        // 边界匹配器
        // ^ 行的开头
        // $ 行的结尾
        // \b 单词边界
        // \B 非单词边界
        // \A 输入的开头
        // \G 上一个匹配的结尾
        // \Z 输入的结尾，仅用于最后的结束符（如果有的话）
        // \z 输入的结尾
        // boundary
        p("hello sir".matches("^h.*"));
        p("hello sir".matches(".*ir$"));
        p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
        p("=================================");
        // whilte lines
        p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
        p("=================================");
        p("aaa 8888c".matches(".*\\d{4}."));
        p("aaa 8888c".matches(".*\\b\\d{4}."));
        p("aaa8888c".matches(".*\\d{4}."));
        p("aaa8888c".matches(".*\\b\\d{4}."));

    }

    private static void no89()
    {
        // matches find lookingAt
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-34345-234-00";
        Matcher m = p.matcher(s);
        p(m.matches());
        m.reset();
        // 因为之前已经匹配过了 所以m引擎是停留在"123-"这个位置了
        // 需要reset下才会从头重新查找
        p(m.find());
        // start为起始位置 end为结束位置后一位
        p(m.start() + "-" + m.end());
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());
        p(m.start() + "-" + m.end());
        boolean flag = m.find();
        p(flag);
        // 必须要check
        if (flag)
        {
            p(m.start() + "-" + m.end());
        }
        // lookingAt()每次都从头上开始查找
        p("====================================");
        p(m.lookingAt());
        p(m.lookingAt());
        p(m.lookingAt());
        p(m.lookingAt());
    }

    public static void no10()
    {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        String str = "java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf";
        Matcher m = p.matcher(str);
        while (m.find())
        {
            p(m.group());
        }
        p(m.replaceAll("java"));

        // 查找单数修改为大写JAVA 双数修改为小写java
        Matcher m2 = p.matcher(str);
        StringBuffer buf = new StringBuffer();
        int i = 0;
        while (m2.find())
        {
            i++;
            if (i % 2 == 0)
            {
                m2.appendReplacement(buf, "java");
            }
            else
            {
                m2.appendReplacement(buf, "JAVA");
            }
        }
        m2.appendTail(buf);
        p(buf);
    }

    public static void no11()
    {
        // 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，
        // 存在四个这样的组：
        // 1 ((A)(B(C))) ---->数字标记为0
        // 2 (A) ---->数字标记为1
        // 3 (B(C)) ---->数字标记为2
        // 4 (C) ---->数字标记为3
        // 组零始终代表整个表达式。

        // group
        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
        while (m.find())
        {
            // group(0)==group()
            p(m.group(0));
            p(m.group(1));
            p(m.group(2));
            // p(m.group(3));
            p("=========================================");
        }
    }

    public static void p(Object o)
    {
        System.out.println(o);
    }

    public static void p(String o, Object o1)
    {
        System.out.println(o + "============" + o1);
    }
}