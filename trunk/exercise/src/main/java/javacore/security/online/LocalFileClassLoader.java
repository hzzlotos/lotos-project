package javacore.security.online;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LocalFileClassLoader extends ClassLoader
{
    private String location;

    public LocalFileClassLoader(String location)
    {
        this(location, LocalFileClassLoader.class.getClassLoader());
    }

    public LocalFileClassLoader(String location, ClassLoader parent)
    {
        super(parent);
        this.location = location;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException
    {
        String separatorStr = new String(new char[] { File.separatorChar });
        if (!this.location.endsWith(separatorStr))
        {
            this.location = this.location + separatorStr;
        }
        String filename = this.location + name.replace('.', File.separatorChar) + ".class";
        byte[] classData = null;
        try
        {
            classData = this.loadClassData(filename);
        }
        catch (FileNotFoundException e)
        {
            throw new ClassNotFoundException("Cannot find " + name + " at " + this.location);
        }
        catch (IOException e)
        {
            throw new ClassNotFoundException("Read class data error");
        }

        if (null == classData)
        {
            throw new ClassNotFoundException("Unknown reason");
        }

        return super.defineClass(null, classData, 0, classData.length);
    }

    public String getLocation()
    {
        return this.location;
    }

    private byte[] loadClassData(String filename) throws FileNotFoundException, IOException
    {
        File inputFile = new File(filename);
        byte[] classData = new byte[(int) inputFile.length()];
        FileInputStream inputStream = new FileInputStream(filename);
        DataInputStream dataInput = new DataInputStream(inputStream);
        dataInput.readFully(classData);
        dataInput.close();
        return classData;
    }
}
