package com.hnmmli.draw.javacore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This program demonstrates the transfer of images between a Java application and the system
 * clipboard.
 * 
 * @version 1.22 2007-08-16
 * @author Cay Horstmann
 */
public class ImageTransferTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new ImageTransferFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame has an image label and buttons for copying and pasting an image.
 */
class ImageTransferFrame extends JFrame
{
    public ImageTransferFrame()
    {
        this.setTitle("ImageTransferTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.label = new JLabel();
        this.image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g.setColor(Color.RED);
        g.fillOval(DEFAULT_WIDTH / 4, DEFAULT_WIDTH / 4, DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2);

        this.label.setIcon(new ImageIcon(this.image));
        this.add(new JScrollPane(this.label), BorderLayout.CENTER);
        JPanel panel = new JPanel();

        JButton copyButton = new JButton("Copy");
        panel.add(copyButton);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ImageTransferFrame.this.copy();
            }
        });

        JButton pasteButton = new JButton("Paste");
        panel.add(pasteButton);
        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ImageTransferFrame.this.paste();
            }
        });

        this.add(panel, BorderLayout.SOUTH);
    }

    /**
     * Copies the current image to the system clipboard.
     */
    private void copy()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ImageTransferable1 selection = new ImageTransferable1(this.image);
        clipboard.setContents(selection, null);
    }

    /**
     * Pastes the image from the system clipboard into the image label.
     */
    private void paste()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.imageFlavor;
        if (clipboard.isDataFlavorAvailable(flavor))
        {
            try
            {
                this.image = (Image) clipboard.getData(flavor);
                this.label.setIcon(new ImageIcon(this.image));
            }
            catch (UnsupportedFlavorException exception)
            {
                JOptionPane.showMessageDialog(this, exception);
            }
            catch (IOException exception)
            {
                JOptionPane.showMessageDialog(this, exception);
            }
        }
    }

    private JLabel           label;

    private Image            image;

    private static final int DEFAULT_WIDTH  = 300;

    private static final int DEFAULT_HEIGHT = 300;
}

/**
 * This class is a wrapper for the data transfer of image objects.
 */
class ImageTransferable1 implements Transferable
{
    /**
     * Constructs the selection.
     * 
     * @param image an image
     */
    public ImageTransferable1(Image image)
    {
        this.theImage = image;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors()
    {
        return new DataFlavor[] { DataFlavor.imageFlavor };
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
    {
        if (flavor.equals(DataFlavor.imageFlavor))
        {
            return this.theImage;
        }
        else
        {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    private Image theImage;
}
