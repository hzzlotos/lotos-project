package cn.newtouch;

public class TheTest
{
    private String     str = "1";

    private int        a   = 1;

    private static int z   = 1;

    public String getStr()
    {
        str = new String("zzz");
        str = "you get the string!";
        return str;
    }

    public int getInt()
    {
        int b = 3;
        a = b;
        return a;
    }
}
/**
Compiled from "TheTest.java"
public class cn.newtouch.TheTest extends java.lang.Object
  SourceFile: "TheTest.java"
  minor version: 0
  major version: 50
  Constant pool:
const #1 = Method       #11.#28;        //  java/lang/Object."<init>":()V
const #2 = String       #29;    //  1
const #3 = Field        #10.#30;        //  cn/newtouch/TheTest.str:Ljava/lang/String;
const #4 = Field        #10.#31;        //  cn/newtouch/TheTest.a:I
const #5 = class        #32;    //  java/lang/String
const #6 = String       #33;    //  zzz
const #7 = Method       #5.#34; //  java/lang/String."<init>":(Ljava/lang/String;)V
const #8 = String       #35;    //  you get the string!
const #9 = Field        #10.#36;        //  cn/newtouch/TheTest.z:I
const #10 = class       #37;    //  cn/newtouch/TheTest
const #11 = class       #38;    //  java/lang/Object
const #12 = Asciz       str;
const #13 = Asciz       Ljava/lang/String;;
const #14 = Asciz       a;
const #15 = Asciz       I;
const #16 = Asciz       z;
const #17 = Asciz       <init>;
const #18 = Asciz       ()V;
const #19 = Asciz       Code;
const #20 = Asciz       LineNumberTable;
const #21 = Asciz       getStr;
const #22 = Asciz       ()Ljava/lang/String;;
const #23 = Asciz       getInt;
const #24 = Asciz       ()I;
const #25 = Asciz       <clinit>;
const #26 = Asciz       SourceFile;
const #27 = Asciz       TheTest.java;
const #28 = NameAndType #17:#18;//  "<init>":()V
const #29 = Asciz       1;
const #30 = NameAndType #12:#13;//  str:Ljava/lang/String;
const #31 = NameAndType #14:#15;//  a:I
const #32 = Asciz       java/lang/String;
const #33 = Asciz       zzz;
const #34 = NameAndType #17:#39;//  "<init>":(Ljava/lang/String;)V
const #35 = Asciz       you get the string!;
const #36 = NameAndType #16:#15;//  z:I
const #37 = Asciz       cn/newtouch/TheTest;
const #38 = Asciz       java/lang/Object;
const #39 = Asciz       (Ljava/lang/String;)V;

{
public cn.newtouch.TheTest();
  Code:
   Stack=2, Locals=1, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   aload_0
   5:   ldc     #2; //String 1
   7:   putfield        #3; //Field str:Ljava/lang/String;
   10:  aload_0
   11:  iconst_1
   12:  putfield        #4; //Field a:I
   15:  return
  LineNumberTable:
   line 3: 0
   line 5: 4
   line 7: 10


public java.lang.String getStr();
  Code:
   Stack=4, Locals=1, Args_size=1
   0:   aload_0
   1:   new     #5; //class java/lang/String
   4:   dup
   5:   ldc     #6; //String zzz
   7:   invokespecial   #7; //Method java/lang/String."<init>":(Ljava/lang/String;)V
   10:  putfield        #3; //Field str:Ljava/lang/String;
   13:  aload_0
   14:  ldc     #8; //String you get the string!
   16:  putfield        #3; //Field str:Ljava/lang/String;
   19:  aload_0
   20:  getfield        #3; //Field str:Ljava/lang/String;
   23:  areturn
  LineNumberTable:
   line 13: 0
   line 14: 13
   line 15: 19


public int getInt();
  Code:
   Stack=2, Locals=2, Args_size=1
   0:   iconst_3
   1:   istore_1
   2:   aload_0
   3:   iload_1
   4:   putfield        #4; //Field a:I
   7:   aload_0
   8:   getfield        #4; //Field a:I
   11:  ireturn
  LineNumberTable:
   line 20: 0
   line 21: 2
   line 22: 7


static {};
  Code:
   Stack=1, Locals=0, Args_size=0
   0:   iconst_1
   1:   putstatic       #9; //Field z:I
   4:   return
  LineNumberTable:
   line 9: 0


}
**/