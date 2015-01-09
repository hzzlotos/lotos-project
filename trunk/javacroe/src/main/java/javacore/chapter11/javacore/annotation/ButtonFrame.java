package javacore.chapter11.javacore.annotation;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A frame with a button panel
 * 
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
public class ButtonFrame extends JFrame
{
    public ButtonFrame()
    {
        this.setTitle("ButtonTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.panel = new JPanel();
        this.add(this.panel);

        this.yellowButton = new JButton("Yellow");
        this.blueButton = new JButton("Blue");
        this.redButton = new JButton("Red");

        this.panel.add(this.yellowButton);
        this.panel.add(this.blueButton);
        this.panel.add(this.redButton);

        ActionListenerInstaller.processAnnotations(this);
    }

    @ActionListenerFor(source = "yellowButton")
    public void yellowBackground()
    {
        this.panel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueButton")
    public void blueBackground()
    {
        this.panel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redButton")
    public void redBackground()
    {
        this.panel.setBackground(Color.RED);
    }

    public static final int DEFAULT_WIDTH  = 300;

    public static final int DEFAULT_HEIGHT = 200;

    private JPanel          panel;

    private JButton         yellowButton;

    private JButton         blueButton;

    private JButton         redButton;
}
