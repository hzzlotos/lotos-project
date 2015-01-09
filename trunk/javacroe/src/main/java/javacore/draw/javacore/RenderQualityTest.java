package javacore.draw.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This program demonstrates the effect of the various rendering hints.
 * 
 * @version 1.10 2007-08-16
 * @author Cay Horstmann
 */
public class RenderQualityTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new RenderQualityTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains buttons to set rendering hints and an image that is drawn with the selected
 * hints.
 */
class RenderQualityTestFrame extends JFrame
{
    public RenderQualityTestFrame()
    {
        this.setTitle("RenderQualityTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.buttonBox = new JPanel();
        this.buttonBox.setLayout(new GridBagLayout());
        this.hints = new RenderingHints(null);

        this.makeButtons("KEY_ANTIALIASING", "VALUE_ANTIALIAS_OFF", "VALUE_ANTIALIAS_ON");
        this.makeButtons("KEY_TEXT_ANTIALIASING", "VALUE_TEXT_ANTIALIAS_OFF", "VALUE_TEXT_ANTIALIAS_ON");
        this.makeButtons("KEY_FRACTIONALMETRICS", "VALUE_FRACTIONALMETRICS_OFF", "VALUE_FRACTIONALMETRICS_ON");
        this.makeButtons("KEY_RENDERING", "VALUE_RENDER_SPEED", "VALUE_RENDER_QUALITY");
        this.makeButtons("KEY_STROKE_CONTROL", "VALUE_STROKE_PURE", "VALUE_STROKE_NORMALIZE");
        this.canvas = new RenderQualityComponent();
        this.canvas.setRenderingHints(this.hints);

        this.add(this.canvas, BorderLayout.CENTER);
        this.add(this.buttonBox, BorderLayout.NORTH);
    }

    /**
     * Makes a set of buttons for a rendering hint key and values
     * 
     * @param key the key name
     * @param value1 the name of the first value for the key
     * @param value2 the name of the second value for the key
     */
    void makeButtons(String key, String value1, String value2)
    {
        try
        {
            final RenderingHints.Key k = (RenderingHints.Key) RenderingHints.class.getField(key).get(null);
            final Object v1 = RenderingHints.class.getField(value1).get(null);
            final Object v2 = RenderingHints.class.getField(value2).get(null);
            JLabel label = new JLabel(key);

            this.buttonBox.add(label, new GBC(0, this.r).setAnchor(GBC.WEST));
            ButtonGroup group = new ButtonGroup();
            JRadioButton b1 = new JRadioButton(value1, true);

            this.buttonBox.add(b1, new GBC(1, this.r).setAnchor(GBC.WEST));
            group.add(b1);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    RenderQualityTestFrame.this.hints.put(k, v1);
                    RenderQualityTestFrame.this.canvas.setRenderingHints(RenderQualityTestFrame.this.hints);
                }
            });
            JRadioButton b2 = new JRadioButton(value2, false);

            this.buttonBox.add(b2, new GBC(2, this.r).setAnchor(GBC.WEST));
            group.add(b2);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    RenderQualityTestFrame.this.hints.put(k, v2);
                    RenderQualityTestFrame.this.canvas.setRenderingHints(RenderQualityTestFrame.this.hints);
                }
            });
            this.hints.put(k, v1);
            this.r++;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private RenderQualityComponent canvas;

    private JPanel                 buttonBox;

    private RenderingHints         hints;

    private int                    r;

    private static final int       DEFAULT_WIDTH  = 750;

    private static final int       DEFAULT_HEIGHT = 300;
}

/**
 * This component produces a drawing that shows the effect of rendering hints.
 */
class RenderQualityComponent extends JComponent
{
    public RenderQualityComponent()
    {
        try
        {
            this.image = ImageIO.read(new File(RenderQualityTest.class.getClassLoader().getResource("").getPath()
                    + "javacore" + "face.gif"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(this.hints);

        g2.draw(new Ellipse2D.Double(10, 10, 60, 50));
        g2.setFont(new Font("Serif", Font.ITALIC, 40));
        g2.drawString("Hello", 75, 50);

        g2.draw(new Rectangle2D.Double(200, 10, 40, 40));
        g2.draw(new Line2D.Double(201, 11, 239, 49));

        g2.drawImage(this.image, 250, 10, 100, 100, null);
    }

    /**
     * Sets the hints and repaints.
     * 
     * @param h the rendering hints
     */
    public void setRenderingHints(RenderingHints h)
    {
        this.hints = h;
        this.repaint();
    }

    private RenderingHints hints = new RenderingHints(null);

    private Image          image;
}
