package com.hnmmli;

public class ExtTest
{
    public static String getStr(){
        return "you get the string!";
    }
}

/**
Compiled from "ExtTest.java"
public class javacore.ExtTest extends java.lang.Object
  SourceFile: "ExtTest.java"
  minor version: 0
  major version: 51
  Constant pool:
const #1 = Method       #4.#13; //  java/lang/Object."<init>":()V
const #2 = String       #14;    //  you get the string!
const #3 = class        #15;    //  com/hnmmli/ExtTest
const #4 = class        #16;    //  java/lang/Object
const #5 = Asciz        <init>;
const #6 = Asciz        ()V;
const #7 = Asciz        Code;
const #8 = Asciz        LineNumberTable;
const #9 = Asciz        getStr;
const #10 = Asciz       ()Ljava/lang/String;;
const #11 = Asciz       SourceFile;
const #12 = Asciz       ExtTest.java;
const #13 = NameAndType #5:#6;//  "<init>":()V
const #14 = Asciz       you get the string!;
const #15 = Asciz       com/hnmmli/ExtTest;
const #16 = Asciz       java/lang/Object;

{
public javacore.ExtTest();
  Code:
   Stack=1, Locals=1, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return
  LineNumberTable:
   line 3: 0


public static java.lang.String getStr();
  Code:
   Stack=1, Locals=0, Args_size=0
   0:   ldc     #2; //String you get the string!
   2:   areturn
  LineNumberTable:
   line 6: 0


}
**/