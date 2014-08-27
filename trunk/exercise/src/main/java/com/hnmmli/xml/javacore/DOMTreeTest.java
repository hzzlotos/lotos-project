package com.hnmmli.xml.javacore;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * This program displays an XML document as a tree.
 */
public class DOMTreeTest
{
    public static void main(String[] args)
    {
        JFrame frame = new DOMTreeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * This frame contains a tree that displays the contents of
 * an XML document.
 */
class DOMTreeFrame extends JFrame
{
    public DOMTreeFrame()
    {
        this.setTitle("DOMTreeTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                DOMTreeFrame.this.openFile();
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
            if (this.builder == null)
            {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                this.builder = factory.newDocumentBuilder();
            }

            Document doc = this.builder.parse(f);
            JTree tree = new JTree(new DOMTreeModel(doc));
            tree.setCellRenderer(new DOMTreeCellRenderer());

            this.setContentPane(new JScrollPane(tree));
            this.validate();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch (ParserConfigurationException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch (SAXException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private DocumentBuilder  builder;

    private static final int DEFAULT_WIDTH  = 400;

    private static final int DEFAULT_HEIGHT = 400;
}

/**
 * This tree model describes the tree structure of an XML document.
 */
class DOMTreeModel implements TreeModel
{
    /**
     * Constructs a document tree model.
     * 
     * @param doc the document
     */
    public DOMTreeModel(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public Object getRoot()
    {
        return this.doc.getDocumentElement();
    }

    @Override
    public int getChildCount(Object parent)
    {
        Node node = (Node) parent;
        NodeList list = node.getChildNodes();
        return list.getLength();
    }

    @Override
    public Object getChild(Object parent, int index)
    {
        Node node = (Node) parent;
        NodeList list = node.getChildNodes();
        return list.item(index);
    }

    @Override
    public int getIndexOfChild(Object parent, Object child)
    {
        Node node = (Node) parent;
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++)
        {
            if (this.getChild(node, i) == child)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLeaf(Object node)
    {
        return this.getChildCount(node) == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue)
    {
    }

    @Override
    public void addTreeModelListener(TreeModelListener l)
    {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l)
    {
    }

    private Document doc;
}

/**
 * This class renders an XML node.
 */
class DOMTreeCellRenderer extends DefaultTreeCellRenderer
{
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus)
    {
        Node node = (Node) value;
        if (node instanceof Element)
        {
            return elementPanel((Element) node);
        }

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        if (node instanceof CharacterData)
        {
            this.setText(characterString((CharacterData) node));
        }
        else
        {
            this.setText(node.getClass() + ": " + node.toString());
        }
        return this;
    }

    public static JPanel elementPanel(Element e)
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Element: " + e.getTagName()));
        panel.add(new JTable(new AttributeTableModel(e.getAttributes())));
        return panel;
    }

    public static String characterString(CharacterData node)
    {
        StringBuilder builder = new StringBuilder(node.getData());
        for (int i = 0; i < builder.length(); i++)
        {
            if (builder.charAt(i) == '\r')
            {
                builder.replace(i, i + 1, "\\r");
                i++;
            }
            else
                if (builder.charAt(i) == '\n')
                {
                    builder.replace(i, i + 1, "\\n");
                    i++;
                }
                else
                    if (builder.charAt(i) == '\t')
                    {
                        builder.replace(i, i + 1, "\\t");
                        i++;
                    }
        }
        if (node instanceof CDATASection)
        {
            builder.insert(0, "CDATASection: ");
        }
        else
            if (node instanceof Text)
            {
                builder.insert(0, "Text: ");
            }
            else
                if (node instanceof Comment)
                {
                    builder.insert(0, "Comment: ");
                }

        return builder.toString();
    }
}

/**
 * This table model describes the attributes of an XML element.
 */
class AttributeTableModel extends AbstractTableModel
{
    /**
     * Constructs an attribute table model.
     * 
     * @param map the named node map
     */
    public AttributeTableModel(NamedNodeMap map)
    {
        this.map = map;
    }

    @Override
    public int getRowCount()
    {
        return this.map.getLength();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c)
    {
        return c == 0 ? this.map.item(r).getNodeName() : this.map.item(r).getNodeValue();
    }

    private NamedNodeMap map;
}
