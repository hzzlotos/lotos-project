package com.hnmmli.draw.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This program demonstrates the transfer of text between a Java application and the system
 * clipboard.
 * 
 * @version 1.13 2007-08-16
 * @author Cay Horstmann
 */
public class TextTransferTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new TextTransferFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame has a text area and buttons for copying and pasting text.
 */
class TextTransferFrame extends JFrame
{
    public TextTransferFrame()
    {
        this.setTitle("TextTransferTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.textArea = new JTextArea();
        this.add(new JScrollPane(this.textArea), BorderLayout.CENTER);
        JPanel panel = new JPanel();

        JButton copyButton = new JButton("Copy");
        panel.add(copyButton);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                TextTransferFrame.this.copy();
            }
        });

        JButton pasteButton = new JButton("Paste");
        panel.add(pasteButton);
        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                TextTransferFrame.this.paste();
            }
        });

        this.add(panel, BorderLayout.SOUTH);
    }

    /**
     * Copies the selected text to the system clipboard.
     */
    private void copy()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = this.textArea.getSelectedText();
        if (text == null)
        {
            text = this.textArea.getText();
        }
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    /**
     * Pastes the text from the system clipboard into the text area.
     */
    private void paste()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor))
        {
            try
            {
                String text = (String) clipboard.getData(flavor);
                this.textArea.replaceSelection(text);
            }
            catch (UnsupportedFlavorException e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }

    private JTextArea        textArea;

    private static final int DEFAULT_WIDTH  = 300;

    private static final int DEFAULT_HEIGHT = 300;
}
