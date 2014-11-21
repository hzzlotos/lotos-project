package javacore.draw.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This program demonstrates how to print 2D graphics
 * 
 * @version 1.12 2007-08-16
 * @author Cay Horstmann
 */
public class PrintTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new PrintTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame shows a panel with 2D graphics and buttons to print the graphics and to set up the
 * page format.
 */
class PrintTestFrame extends JFrame
{
    public PrintTestFrame()
    {
        this.setTitle("PrintTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.canvas = new PrintComponent();
        this.add(this.canvas, BorderLayout.CENTER);

        this.attributes = new HashPrintRequestAttributeSet();

        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("Print");
        buttonPanel.add(printButton);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    PrinterJob job = PrinterJob.getPrinterJob();// 打印
                    job.setPrintable(PrintTestFrame.this.canvas);
                    if (job.printDialog(PrintTestFrame.this.attributes))
                    {
                        job.print(PrintTestFrame.this.attributes);
                    }
                }
                catch (PrinterException e)
                {
                    JOptionPane.showMessageDialog(PrintTestFrame.this, e);
                }
            }
        });

        JButton pageSetupButton = new JButton("Page setup");
        buttonPanel.add(pageSetupButton);
        pageSetupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.pageDialog(PrintTestFrame.this.attributes);
            }
        });

        this.add(buttonPanel, BorderLayout.NORTH);
    }

    private PrintComponent           canvas;

    private PrintRequestAttributeSet attributes;

    private static final int         DEFAULT_WIDTH  = 300;

    private static final int         DEFAULT_HEIGHT = 300;
}

/**
 * This component generates a 2D graphics image for screen display and printing.
 */
class PrintComponent extends JComponent implements Printable
{
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        this.drawPage(g2);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException
    {
        if (page >= 1)
        {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.draw(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));

        this.drawPage(g2);
        return Printable.PAGE_EXISTS;
    }

    /**
     * This method draws the page both on the screen and the printer graphics context.
     * 
     * @param g2 the graphics context
     */
    public void drawPage(Graphics2D g2)
    {
        FontRenderContext context = g2.getFontRenderContext();
        Font f = new Font("Serif", Font.PLAIN, 72);
        GeneralPath clipShape = new GeneralPath();

        TextLayout layout = new TextLayout("Hello", f, context);
        AffineTransform transform = AffineTransform.getTranslateInstance(0, 72);
        Shape outline = layout.getOutline(transform);
        clipShape.append(outline, false);

        layout = new TextLayout("World", f, context);
        transform = AffineTransform.getTranslateInstance(0, 144);
        outline = layout.getOutline(transform);
        clipShape.append(outline, false);

        g2.draw(clipShape);
        g2.clip(clipShape);

        final int NLINES = 50;
        Point2D p = new Point2D.Double(0, 0);
        for (int i = 0; i < NLINES; i++)
        {
            double x = (2 * this.getWidth() * i) / NLINES;
            double y = (2 * this.getHeight() * (NLINES - 1 - i)) / NLINES;
            Point2D q = new Point2D.Double(x, y);
            g2.draw(new Line2D.Double(p, q));
        }
    }
}
