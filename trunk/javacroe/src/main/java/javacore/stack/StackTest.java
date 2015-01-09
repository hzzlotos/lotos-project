package javacore.stack;

import java.util.Stack;

public class StackTest
{

    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        stack.push("111");
        stack.push("222");
        stack.push("333");

        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

}
