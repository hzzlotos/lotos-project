package com.hnmmli.chapter11.bcel_online;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.PUSH;
import org.apache.bcel.generic.Type;

public class BCELTiming
{

    private static void addWrapper(ClassGen cgen, Method method)
    {
        // set up the construction tools
        InstructionFactory ifact = new InstructionFactory(cgen);
        InstructionList ilist = new InstructionList();
        ConstantPoolGen pgen = cgen.getConstantPool();
        String cname = cgen.getClassName();
        MethodGen wrapgen = new MethodGen(method, cname, pgen);
        wrapgen.setInstructionList(ilist);

        // rename a copy of the original method
        MethodGen methgen = new MethodGen(method, cname, pgen);
        cgen.removeMethod(method);
        String iname = methgen.getName() + "$impl";
        methgen.setName(iname);
        cgen.addMethod(methgen.getMethod());
        // 以上是一下初始化的工作

        // compute the size of the calling parameters
        // operand stack操作数堆栈
        Type[] types = methgen.getArgumentTypes(); // 取出参数类型数组

        // solt代表本地变量的堆栈偏移量,里头储存了调用methen代表的函数的参数
        int slot = methgen.isStatic() ? 0 : 1; // 这种方式与Java如何处理方法调用有关。对于非静态的方法，每次调用的第一个（隐藏的）参数是目标对象的this引用（就是位置0储存的内容）。
        for (Type type : types)
        {
            slot += type.getSize();// 累计个个参数类型的长度，
        }
        // 现在solt指向最后一个参数的下一个位置

        // save time prior to invocation
        // 调用静态的long java.lang.System.currentTimeMillis()方法,调用结束后函数的返回的long类型的值会压入operand stack操作数堆栈
        ilist.append(ifact.createInvoke("java.lang.System", "currentTimeMillis", Type.LONG, Type.NO_ARGS,
                Constants.INVOKESTATIC));
        ilist.append(InstructionFactory.createStore(Type.LONG, slot));// 将operand stack的top保存到本地变量堆栈的slot位置,operand
                                                                      // stack弹出long值

        // call the wrapped method
        int offset = 0; // 偏移量
        short invoke = Constants.INVOKESTATIC; // 预先设置为调用静态函数
        if (!methgen.isStatic())
        { // 如果不是调用静态函数,将调用的第一个（隐藏的）参数(目标对象的this引用)压入operand stack
            ilist.append(InstructionFactory.createLoad(Type.OBJECT, 0));
            offset = 1;// 偏移量加1
            invoke = Constants.INVOKEVIRTUAL;// 设置为调用非静态函数
        }
        for (Type type : types)
        { // 遍历所有参数
            ilist.append(InstructionFactory.createLoad(type, offset)); // 按参数类型把参数一个个从本地变量堆栈取出，压入operand stack
            offset += type.getSize();
        }
        Type result = methgen.getReturnType();// 取得要调用函数的返回值类型
        ilist.append(ifact.createInvoke(cname, iname, result, types, invoke));// 调用方法名为iname的函数

        // store result for return later
        if (result != Type.VOID)
        {
            ilist.append(InstructionFactory.createStore(result, slot + 2)); // 将名为iname的函数返回值复制到本地变量堆栈的slot+2的位置上
        }

        // print time required for method call
        // 获取静态对象java.lang.System.out的引用,返回值压入operand stack
        ilist.append(ifact.createFieldAccess("java.lang.System", "out", new ObjectType("java.io.PrintStream"),
                Constants.GETSTATIC));
        ilist.append(InstructionConstants.DUP);// 取operand stack的top,压入operand
                                               // stack。完成后load_stack的头两个元素是静态对象java.lang.System.out的引用
        ilist.append(InstructionConstants.DUP);// 取operand stack的top,压入operand
                                               // stack。现在有3个java.lang.System.out的引用。供下面3次调用out.print()函数使用
        String text = "Call to method " + methgen.getName() + " took ";
        ilist.append(new PUSH(pgen, text));// 将text放入pgen（代表常量池）,并把其在pgen的引用压入operand stack(供out.print(Sting)调用的参数)
        ilist.append(ifact.createInvoke("java.io.PrintStream", "print", Type.VOID, new Type[] { Type.STRING },
                Constants.INVOKEVIRTUAL));// 调用结束，operand stack弹出一个String的引用和一个out的引用(还剩2个out),函数没有返回值

        ilist.append(ifact.createInvoke("java.lang.System", "currentTimeMillis", Type.LONG, Type.NO_ARGS,
                Constants.INVOKESTATIC));// 调用java.lang.System.currentTimeMillis()方法,调用结束后函数的返回的long类型的值会压入堆栈operand
                                         // stack
        ilist.append(InstructionFactory.createLoad(Type.LONG, slot));// 从本地变量堆栈的slot位置载入先前储存的long值，压入operand stack
        ilist.append(InstructionConstants.LSUB);// 调用long的减法指令,弹出2个long值，并把结果压入operand stack,现在operand
                                                // stack的top第一个是long，第二个是out的引用
        ilist.append(ifact.createInvoke("java.io.PrintStream", "print", Type.VOID, new Type[] { Type.LONG },
                Constants.INVOKEVIRTUAL));// 调用out.print(long)方法
        ilist.append(new PUSH(pgen, " ms."));// 将String对象" ms."放入pgen,并把其在pgen的引用压入operand stack(供out.print(Sting)调用的参数)
        ilist.append(ifact.createInvoke("java.io.PrintStream", "println", Type.VOID, new Type[] { Type.STRING },
                Constants.INVOKEVIRTUAL));

        // return result from wrapped method call
        if (result != Type.VOID)
        {
            ilist.append(InstructionFactory.createLoad(result, slot + 2));// 处理返回值,如果不为空，从本地对象堆栈的slot+2位置读取指定类型的返回值压入operand
                                                                          // stack
        }
        ilist.append(InstructionFactory.createReturn(result)); // 调用处理返回值的指令，result为返回值的类型

        // 下面是一下扫尾工作
        // finalize the constructed method
        wrapgen.stripAttributes(true);
        wrapgen.setMaxStack();
        wrapgen.setMaxLocals();
        cgen.addMethod(wrapgen.getMethod());
        ilist.dispose();
    }

    public static void main(String[] argv1)
    {
        String classUrl = "G:\\eclipse\\workspace\\exercise\\target\\classes\\com\\hnmmli\\chapter11\\bcel_online\\StringBuilder.class";
        String methodName = "buildString";
        String targetClassfile = "G:\\classpath\\com\\hnmmli\\chapter11\\bcel_online\\StringBuilder.class";
        try
        {

            JavaClass jclas = new ClassParser(classUrl).parse();
            ClassGen cgen = new ClassGen(jclas);
            Method[] methods = jclas.getMethods();
            int index;
            for (index = 0; index < methods.length; index++)
            {
                if (methods[index].getName().equals(methodName))
                {
                    break;
                }
            }
            if (index < methods.length)
            {
                addWrapper(cgen, methods[index]);
                FileOutputStream fos = new FileOutputStream(targetClassfile);
                cgen.getJavaClass().dump(fos);
                fos.close();
            }
            else
            {
                System.err.println("Method " + methodName + " not found in " + classUrl);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace(System.err);
        }
        System.out.println("OK");
    }
}