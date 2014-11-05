package com.hnmmli.chapter11.javacore.compilerapi.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public abstract class ButtonFrame extends JFrame
{
    public ButtonFrame()
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.panel = new JPanel();
        this.add(this.panel);

        this.yellowButton = new JButton("Yellow");
        this.blueButton = new JButton("Blue");
        this.redButton = new JButton("Red");

        this.panel.add(this.yellowButton);
        this.panel.add(this.blueButton);
        this.panel.add(this.redButton);

        this.addEventHandlers();
    }

    protected abstract void addEventHandlers();

    public static final int DEFAULT_WIDTH  = 300;

    public static final int DEFAULT_HEIGHT = 200;

    protected JPanel        panel;

    protected JButton       yellowButton;

    protected JButton       blueButton;

    protected JButton       redButton;
}
