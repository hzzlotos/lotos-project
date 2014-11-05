import java.io.File;
import java.io.IOException;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.AnnotationEntry;
import org.apache.bcel.classfile.ElementValuePair;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.PUSH;

/**
 * Adds "entering" logs to all methods of a class that have the LogEntry annotation.
 * 
 * @version 1.10 2007-10-27
 * @author Cay Horstmann
 */
public class EntryLogger
{
    private ClassGen        cg;

    private ConstantPoolGen cpg;

    /**
     * Constructs an EntryLogger that inserts logging into annotated methods of a given class
     * 
     * @param cg the class
     */
    public EntryLogger(ClassGen cg)
    {
        this.cg = cg;
        this.cpg = cg.getConstantPool();
    }

    // 首先javac Item.java
    // 接着javac -classpath ./bcel-5.3-SNAPSHOT.jar EbtryLogger.java
    // java -Xbootcalsspath/a:./bcel-5.3-SNAPSHOT.jar EntryLogger Item
    /**
     * Adds entry logging code to the given class
     * 
     * @param args the name of the class file to patch
     */
    public static void main(String[] args)
    {
        try
        {
            // if (args.length == 0)
            // {
            // System.out.println("USAGE: java EntryLogger classname");
            // }
            // else
            // {
            JavaClass jc = Repository.lookupClass("Item");
            ClassGen cg = new ClassGen(jc);
            EntryLogger el = new EntryLogger(cg);
            el.convert();
            System.out.println("the path========" + Repository.lookupClassFile(cg.getClassName()).getPath());
            File f = new File(Repository.lookupClassFile(cg.getClassName()).getPath());
            cg.getJavaClass().dump(f.getPath());
            // }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * converts the class by inserting the logging calls.
     */
    public void convert() throws IOException
    {
        for (Method m : this.cg.getMethods())
        {
            System.out.println("===" + m.getName());
            AnnotationEntry[] annotations = m.getAnnotationEntries();
            for (AnnotationEntry a : annotations)
            {
                System.out.println("---" + a.getAnnotationType());
                if (a.getAnnotationType().equals("LLogEntry;"))
                {
                    for (ElementValuePair p : a.getElementValuePairs())
                    {
                        if (p.getNameString().equals("logger"))
                        {
                            String loggerName = p.getValue().stringifyValue();
                            this.cg.replaceMethod(m, this.insertLogEntry(m, loggerName));
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds an "entering" call to the beginning of a method.
     * 
     * @param m the method
     * @param loggerName the name of the logger to call
     */
    private Method insertLogEntry(Method m, String loggerName)
    {
        MethodGen mg = new MethodGen(m, this.cg.getClassName(), this.cpg);
        String className = this.cg.getClassName();
        String methodName = mg.getMethod().getName();
        System.out.printf("Adding logging instructions to %s.%s%n", className, methodName);

        int getLoggerIndex = this.cpg.addMethodref("java.util.logging.Logger", "getLogger",
                "(Ljava/lang/String;)Ljava/util/logging/Logger;");
        int enteringIndex = this.cpg.addMethodref("java.util.logging.Logger", "entering",
                "(Ljava/lang/String;Ljava/lang/String;)V");

        InstructionList il = mg.getInstructionList();
        InstructionList patch = new InstructionList();
        patch.append(new PUSH(this.cpg, loggerName));
        patch.append(new INVOKESTATIC(getLoggerIndex));
        patch.append(new PUSH(this.cpg, className));
        patch.append(new PUSH(this.cpg, methodName));
        patch.append(new INVOKEVIRTUAL(enteringIndex));
        InstructionHandle[] ihs = il.getInstructionHandles();
        il.insert(ihs[0], patch);

        mg.setMaxStack();
        return mg.getMethod();
    }
}