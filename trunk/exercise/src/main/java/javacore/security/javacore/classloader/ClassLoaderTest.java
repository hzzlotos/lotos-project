package javacore.security.javacore.classloader;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This program demonstrates a custom class loader that decrypts class files.
 * 
 * @version 1.22 2007-10-05
 * @author Cay Horstmann
 */
public class ClassLoaderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {

                JFrame frame = new ClassLoaderFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains two text fields for the name of the class to load and the decryption key.
 */
class ClassLoaderFrame extends JFrame
{
    public ClassLoaderFrame()
    {
        this.setTitle("ClassLoaderTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLayout(new GridBagLayout());
        this.add(new JLabel("Class"), new GBC(0, 0).setAnchor(GBC.EAST));
        this.add(this.nameField, new GBC(1, 0).setWeight(100, 0).setAnchor(GBC.WEST));
        this.add(new JLabel("Key"), new GBC(0, 1).setAnchor(GBC.EAST));
        this.add(this.keyField, new GBC(1, 1).setWeight(100, 0).setAnchor(GBC.WEST));
        JButton loadButton = new JButton("Load");
        this.add(loadButton, new GBC(0, 2, 2, 1));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ClassLoaderFrame.this.runClass(ClassLoaderFrame.this.nameField.getText(),
                        ClassLoaderFrame.this.keyField.getText());
            }
        });
        this.pack();
    }

    /**
     * Runs the main method of a given class.
     * 
     * @param name the class name
     * @param key the decryption key for the class files
     */
    public void runClass(String name, String key)
    {
        try
        {

            ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
            System.out.println("=====a=====");// 打印语句
            Class<?> c = loader.loadClass(name);
            System.out.println("=====b=====");// 打印语句
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[] {});
        }
        catch (Throwable e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private JTextField       keyField       = new JTextField("3", 4);

    private JTextField       nameField      = new JTextField("Calculator", 30);

    private static final int DEFAULT_WIDTH  = 300;

    private static final int DEFAULT_HEIGHT = 200;
}

/**
 * This class loader loads encrypted class files.
 */
class CryptoClassLoader extends ClassLoader
{
    /**
     * Constructs a crypto class loader.
     * 
     * @param k the decryption key
     */
    public CryptoClassLoader(int k)
    {
        this.key = k;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {

        System.out.println("=====1=====");// 打印语句
        byte[] classBytes = null;
        try
        {
            classBytes = this.loadClassBytes(name);
        }
        catch (IOException e)
        {
            throw new ClassNotFoundException(name);
        }
        // "javacore.security.javacore.classloader."+
        // 这里读取的是class文件的二进制文件|||||上句指定好路径
        Class<?> cl = this.defineClass(name, classBytes, 0, classBytes.length);
        if (cl == null)
        {
            throw new ClassNotFoundException(name);
        }
        return cl;
    }

    /**
     * Loads and decrypt the class file bytes.
     * 
     * @param name the class name
     * @return an array with the class file bytes
     */
    private byte[] loadClassBytes(String name) throws IOException
    {
        // 打印语句
        System.out.println("=====2=====");
        // TODO 此处为路径添加代码
        String path = ClassLoaderTest.class.getClassLoader().getResource("").getPath()
                + ("javacore\\security\\javacore\\classloader\\");
        String cname = path + name.replace('.', '/') + ".caesar";
        FileInputStream in = null;
        in = new FileInputStream(cname);
        try
        {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int ch;
            while ((ch = in.read()) != -1)
            {
                byte b = (byte) (ch - this.key);
                buffer.write(b);
            }
            in.close();
            return buffer.toByteArray();
        }
        finally
        {
            in.close();
        }
    }

    private int key;
}
