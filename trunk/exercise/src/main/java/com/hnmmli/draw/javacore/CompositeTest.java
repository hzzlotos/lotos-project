package com.hnmmli.draw.javacore;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This program demonstrates the Porter-Duff composition rules.
 * 
 * @version 1.03 2007-08-16
 * @author Cay Horstmann
 */
public class CompositeTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new CompositeTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains a combo box to choose a composition rule, a slider to change the source alpha
 * channel, and a component that shows the composition.
 */
class CompositeTestFrame extends JFrame
{
    public CompositeTestFrame()
    {
        this.setTitle("CompositeTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.canvas = new CompositeComponent();
        this.add(this.canvas, BorderLayout.CENTER);

        this.ruleCombo = new JComboBox(new Object[] { new Rule("CLEAR", "  ", "  "), new Rule("SRC", " S", " S"),
                new Rule("DST", "  ", "DD"), new Rule("SRC_OVER", " S", "DS"), new Rule("DST_OVER", " S", "DD"),
                new Rule("SRC_IN", "  ", " S"), new Rule("SRC_OUT", " S", "  "), new Rule("DST_IN", "  ", " D"),
                new Rule("DST_OUT", "  ", "D "), new Rule("SRC_ATOP", "  ", "DS"), new Rule("DST_ATOP", " S", " D"),
                new Rule("XOR", " S", "D "), });
        this.ruleCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Rule r = (Rule) CompositeTestFrame.this.ruleCombo.getSelectedItem();
                CompositeTestFrame.this.canvas.setRule(r.getValue());
                CompositeTestFrame.this.explanation.setText(r.getExplanation());
            }
        });

        this.alphaSlider = new JSlider(0, 100, 75);
        this.alphaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                CompositeTestFrame.this.canvas.setAlpha(CompositeTestFrame.this.alphaSlider.getValue());
            }
        });
        JPanel panel = new JPanel();
        panel.add(this.ruleCombo);
        panel.add(new JLabel("Alpha"));
        panel.add(this.alphaSlider);
        this.add(panel, BorderLayout.NORTH);

        this.explanation = new JTextField();
        this.add(this.explanation, BorderLayout.SOUTH);

        this.canvas.setAlpha(this.alphaSlider.getValue());
        Rule r = (Rule) this.ruleCombo.getSelectedItem();
        this.canvas.setRule(r.getValue());
        this.explanation.setText(r.getExplanation());
    }

    private CompositeComponent canvas;

    private JComboBox          ruleCombo;

    private JSlider            alphaSlider;

    private JTextField         explanation;

    private static final int   DEFAULT_WIDTH  = 400;

    private static final int   DEFAULT_HEIGHT = 400;
}

/**
 * This class describes a Porter-Duff rule.
 */
class Rule
{
    /**
     * Constructs a Porter-Duff rule
     * 
     * @param n the rule name
     * @param pd1 the first row of the Porter-Duff square
     * @param pd2 the second row of the Porter-Duff square
     */
    public Rule(String n, String pd1, String pd2)
    {
        this.name = n;
        this.porterDuff1 = pd1;
        this.porterDuff2 = pd2;
    }

    /**
     * Gets an explanation of the behavior of this rule.
     * 
     * @return the explanation
     */
    public String getExplanation()
    {
        StringBuilder r = new StringBuilder("Source ");
        if (this.porterDuff2.equals("  "))
        {
            r.append("clears");
        }
        if (this.porterDuff2.equals(" S"))
        {
            r.append("overwrites");
        }
        if (this.porterDuff2.equals("DS"))
        {
            r.append("blends with");
        }
        if (this.porterDuff2.equals(" D"))
        {
            r.append("alpha modifies");
        }
        if (this.porterDuff2.equals("D "))
        {
            r.append("alpha complement modifies");
        }
        if (this.porterDuff2.equals("DD"))
        {
            r.append("does not affect");
        }
        r.append(" destination");
        if (this.porterDuff1.equals(" S"))
        {
            r.append(" and overwrites empty pixels");
        }
        r.append(".");
        return r.toString();
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    /**
     * Gets the value of this rule in the AlphaComposite class
     * 
     * @return the AlphaComposite constant value, or -1 if there is no matching constant.
     */
    public int getValue()
    {
        try
        {
            return (Integer) AlphaComposite.class.getField(this.name).get(null);
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    private String name;

    private String porterDuff1;

    private String porterDuff2;
}

/**
 * This component draws two shapes, composed with a composition rule.
 */
class CompositeComponent extends JComponent
{
    public CompositeComponent()
    {
        this.shape1 = new Ellipse2D.Double(100, 100, 150, 100);
        this.shape2 = new Rectangle2D.Double(150, 150, 150, 100);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gImage = image.createGraphics();
        gImage.setPaint(Color.red);
        gImage.fill(this.shape1);
        AlphaComposite composite = AlphaComposite.getInstance(this.rule, this.alpha);
        gImage.setComposite(composite);
        gImage.setPaint(Color.blue);
        gImage.fill(this.shape2);
        g2.drawImage(image, null, 0, 0);
    }

    /**
     * Sets the composition rule.
     * 
     * @param r the rule (as an AlphaComposite constant)
     */
    public void setRule(int r)
    {
        this.rule = r;
        this.repaint();
    }

    /**
     * Sets the alpha of the source
     * 
     * @param a the alpha value between 0 and 100
     */
    public void setAlpha(int a)
    {
        this.alpha = a / 100.0F;
        this.repaint();
    }

    private int   rule;

    private Shape shape1;

    private Shape shape2;

    private float alpha;
}
