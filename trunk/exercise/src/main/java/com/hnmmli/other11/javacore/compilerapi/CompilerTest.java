package com.hnmmli.other11.javacore.compilerapi;

import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JFrame;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.ToolProvider;

/**
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public class CompilerTest
{
    public static void main(final String[] args) throws IOException
    {
        // 使用时需要给所用vm添加tool.jar
        // eclips中在window->preferences->java->Installed JREs->选择当前jre->edit->Add External JARs->添加jdk/lib下的tool,jar
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        final List<ByteArrayJavaClass> classFileObjects = new ArrayList<ByteArrayJavaClass>();

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        JavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        fileManager = new ForwardingJavaFileManager<JavaFileManager>(fileManager) {
            @Override
            public JavaFileObject getJavaFileForOutput(Location location, final String className, Kind kind,
                    FileObject sibling) throws IOException
            {
                if (className.startsWith("x."))
                {
                    ByteArrayJavaClass fileObject = new ByteArrayJavaClass(className);
                    classFileObjects.add(fileObject);
                    return fileObject;
                }
                else
                {
                    return super.getJavaFileForOutput(location, className, kind, sibling);
                }
            }
        };

        JavaFileObject source = buildSource("com.hnmmli.other11.javacore.api.test.ButtonFrame");
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null,
                Arrays.asList(source));
        Boolean result = task.call();

        for (Diagnostic<? extends JavaFileObject> d : diagnostics.getDiagnostics())
        {
            System.out.println(d.getKind() + ": " + d.getMessage(null));
        }
        fileManager.close();
        if (!result)
        {
            System.out.println("Compilation failed.");
            System.exit(1);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Map<String, byte[]> byteCodeMap = new HashMap<String, byte[]>();
                    for (ByteArrayJavaClass cl : classFileObjects)
                    {
                        byteCodeMap.put(cl.getName().substring(1), cl.getBytes());
                    }
                    ClassLoader loader = new MapClassLoader(byteCodeMap);
                    Class<?> cl = loader.loadClass("x.Frame");
                    JFrame frame = (JFrame) cl.newInstance();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("CompilerTest");
                    frame.setVisible(true);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    /*
     * Builds the source for the subclass that implements the addEventHandlers method.
     * 
     * @return a file object containing the source in a string builder
     */
    static JavaFileObject buildSource(String superclassName) throws IOException
    {
        StringBuilderJavaSource source = new StringBuilderJavaSource("x.Frame");
        source.append("package x;\n");
        source.append("public class Frame extends " + superclassName + " {");
        source.append("protected void addEventHandlers() {");
        Properties props = new Properties();
        props.load(new FileReader(CompilerTest.class.getClassLoader().getResource("").getPath()
                + "com\\hnmmli\\other11\\javacore\\api\\action.properties"));
        for (Map.Entry<Object, Object> e : props.entrySet())
        {
            String beanName = (String) e.getKey();
            String eventCode = (String) e.getValue();
            source.append(beanName + ".addActionListener(new java.awt.event.ActionListener() {");
            source.append("public void actionPerformed(java.awt.event.ActionEvent event) {");
            source.append(eventCode);
            source.append("} } );");
        }
        source.append("} }");
        return source;
    }
}
