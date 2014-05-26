package cn.newtouch.base.base.stack;

import java.util.Stack;

public class StackTest
{

    /**
     * Description of this Method
     * 
     * @since 2013-1-25
     * @author zzHe
     * @param args
     */
    public static void main(String[] args)
    {
        Stack<Integer> aaa = new Stack<Integer>();

        aaa.push(111);
        aaa.push(222);
        aaa.push(333);
        aaa.push(444);
        System.out.println(aaa.size());
        System.out.println("=============");
        System.out.println(aaa.pop());
        System.out.println(aaa.pop());
        System.out.println(aaa.pop());
        System.out.println(aaa.pop());
        String str = "";
        System.out.println(str.indexOf("1"));
    }

}
