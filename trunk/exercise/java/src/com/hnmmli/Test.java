package com.hnmmli;

import cn.newtouch.TheTest;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        TheTest theTest = new TheTest();
        System.out.println(ExtTest.getStr()+theTest.getStr());
    }
}
//javap -verbose
/*-------------------------------------------------------*/
/**
Compiled from "Test.java"
public class javacore.Test extends java.lang.Object
  SourceFile: "Test.java"
  minor version: 0
  major version: 51
  Constant pool:
const #1 = Method       #13.#24;        //  java/lang/Object."<init>":()V
const #2 = class        #25;    //  cn/newtouch/TheTest
const #3 = Method       #2.#24; //  cn/newtouch/TheTest."<init>":()V
const #4 = Field        #26.#27;        //  java/lang/System.out:Ljava/io/PrintStream;
const #5 = class        #28;    //  java/lang/StringBuilder
const #6 = Method       #5.#24; //  java/lang/StringBuilder."<init>":()V
const #7 = Method       #29.#30;        //  com/hnmmli/ExtTest.getStr:()Ljava/lang/String;
const #8 = Method       #5.#31; //  java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
const #9 = Method       #2.#30; //  cn/newtouch/TheTest.getStr:()Ljava/lang/String;
const #10 = Method      #5.#32; //  java/lang/StringBuilder.toString:()Ljava/lang/String;
const #11 = Method      #33.#34;        //  java/io/PrintStream.println:(Ljava/lang/String;)V
const #12 = class       #35;    //  com/hnmmli/Test
const #13 = class       #36;    //  java/lang/Object
const #14 = Asciz       <init>;
const #15 = Asciz       ()V;
const #16 = Asciz       Code;
const #17 = Asciz       LineNumberTable;
const #18 = Asciz       main;
const #19 = Asciz       ([Ljava/lang/String;)V;
const #20 = Asciz       Exceptions;
const #21 = class       #37;    //  java/lang/Exception
const #22 = Asciz       SourceFile;
const #23 = Asciz       Test.java;
const #24 = NameAndType #14:#15;//  "<init>":()V
const #25 = Asciz       cn/newtouch/TheTest;
const #26 = class       #38;    //  java/lang/System
const #27 = NameAndType #39:#40;//  out:Ljava/io/PrintStream;
const #28 = Asciz       java/lang/StringBuilder;
const #29 = class       #41;    //  com/hnmmli/ExtTest
const #30 = NameAndType #42:#43;//  getStr:()Ljava/lang/String;
const #31 = NameAndType #44:#45;//  append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
const #32 = NameAndType #46:#43;//  toString:()Ljava/lang/String;
const #33 = class       #47;    //  java/io/PrintStream
const #34 = NameAndType #48:#49;//  println:(Ljava/lang/String;)V
const #35 = Asciz       com/hnmmli/Test;
const #36 = Asciz       java/lang/Object;
const #37 = Asciz       java/lang/Exception;
const #38 = Asciz       java/lang/System;
const #39 = Asciz       out;
const #40 = Asciz       Ljava/io/PrintStream;;
const #41 = Asciz       com/hnmmli/ExtTest;
const #42 = Asciz       getStr;
const #43 = Asciz       ()Ljava/lang/String;;
const #44 = Asciz       append;
const #45 = Asciz       (Ljava/lang/String;)Ljava/lang/StringBuilder;;
const #46 = Asciz       toString;
const #47 = Asciz       java/io/PrintStream;
const #48 = Asciz       println;
const #49 = Asciz       (Ljava/lang/String;)V;

{
public javacore.Test();
  Code:
   Stack=1, Locals=1, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return
  LineNumberTable:
   line 5: 0


public static void main(java.lang.String[])   throws java.lang.Exception;
   Code:
    Stack=3, Locals=2, Args_size=1
    0:   new     #2; //class cn/newtouch/TheTest
    3:   dup
    4:   invokespecial   #3; //Method cn/newtouch/TheTest."<init>":()V
    7:   astore_1
    8:   getstatic       #4; //Field java/lang/System.out:Ljava/io/PrintStream;
    11:  new     #5; //class java/lang/StringBuilder
    14:  dup
    15:  invokespecial   #6; //Method java/lang/StringBuilder."<init>":()V
    18:  invokestatic    #7; //Method com/hnmmli/ExtTest.getStr:()Ljava/lang/String;
    21:  invokevirtual   #8; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    24:  aload_1
    25:  invokevirtual   #9; //Method cn/newtouch/TheTest.getStr:()Ljava/lang/String;
    28:  invokevirtual   #8; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    31:  invokevirtual   #10; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
    34:  invokevirtual   #11; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
    37:  return
   LineNumberTable:
    line 9: 0
    line 10: 8
    line 11: 37

   Exceptions:
    throws java.lang.Exception
}
**/