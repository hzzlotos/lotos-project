package javacore.chapter11.javacore.compilerapi;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * A Java source that holds the code in a string builder.
 * 
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public class StringBuilderJavaSource extends SimpleJavaFileObject
{
    /**
     * Constructs a new StringBuilderJavaSource
     * 
     * @param name the name of the source file represented by this file object
     */
    public StringBuilderJavaSource(String name)
    {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = new StringBuilder();
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
    {
        return this.code;
    }

    public void append(String str)
    {
        this.code.append(str);
        this.code.append('\n');
    }

    private StringBuilder code;
}
