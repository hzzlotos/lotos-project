package com.hnmmli.draw.javacore;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This program demonstrates the printing of a multi-page book. It prints a "banner", by blowing up
 * a text string to fill the entire page vertically. The program also contains a generic print
 * preview dialog.
 * 
 * @version 1.12 2007-08-16
 * @author Cay Horstmann
 */
public class BookTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new BookTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame has a text field for the banner text and buttons for printing, page setup, and print
 * preview.
 */
class BookTestFrame extends JFrame
{
    public BookTestFrame()
    {
        this.setTitle("BookTest");

        this.text = new JTextField();
        this.add(this.text, BorderLayout.NORTH);

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
                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPageable(BookTestFrame.this.makeBook());
                    if (job.printDialog(BookTestFrame.this.attributes))
                    {
                        job.print(BookTestFrame.this.attributes);
                    }
                }
                catch (PrinterException e)
                {
                    JOptionPane.showMessageDialog(BookTestFrame.this, e);
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
                BookTestFrame.this.pageFormat = job.pageDialog(BookTestFrame.this.attributes);
            }
        });

        JButton printPreviewButton = new JButton("Print preview");
        buttonPanel.add(printPreviewButton);
        printPreviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PrintPreviewDialog dialog = new PrintPreviewDialog(BookTestFrame.this.makeBook());
                dialog.setVisible(true);
            }
        });

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
    }

    /**
     * Makes a book that contains a cover page and the pages for the banner.
     */
    public Book makeBook()
    {
        if (this.pageFormat == null)
        {
            PrinterJob job = PrinterJob.getPrinterJob();
            this.pageFormat = job.defaultPage();
        }
        Book book = new Book();
        String message = this.text.getText();
        Banner banner = new Banner(message);
        int pageCount = banner.getPageCount((Graphics2D) this.getGraphics(), this.pageFormat);
        book.append(new CoverPage(message + " (" + pageCount + " pages)"), this.pageFormat);
        book.append(banner, this.pageFormat, pageCount);
        return book;
    }

    private JTextField               text;

    private PageFormat               pageFormat;

    private PrintRequestAttributeSet attributes;
}

/**
 * A banner that prints a text string on multiple pages.
 */
// 分页计算
class Banner implements Printable
{
    /**
     * Constructs a banner
     * 
     * @param m the message string
     */
    public Banner(String m)
    {
        this.message = m;
    }

    /**
     * Gets the page count of this section.
     * 
     * @param g2 the graphics context
     * @param pf the page format
     * @return the number of pages needed
     */
    public int getPageCount(Graphics2D g2, PageFormat pf)
    {
        if (this.message.equals(""))
        {
            return 0;
        }
        FontRenderContext context = g2.getFontRenderContext();
        Font f = new Font("Serif", Font.PLAIN, 72);
        Rectangle2D bounds = f.getStringBounds(this.message, context);
        this.scale = pf.getImageableHeight() / bounds.getHeight();
        double width = this.scale * bounds.getWidth();
        int pages = (int) Math.ceil(width / pf.getImageableWidth());
        return pages;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException
    {
        Graphics2D g2 = (Graphics2D) g;
        if (page > this.getPageCount(g2, pf))
        {
            return Printable.NO_SUCH_PAGE;
        }
        g2.translate(pf.getImageableX(), pf.getImageableY());

        this.drawPage(g2, pf, page);
        return Printable.PAGE_EXISTS;
    }

    public void drawPage(Graphics2D g2, PageFormat pf, int page)
    {
        if (this.message.equals(""))
        {
            return;
        }
        page--; // account for cover page
        this.drawCropMarks(g2, pf);
        g2.clip(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));
        g2.translate(-page * pf.getImageableWidth(), 0);
        g2.scale(this.scale, this.scale);
        FontRenderContext context = g2.getFontRenderContext();
        Font f = new Font("Serif", Font.PLAIN, 72);
        TextLayout layout = new TextLayout(this.message, f, context);
        AffineTransform transform = AffineTransform.getTranslateInstance(0, layout.getAscent());
        Shape outline = layout.getOutline(transform);
        g2.draw(outline);
    }

    /**
     * Draws 1/2" crop marks in the corners of the page.
     * 
     * @param g2 the graphics context
     * @param pf the page format
     */
    public void drawCropMarks(Graphics2D g2, PageFormat pf)
    {
        final double C = 36; // crop mark length = 1/2 inch
        double w = pf.getImageableWidth();
        double h = pf.getImageableHeight();
        g2.draw(new Line2D.Double(0, 0, 0, C));
        g2.draw(new Line2D.Double(0, 0, C, 0));
        g2.draw(new Line2D.Double(w, 0, w, C));
        g2.draw(new Line2D.Double(w, 0, w - C, 0));
        g2.draw(new Line2D.Double(0, h, 0, h - C));
        g2.draw(new Line2D.Double(0, h, C, h));
        g2.draw(new Line2D.Double(w, h, w, h - C));
        g2.draw(new Line2D.Double(w, h, w - C, h));
    }

    private String message;

    private double scale;
}

/**
 * This class prints a cover page with a title.
 */
class CoverPage implements Printable
{
    /**
     * Constructs a cover page.
     * 
     * @param t the title
     */
    public CoverPage(String t)
    {
        this.title = t;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException
    {
        if (page >= 1)
        {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.black);
        g2.translate(pf.getImageableX(), pf.getImageableY());
        FontRenderContext context = g2.getFontRenderContext();
        Font f = g2.getFont();
        TextLayout layout = new TextLayout(this.title, f, context);
        float ascent = layout.getAscent();
        g2.drawString(this.title, 0, ascent);
        return Printable.PAGE_EXISTS;
    }

    private String title;
}

/**
 * This class implements a generic print preview dialog.
 */
// 预览
class PrintPreviewDialog extends JDialog
{
    /**
     * Constructs a print preview dialog.
     * 
     * @param p a Printable
     * @param pf the page format
     * @param pages the number of pages in p
     */
    public PrintPreviewDialog(Printable p, PageFormat pf, int pages)
    {
        Book book = new Book();
        book.append(p, pf, pages);
        this.layoutUI(book);
    }

    /**
     * Constructs a print preview dialog.
     * 
     * @param b a Book
     */
    public PrintPreviewDialog(Book b)
    {
        this.layoutUI(b);
    }

    /**
     * Lays out the UI of the dialog.
     * 
     * @param book the book to be previewed
     */
    public void layoutUI(Book book)
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.canvas = new PrintPreviewCanvas(book);
        this.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton nextButton = new JButton("Next");
        buttonPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PrintPreviewDialog.this.canvas.flipPage(1);
            }
        });

        JButton previousButton = new JButton("Previous");
        buttonPanel.add(previousButton);
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PrintPreviewDialog.this.canvas.flipPage(-1);
            }
        });

        JButton closeButton = new JButton("Close");
        buttonPanel.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PrintPreviewDialog.this.setVisible(false);
            }
        });

        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private PrintPreviewCanvas canvas;

    private static final int   DEFAULT_WIDTH  = 300;

    private static final int   DEFAULT_HEIGHT = 300;
}

/**
 * The canvas for displaying the print preview.
 */
class PrintPreviewCanvas extends JComponent
{
    /**
     * Constructs a print preview canvas.
     * 
     * @param b the book to be previewed
     */
    public PrintPreviewCanvas(Book b)
    {
        this.book = b;
        this.currentPage = 0;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        PageFormat pageFormat = this.book.getPageFormat(this.currentPage);

        double xoff; // x offset of page start in window
        double yoff; // y offset of page start in window
        double scale; // scale factor to fit page in window
        double px = pageFormat.getWidth();
        double py = pageFormat.getHeight();
        double sx = this.getWidth() - 1;
        double sy = this.getHeight() - 1;
        if (px / py < sx / sy) // center horizontally
        {
            scale = sy / py;
            xoff = 0.5 * (sx - scale * px);
            yoff = 0;
        }
        else
        // center vertically
        {
            scale = sx / px;
            xoff = 0;
            yoff = 0.5 * (sy - scale * py);
        }
        g2.translate((float) xoff, (float) yoff);
        g2.scale((float) scale, (float) scale);

        // draw page outline (ignoring margins)
        Rectangle2D page = new Rectangle2D.Double(0, 0, px, py);
        g2.setPaint(Color.white);
        g2.fill(page);
        g2.setPaint(Color.black);
        g2.draw(page);

        Printable printable = this.book.getPrintable(this.currentPage);
        try
        {
            printable.print(g2, pageFormat, this.currentPage);
        }
        catch (PrinterException e)
        {
            g2.draw(new Line2D.Double(0, 0, px, py));
            g2.draw(new Line2D.Double(px, 0, 0, py));
        }
    }

    /**
     * Flip the book by the given number of pages.
     * 
     * @param by the number of pages to flip by. Negative values flip backwards.
     */
    public void flipPage(int by)
    {
        int newPage = this.currentPage + by;
        if (0 <= newPage && newPage < this.book.getNumberOfPages())
        {
            this.currentPage = newPage;
            this.repaint();
        }
    }

    private Book book;

    private int  currentPage;
}
