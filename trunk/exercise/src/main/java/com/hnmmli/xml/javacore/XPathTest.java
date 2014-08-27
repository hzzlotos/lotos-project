package com.hnmmli.xml.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This program evaluates XPath expressions
 * 
 * @version 1.01 2007-06-25
 * @author Cay Horstmann
 */
public class XPathTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new XPathFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame shows an XML document, a panel to type an XPath expression, and a text field to
 * display the result.
 */
class XPathFrame extends JFrame
{
    public XPathFrame()
    {
        this.setTitle("XPathTest");

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                XPathFrame.this.openFile();
            }
        });
        fileMenu.add(openItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                XPathFrame.this.evaluate();
            }
        };
        this.expression = new JTextField(20);
        this.expression.addActionListener(listener);
        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.addActionListener(listener);

        this.typeCombo = new JComboBox(new Object[] { "STRING", "NODE", "NODESET", "NUMBER", "BOOLEAN" });
        this.typeCombo.setSelectedItem("STRING");

        JPanel panel = new JPanel();
        panel.add(this.expression);
        panel.add(this.typeCombo);
        panel.add(evaluateButton);
        this.docText = new JTextArea(10, 40);
        this.result = new JTextField();
        this.result.setBorder(new TitledBorder("Result"));

        this.add(panel, BorderLayout.NORTH);
        this.add(new JScrollPane(this.docText), BorderLayout.CENTER);
        this.add(this.result, BorderLayout.SOUTH);

        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            this.builder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }

        XPathFactory xpfactory = XPathFactory.newInstance();
        this.path = xpfactory.newXPath();
        this.pack();
    }

    /**
     * Open a file and load the document.
     */
    public void openFile()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f)
            {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
            }

            @Override
            public String getDescription()
            {
                return "XML files";
            }
        });
        int r = chooser.showOpenDialog(this);
        if (r != JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        File f = chooser.getSelectedFile();
        try
        {
            byte[] bytes = new byte[(int) f.length()];
            new FileInputStream(f).read(bytes);
            this.docText.setText(new String(bytes));
            this.doc = this.builder.parse(f);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch (SAXException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void evaluate()
    {
        try
        {
            String typeName = (String) this.typeCombo.getSelectedItem();
            QName returnType = (QName) XPathConstants.class.getField(typeName).get(null);
            Object evalResult = this.path.evaluate(this.expression.getText(), this.doc, returnType);
            if (typeName.equals("NODESET"))
            {
                NodeList list = (NodeList) evalResult;
                StringBuilder builder = new StringBuilder();
                builder.append("{");
                for (int i = 0; i < list.getLength(); i++)
                {
                    if (i > 0)
                    {
                        builder.append(", ");
                    }
                    builder.append("" + list.item(i));
                }
                builder.append("}");
                this.result.setText("" + builder);
            }
            else
            {
                this.result.setText("" + evalResult);
            }
        }
        catch (XPathExpressionException e)
        {
            this.result.setText("" + e);
        }
        catch (Exception e) // reflection exception
        {
            e.printStackTrace();
        }
    }

    private DocumentBuilder builder;

    private Document        doc;

    private XPath           path;

    private JTextField      expression;

    private JTextField      result;

    private JTextArea       docText;

    private JComboBox       typeCombo;
}