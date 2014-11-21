package javacore.xml.javacore;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This program shows how to use an XML file to describe a gridbag layout
 * 
 * @version 1.01 2007-06-25
 * @author Cay Horstmann
 */
public class GridBagTest
{
    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                String filename = GridBagTest.class.getClassLoader().getResource("").getPath()
                        + "/javacore/fontdialog.xml";
                JFrame frame = new FontFrame(filename);
                frame.setBounds(100, 100, 700, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains a font selection dialog that is described by an XML file.
 * 
 * @param filename the file containing the user interface components for the dialog.
 */
class FontFrame extends JFrame
{
    public FontFrame(String filename)
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setTitle("GridBagTest");

        this.gridbag = new GridBagPane(filename);
        this.add(this.gridbag);

        this.face = (JComboBox) this.gridbag.get("face");
        this.size = (JComboBox) this.gridbag.get("size");
        this.bold = (JCheckBox) this.gridbag.get("bold");
        this.italic = (JCheckBox) this.gridbag.get("italic");

        this.face.setModel(new DefaultComboBoxModel(new Object[] { "Serif", "SansSerif", "Monospaced", "Dialog",
                "DialogInput" }));

        this.size.setModel(new DefaultComboBoxModel(new Object[] { "8", "10", "12", "15", "18", "24", "36", "48" }));

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                FontFrame.this.setSample();
            }
        };

        this.face.addActionListener(listener);
        this.size.addActionListener(listener);
        this.bold.addActionListener(listener);
        this.italic.addActionListener(listener);

        this.setSample();
    }

    /**
     * This method sets the text sample to the selected font.
     */
    public void setSample()
    {
        String fontFace = (String) this.face.getSelectedItem();
        int fontSize = Integer.parseInt((String) this.size.getSelectedItem());
        JTextArea sample = (JTextArea) this.gridbag.get("sample");
        int fontStyle = (this.bold.isSelected() ? Font.BOLD : 0) + (this.italic.isSelected() ? Font.ITALIC : 0);

        sample.setFont(new Font(fontFace, fontStyle, fontSize));
        sample.repaint();
    }

    private GridBagPane      gridbag;

    private JComboBox        face;

    private JComboBox        size;

    private JCheckBox        bold;

    private JCheckBox        italic;

    private static final int DEFAULT_WIDTH  = 400;

    private static final int DEFAULT_HEIGHT = 400;
}