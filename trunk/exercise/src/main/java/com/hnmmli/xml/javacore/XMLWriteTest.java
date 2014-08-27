package com.hnmmli.xml.javacore;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This program shows how to write an XML file. It saves a file describing a modern drawing in SVG
 * format.
 * 
 * @version 1.10 2004-09-04
 * @author Cay Horstmann
 */
public class XMLWriteTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                XMLWriteFrame frame = new XMLWriteFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * A frame with a component for showing a modern drawing.
 */
class XMLWriteFrame extends JFrame
{
    public XMLWriteFrame()
    {
        this.setTitle("XMLWriteTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.chooser = new JFileChooser();

        // add component to frame

        this.comp = new RectangleComponent();
        this.add(this.comp);

        // set up menu bar

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem newItem = new JMenuItem("New");
        menu.add(newItem);
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                XMLWriteFrame.this.comp.newDrawing();
            }
        });

        JMenuItem saveItem = new JMenuItem("Save with DOM/XSLT");
        menu.add(saveItem);
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    XMLWriteFrame.this.saveDocument();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(XMLWriteFrame.this, e.toString());
                }
            }
        });

        JMenuItem saveStAXItem = new JMenuItem("Save with StAX");
        menu.add(saveStAXItem);
        saveStAXItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    XMLWriteFrame.this.saveStAX();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(XMLWriteFrame.this, e.toString());
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
    }

    /**
     * Saves the drawing in SVG format, using DOM/XSLT
     */
    public void saveDocument() throws TransformerException, IOException
    {
        if (this.chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        File f = this.chooser.getSelectedFile();
        Document doc = this.comp.buildDocument();
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd");
        t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 20000802//EN");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(f)));
    }

    /**
     * Saves the drawing in SVG format, using StAX
     */
    public void saveStAX() throws FileNotFoundException, XMLStreamException
    {
        if (this.chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        File f = this.chooser.getSelectedFile();
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(f));
        this.comp.writeDocument(writer);
        writer.close();
    }

    public static final int    DEFAULT_WIDTH  = 300;

    public static final int    DEFAULT_HEIGHT = 200;

    private RectangleComponent comp;

    private JFileChooser       chooser;
}

/**
 * A component that shows a set of colored rectangles
 */
class RectangleComponent extends JComponent
{
    public RectangleComponent()
    {
        this.rects = new ArrayList<Rectangle2D>();
        this.colors = new ArrayList<Color>();
        this.generator = new Random();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            this.builder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Create a new random drawing.
     */
    public void newDrawing()
    {
        int n = 10 + this.generator.nextInt(20);
        this.rects.clear();
        this.colors.clear();
        for (int i = 1; i <= n; i++)
        {
            int x = this.generator.nextInt(this.getWidth());
            int y = this.generator.nextInt(this.getHeight());
            int width = this.generator.nextInt(this.getWidth() - x);
            int height = this.generator.nextInt(this.getHeight() - y);
            this.rects.add(new Rectangle(x, y, width, height));
            int r = this.generator.nextInt(256);
            int g = this.generator.nextInt(256);
            int b = this.generator.nextInt(256);
            this.colors.add(new Color(r, g, b));
        }
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if (this.rects.size() == 0)
        {
            this.newDrawing();
        }
        Graphics2D g2 = (Graphics2D) g;

        // draw all rectangles
        for (int i = 0; i < this.rects.size(); i++)
        {
            g2.setPaint(this.colors.get(i));
            g2.fill(this.rects.get(i));
        }
    }

    /**
     * Creates an SVG document of the current drawing.
     * 
     * @return the DOM tree of the SVG document
     */
    public Document buildDocument()
    {
        Document doc = this.builder.newDocument();
        Element svgElement = doc.createElement("svg");
        doc.appendChild(svgElement);
        svgElement.setAttribute("width", "" + this.getWidth());
        svgElement.setAttribute("height", "" + this.getHeight());
        for (int i = 0; i < this.rects.size(); i++)
        {
            Color c = this.colors.get(i);
            Rectangle2D r = this.rects.get(i);
            Element rectElement = doc.createElement("rect");
            rectElement.setAttribute("x", "" + r.getX());
            rectElement.setAttribute("y", "" + r.getY());
            rectElement.setAttribute("width", "" + r.getWidth());
            rectElement.setAttribute("height", "" + r.getHeight());
            rectElement.setAttribute("fill", colorToString(c));
            svgElement.appendChild(rectElement);
        }
        return doc;
    }

    /**
     * Writers an SVG document of the current drawing.
     * 
     * @param writer the document destination
     */
    public void writeDocument(XMLStreamWriter writer) throws XMLStreamException
    {
        writer.writeStartDocument();
        writer.writeDTD("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 20000802//EN\" "
                + "\"http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd\">");
        writer.writeStartElement("svg");
        writer.writeAttribute("width", "" + this.getWidth());
        writer.writeAttribute("height", "" + this.getHeight());
        for (int i = 0; i < this.rects.size(); i++)
        {
            Color c = this.colors.get(i);
            Rectangle2D r = this.rects.get(i);
            writer.writeEmptyElement("rect");
            writer.writeAttribute("x", "" + r.getX());
            writer.writeAttribute("y", "" + r.getY());
            writer.writeAttribute("width", "" + r.getWidth());
            writer.writeAttribute("height", "" + r.getHeight());
            writer.writeAttribute("fill", colorToString(c));
        }
        writer.writeEndDocument(); // closes svg element
    }

    /**
     * Converts a color to a hex value.
     * 
     * @param c a color
     * @return a string of the form #rrggbb
     */
    private static String colorToString(Color c)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Integer.toHexString(c.getRGB() & 0xFFFFFF));
        while (buffer.length() < 6)
        {
            buffer.insert(0, '0');
        }
        buffer.insert(0, '#');
        return buffer.toString();
    }

    private ArrayList<Rectangle2D> rects;

    private ArrayList<Color>       colors;

    private Random                 generator;

    private DocumentBuilder        builder;
}