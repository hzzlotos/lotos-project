package com.hnmmli.thread.corejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgorithmAnimation
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new AnimationFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class AnimationFrame extends JFrame
{
    public AnimationFrame()
    {
        ArrayComponent comp = new ArrayComponent();
        this.add(comp, BorderLayout.CENTER);

        final Sorter sorter = new Sorter(comp);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                sorter.setRun();
            }
        });

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                sorter.setStep();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(runButton);
        buttons.add(stepButton);
        this.add(buttons, BorderLayout.NORTH);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Thread t = new Thread(sorter);
        t.start();
    }

    private static final int DEFAULT_WIDTH  = 300;

    private static final int DEFAULT_HEIGHT = 300;
}

class Sorter implements Runnable
{

    public Sorter(ArrayComponent comp)
    {
        this.values = new Double[VALUES_LENGTH];
        for (int i = 0; i < this.values.length; i++)
        {
            this.values[i] = new Double(Math.random());
        }
        this.component = comp;
        this.gate = new Semaphore(1);
        this.run = false;
    }

    public void setRun()
    {
        this.run = true;
        this.gate.release();
    }

    public void setStep()
    {
        this.run = false;
        this.gate.release();
    }

    @Override
    public void run()
    {
        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double i1, Double i2)
            {
                Sorter.this.component.setValues(Sorter.this.values, i1, i2);
                try
                {
                    if (Sorter.this.run)
                    {
                        Thread.sleep(DELAY);
                    }
                    else
                    {
                        Sorter.this.gate.acquire();
                    }
                }
                catch (InterruptedException exception)
                {
                    Thread.currentThread().interrupt();
                }
                return i1.compareTo(i2);
            }
        };
        Arrays.sort(this.values, comp);
        this.component.setValues(this.values, null, null);
    }

    private Double[]         values;

    private ArrayComponent   component;

    private Semaphore        gate;

    private static final int DELAY         = 100;

    private volatile boolean run;

    private static final int VALUES_LENGTH = 30;
}

/**
 * This component draws an array and marks two elements in the array.
 */
class ArrayComponent extends JComponent
{
    /**
     * Sets the values to be painted. Called on the sorter thread.
     * 
     * @param values the array of values to display
     * @param marked1 the first marked element
     * @param marked2 the second marked element
     */
    public synchronized void setValues(Double[] values, Double marked1, Double marked2)
    {
        this.values = values.clone();
        this.marked1 = marked1;
        this.marked2 = marked2;
        this.repaint();
    }

    @Override
    public synchronized void paintComponent(Graphics g) // Called on the event dispatch thread
    {
        if (this.values == null)
        {
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        int width = this.getWidth() / this.values.length;
        for (int i = 0; i < this.values.length; i++)
        {
            double height = this.values[i] * this.getHeight();
            Rectangle2D bar = new Rectangle2D.Double(width * i, 0, width, height);
            if (this.values[i] == this.marked1 || this.values[i] == this.marked2)
            {
                g2.fill(bar);
            }
            else
            {
                g2.draw(bar);
            }
        }
    }

    private Double   marked1;

    private Double   marked2;

    private Double[] values;
}