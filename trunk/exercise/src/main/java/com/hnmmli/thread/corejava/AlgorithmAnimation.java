package com.hnmmli.thread.corejava;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgorithmAnimation
{
    public static void main(String[] args)
    {
        JFrame frame = new AnimationFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class AnimationFrame extends JFrame
{

    private static final long serialVersionUID = 1L;

    private static final int  DEFAULT_HEIGHT   = 300;

    private static final int  DEFAULT_WIDTH    = 300;

    private static final int  VALUES_LENGTH    = 30;

    public AnimationFrame()
    {
        ArrayPanel panel = new ArrayPanel();
        this.add(panel, BorderLayout.CENTER);

        Double[] values = new Double[VALUES_LENGTH];
        final Sorter sorter = new Sorter(values, panel);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                sorter.restart();
            }
        });

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
        buttons.add(restartButton);
        buttons.add(runButton);
        buttons.add(stepButton);
        this.add(buttons, BorderLayout.NORTH);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        for (int i = 0; i < values.length; i++)
        {
            values[i] = new Double(Math.random());
        }

        Thread t = new Thread(sorter);
        t.start();
    }
}

class ArrayPanel extends JPanel
{

    private static final long serialVersionUID = 1L;

    private Double            marked1;

    private Double            marked2;

    private Double[]          values;

    @Override
    public void paintComponent(Graphics g)
    {
        if (this.values == null)
        {
            return;
        }
        super.paintComponent(g);
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

    public void setValues(Double[] values, Double marked1, Double marked2)
    {
        this.values = values;
        this.marked1 = marked1;
        this.marked2 = marked2;
        this.repaint();
    }
}

class Sorter implements Runnable
{

    private static final int DELAY = 2000;

    private Semaphore        semaphore;

    private ArrayPanel       panel;

    private boolean          run;

    private Double[]         values;

    public Sorter(Double[] values, ArrayPanel panel)
    {
        this.values = values;
        this.panel = panel;
        this.semaphore = new Semaphore(1);
        this.run = false;
    }

    @Override
    public void run()
    {
        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double i1, Double i2)
            {
                Sorter.this.panel.setValues(Sorter.this.values, i1, i2);
                try
                {
                    if (Sorter.this.run)
                    {
                        Thread.sleep(DELAY);
                    }
                    else
                    {
                        Sorter.this.semaphore.acquire();
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
        this.panel.setValues(this.values, null, null);
    }

    public void restart()
    {
        this.run = false;
        for (int i = 0; i < this.values.length; i++)
        {
            this.values[i] = new Double(Math.random());
        }
        this.semaphore.release();
    }

    public void setRun()
    {
        this.run = true;
        this.semaphore.release();
    }

    public void setStep()
    {
        this.run = false;
        this.semaphore.release();
    }
}
