package javacore.draw.javacore;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This program demonstrates different stroke types.
 * 
 * @version 1.03 2007-08-16
 * @author Cay Horstmann
 */
public class StrokeTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new StrokeTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame lets the user choose the cap, join, and line style, and shows the resulting stroke.
 */
class StrokeTestFrame extends JFrame
{
    public StrokeTestFrame()
    {
        this.setTitle("StrokeTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.canvas = new StrokeComponent();
        this.add(this.canvas, BorderLayout.CENTER);

        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(3, 3));
        this.add(this.buttonPanel, BorderLayout.NORTH);

        ButtonGroup group1 = new ButtonGroup();
        this.makeCapButton("Butt Cap", BasicStroke.CAP_BUTT, group1);
        this.makeCapButton("Round Cap", BasicStroke.CAP_ROUND, group1);
        this.makeCapButton("Square Cap", BasicStroke.CAP_SQUARE, group1);

        ButtonGroup group2 = new ButtonGroup();
        this.makeJoinButton("Miter Join", BasicStroke.JOIN_MITER, group2);
        this.makeJoinButton("Bevel Join", BasicStroke.JOIN_BEVEL, group2);
        this.makeJoinButton("Round Join", BasicStroke.JOIN_ROUND, group2);

        ButtonGroup group3 = new ButtonGroup();
        this.makeDashButton("Solid Line", false, group3);
        this.makeDashButton("Dashed Line", true, group3);
    }

    /**
     * Makes a radio button to change the cap style.
     * 
     * @param label the button label
     * @param style the cap style
     * @param group the radio button group
     */
    private void makeCapButton(String label, final int style, ButtonGroup group)
    {
        // select first button in group
        boolean selected = group.getButtonCount() == 0;
        JRadioButton button = new JRadioButton(label, selected);
        this.buttonPanel.add(button);
        group.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                StrokeTestFrame.this.canvas.setCap(style);
            }
        });
    }

    /**
     * Makes a radio button to change the join style.
     * 
     * @param label the button label
     * @param style the join style
     * @param group the radio button group
     */
    private void makeJoinButton(String label, final int style, ButtonGroup group)
    {
        // select first button in group
        boolean selected = group.getButtonCount() == 0;
        JRadioButton button = new JRadioButton(label, selected);
        this.buttonPanel.add(button);
        group.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                StrokeTestFrame.this.canvas.setJoin(style);
            }
        });
    }

    /**
     * Makes a radio button to set solid or dashed lines
     * 
     * @param label the button label
     * @param style false for solid, true for dashed lines
     * @param group the radio button group
     */
    private void makeDashButton(String label, final boolean style, ButtonGroup group)
    {
        // select first button in group
        boolean selected = group.getButtonCount() == 0;
        JRadioButton button = new JRadioButton(label, selected);
        this.buttonPanel.add(button);
        group.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                StrokeTestFrame.this.canvas.setDash(style);
            }
        });
    }

    private StrokeComponent  canvas;

    private JPanel           buttonPanel;

    private static final int DEFAULT_WIDTH  = 400;

    private static final int DEFAULT_HEIGHT = 400;
}

/**
 * This component draws two joined lines, using different stroke objects, and allows the user to drag
 * the three points defining the lines.
 */
class StrokeComponent extends JComponent
{
    public StrokeComponent()
    {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event)
            {
                Point p = event.getPoint();
                for (int i = 0; i < StrokeComponent.this.points.length; i++)
                {
                    double x = StrokeComponent.this.points[i].getX() - SIZE / 2;
                    double y = StrokeComponent.this.points[i].getY() - SIZE / 2;
                    Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
                    if (r.contains(p))
                    {
                        StrokeComponent.this.current = i;
                        return;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent event)
            {
                StrokeComponent.this.current = -1;
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                if (StrokeComponent.this.current == -1)
                {
                    return;
                }
                StrokeComponent.this.points[StrokeComponent.this.current] = event.getPoint();
                StrokeComponent.this.repaint();
            }
        });

        this.points = new Point2D[3];
        this.points[0] = new Point2D.Double(200, 100);
        this.points[1] = new Point2D.Double(100, 200);
        this.points[2] = new Point2D.Double(200, 200);
        this.current = -1;
        this.width = 8.0F;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath path = new GeneralPath();
        path.moveTo((float) this.points[0].getX(), (float) this.points[0].getY());
        for (int i = 1; i < this.points.length; i++)
        {
            path.lineTo((float) this.points[i].getX(), (float) this.points[i].getY());
        }
        BasicStroke stroke;
        if (this.dash)
        {
            float miterLimit = 10.0F;
            float[] dashPattern = { 10F, 10F, 10F, 10F, 10F, 10F, 30F, 10F, 30F, 10F, 30F, 10F, 10F, 10F, 10F, 10F,
                    10F, 30F };
            float dashPhase = 0;
            stroke = new BasicStroke(this.width, this.cap, this.join, miterLimit, dashPattern, dashPhase);
        }
        else
        {
            stroke = new BasicStroke(this.width, this.cap, this.join);
        }
        g2.setStroke(stroke);
        g2.draw(path);
    }

    /**
     * Sets the join style.
     * 
     * @param j the join style
     */
    public void setJoin(int j)
    {
        this.join = j;
        this.repaint();
    }

    /**
     * Sets the cap style.
     * 
     * @param c the cap style
     */
    public void setCap(int c)
    {
        this.cap = c;
        this.repaint();
    }

    /**
     * Sets solid or dashed lines
     * 
     * @param d false for solid, true for dashed lines
     */
    public void setDash(boolean d)
    {
        this.dash = d;
        this.repaint();
    }

    private Point2D[]  points;

    private static int SIZE = 10;

    private int        current;

    private float      width;

    private int        cap;

    private int        join;

    private boolean    dash;
}
