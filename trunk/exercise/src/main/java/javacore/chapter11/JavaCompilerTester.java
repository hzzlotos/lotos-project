package javacore.chapter11;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class JavaCompilerTester
{
    public static void main(String[] args)

    {
        try
        {
            // 在jdk目录下的jre/lib包中添加jdk/lib/tools.jar
            JavaCompilerTester javaCompilerTester = new JavaCompilerTester();
            javaCompilerTester.compileJavaFile();
            // javaCompilerTester.compileMemoryString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 对一个java的文件进行编译。编译后在java文件的相同目录生成class文件
     * 
     * @throws Exception
     */
    private void compileJavaFile() throws Exception
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // 建立DiagnosticCollector对象
        DiagnosticCollector diagnostics = new DiagnosticCollector();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        // 建立用于保存被编译文件名的对象
        // 每个文件被保存在一个从JavaFileObject继承的类中
        Iterable compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays
                .asList("G:\\eclipse\\workspace\\exercise\\java\\src\\javacore\\Test4Compiler.java"));

        Iterable options = Arrays.asList("-d", "e://testcompile");

        // out：用于输出错误的流，默认是System.err
        // fileManager：标准的文件管理
        // diagnosticListener：编译器的默认行为
        // options：编译器的选项
        // classes：参与编译的class
        // compilationUnits：不能为null，为你想编译的Java文件
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, options, null,
                compilationUnits);

        // 编译
        boolean success = task.call();
        fileManager.close();

        if (success)
        {
            System.out.print("编译成功");
            // 编译成功后获得这个class的对象
        }
        else
        {
            // 一个编译过程可能有多个诊断信息。每一个诊断信息，被抽象为一个 Diagnostic
            List<Diagnostic<? extends JavaFileObject>> diagnosticTemps = diagnostics.getDiagnostics();

            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnosticTemps)
            {
                {
                    System.out.println(diagnostic.getCode());
                    System.out.println(diagnostic.getKind());
                    System.out.println(diagnostic.getPosition());
                    System.out.println(diagnostic.getStartPosition());
                    System.out.println(diagnostic.getEndPosition());
                    System.out.println(diagnostic.getSource());
                    System.out.println(diagnostic.getMessage(Locale.CHINESE));
                    System.out.println("------------------------------------");
                }
            }
        }
    }

    /**
     * 对内存中的一个代表java源码的字符串进行编译
     */
    private void compileMemoryString() throws Exception
    {

        String compiledDir = "e://testcompile";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<JavaFileObject>();

        /* 从内存中编译java源码字串 */
        /* 程序段开始 */

        // 定义一个StringWriter类，用于写Java程序
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        // 开始写Java程序
        out.println("package a.a.b;");
        out.println("public class HelloWorld{");
        out.println(" public static void main(String args[]) {");
        out.println(" System.out.println(\"Hello, World\");");
        out.println(" }");
        out.println("}");
        out.close();
        // 为这段代码取个名子：HelloWorld，以便以后使用reflection调用
        JavaFileObject file = new JavaSourceFromString("a.a.b.HelloWorld", writer.toString());
        Iterable options = Arrays.asList("-d", compiledDir); // 指定生成class的目录
        Iterable compilationUnits = Arrays.asList(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, collector, options, null, compilationUnits);
        boolean success = task.call();
        /* 从内存中编译java源码字串程序段结束 */
        // 一个编译过程可能有多个诊断信息。每一个诊断信息，被抽象为一个 Diagnostic
        List<Diagnostic<? extends JavaFileObject>> diagnostics = collector.getDiagnostics();
        if (success)
        {
            System.out.print("编译成功");
            // 这里对编译完成的class进行调用
            URL[] urls = { new File(compiledDir).toURI().toURL() };
            URLClassLoader urlcl = new URLClassLoader(urls);
            Class c = urlcl.loadClass("a.a.b.HelloWorld");
            c.getDeclaredMethod("main", new Class[] { String[].class }).invoke(null, new Object[] { null });
            // Class.forName("a.a.b.HelloWorld").getDeclaredMethod("main", new Class[]{ String[].class }).invoke(null,
            // new Object[]{ null });
        }
        else
        {
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics)
            {
                {
                    System.out.println(diagnostic.getMessage(Locale.CHINESE));
                    System.out.println("/n");
                }
            }
        }

    }

    class JavaSourceFromString extends SimpleJavaFileObject

    {
        final String code;

        JavaSourceFromString(String name, String code)
        {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors)
        {
            return this.code;
        }

    }

}
