package com.hnmmli.other11.javacore.script;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 1.00 2007-10-28
 * @author Cay Horstmann
 */
public class ScriptTest
{
    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                String language;
                if (args.length == 0)
                {
                    language = "js";
                }
                else
                {
                    language = args[0];
                }

                ScriptEngineManager manager = new ScriptEngineManager();
                System.out.println("Available factories: ");
                for (ScriptEngineFactory factory : manager.getEngineFactories())
                {
                    System.out.println(factory.getEngineName());
                }
                final ScriptEngine engine = manager.getEngineByName(language);

                if (engine == null)
                {
                    System.err.println("No engine for " + language);
                    System.exit(1);
                }

                ButtonFrame frame = new ButtonFrame();

                try
                {
                    File initFile = new File("init." + language);
                    if (initFile.exists())
                    {
                        engine.eval(new FileReader(initFile));
                    }

                    getComponentBindings(frame, engine);

                    final Properties events = new Properties();
                    events.load(new FileReader(ScriptTest.class.getClassLoader().getResource("").getPath()
                            + "\\com\\hnmmli\\other11\\javacore\\script\\" + language + ".properties"));
                    for (final Object e : events.keySet())
                    {
                        String[] s = ((String) e).split("\\.");
                        addListener(s[0], s[1], (String) events.get(e), engine);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("ScriptTest");
                frame.setVisible(true);
            }
        });
    }

    /**
     * Gathers all named components in a container.
     * 
     * @param c the component
     * @param namedComponents
     */
    private static void getComponentBindings(Component c, ScriptEngine engine)
    {
        String name = c.getName();
        if (name != null)
        {
            engine.put(name, c);
        }
        if (c instanceof Container)
        {
            for (Component child : ((Container) c).getComponents())
            {
                getComponentBindings(child, engine);
            }
        }
    }

    /**
     * Adds a listener to an object whose listener method executes a script.
     * 
     * @param beanName the name of the bean to which the listener should be added
     * @param eventName the name of the listener type, such as "action" or "change"
     * @param scriptCode the script code to be executed
     * @param engine the engine that executes the code
     * @param bindings the bindings for the execution
     */
    private static void addListener(String beanName, String eventName, final String scriptCode,
            final ScriptEngine engine) throws IllegalArgumentException, IntrospectionException, IllegalAccessException,
            InvocationTargetException
    {
        Object bean = engine.get(beanName);
        EventSetDescriptor descriptor = getEventSetDescriptor(bean, eventName);
        if (descriptor == null)
        {
            return;
        }
        descriptor.getAddListenerMethod().invoke(bean,
                Proxy.newProxyInstance(null, new Class[] { descriptor.getListenerType() }, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                    {
                        engine.eval(scriptCode);
                        return null;
                    }
                }));

    }

    private static EventSetDescriptor getEventSetDescriptor(Object bean, String eventName)
            throws IntrospectionException
    {
        for (EventSetDescriptor descriptor : Introspector.getBeanInfo(bean.getClass()).getEventSetDescriptors())
        {
            if (descriptor.getName().equals(eventName))
            {
                return descriptor;
            }
        }
        return null;
    }
}

class ButtonFrame extends JFrame
{
    public ButtonFrame()
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.panel = new JPanel();
        this.panel.setName("panel");
        this.add(this.panel);

        this.yellowButton = new JButton("Yellow");
        this.yellowButton.setName("yellowButton");
        this.blueButton = new JButton("Blue");
        this.blueButton.setName("blueButton");
        this.redButton = new JButton("Red");
        this.redButton.setName("redButton");

        this.panel.add(this.yellowButton);
        this.panel.add(this.blueButton);
        this.panel.add(this.redButton);
    }

    public static final int DEFAULT_WIDTH  = 300;

    public static final int DEFAULT_HEIGHT = 200;

    private JPanel          panel;

    private JButton         yellowButton;

    private JButton         blueButton;

    private JButton         redButton;
}
