package com.hnmmli.draw.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This program demonstrates the basic Swing support for drag and drop.
 * 
 * @version 1.10 2007-09-20
 * @author Cay Horstmann
 */
public class SwingDnDTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new SwingDnDFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SwingDnDFrame extends JFrame
{
    public SwingDnDFrame()
    {
        this.setTitle("SwingDnDTest");
        JTabbedPane tabbedPane = new JTabbedPane();

        JList list = SampleComponents.list();
        tabbedPane.addTab("List", list);
        JTable table = SampleComponents.table();
        tabbedPane.addTab("Table", table);
        JTree tree = SampleComponents.tree();
        tabbedPane.addTab("Tree", tree);
        JFileChooser fileChooser = new JFileChooser();
        tabbedPane.addTab("File Chooser", fileChooser);
        JColorChooser colorChooser = new JColorChooser();
        tabbedPane.addTab("Color Chooser", colorChooser);

        final JTextArea textArea = new JTextArea(4, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Drag text here"));

        JTextField textField = new JTextField("Drag color here");
        textField.setTransferHandler(new TransferHandler("background"));

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                textArea.setText("");
            }
        });

        tree.setDragEnabled(true);
        table.setDragEnabled(true);
        list.setDragEnabled(true);
        fileChooser.setDragEnabled(true);
        colorChooser.setDragEnabled(true);
        textField.setDragEnabled(true);

        this.add(tabbedPane, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(textField, BorderLayout.SOUTH);
        this.pack();
    }
}
