package javacore.draw.javacore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This program demonstrates the transfer of serialized objects between virtual machines.
 * 
 * @version 1.02 2007-08-16
 * @author Cay Horstmann
 */
public class SerialTransferTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new SerialTransferFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains a color chooser, and copy and paste buttons.
 */
class SerialTransferFrame extends JFrame
{
    public SerialTransferFrame()
    {
        this.setTitle("SerialTransferTest");

        this.chooser = new JColorChooser();
        this.add(this.chooser, BorderLayout.CENTER);
        JPanel panel = new JPanel();

        JButton copyButton = new JButton("Copy");
        panel.add(copyButton);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                SerialTransferFrame.this.copy();
            }
        });

        JButton pasteButton = new JButton("Paste");
        panel.add(pasteButton);
        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                SerialTransferFrame.this.paste();
            }
        });

        this.add(panel, BorderLayout.SOUTH);
        this.pack();
    }

    /**
     * Copies the chooser's color into the system clipboard.
     */
    private void copy()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Color color = this.chooser.getColor();
        SerialTransferable selection = new SerialTransferable(color);
        clipboard.setContents(selection, null);
    }

    /**
     * Pastes the color from the system clipboard into the chooser.
     */
    private void paste()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try
        {
            DataFlavor flavor = new DataFlavor("application/x-java-serialized-object;class=java.awt.Color");
            if (clipboard.isDataFlavorAvailable(flavor))
            {
                Color color = (Color) clipboard.getData(flavor);
                this.chooser.setColor(color);
            }
        }
        catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(this, e);
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

    private JColorChooser chooser;
}

/**
 * This class is a wrapper for the data transfer of serialized objects.
 */
class SerialTransferable implements Transferable
{
    /**
     * Constructs the selection.
     * 
     * @param o any serializable object
     */
    SerialTransferable(Serializable o)
    {
        this.obj = o;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors()
    {
        DataFlavor[] flavors = new DataFlavor[2];
        Class<?> type = this.obj.getClass();
        String mimeType = "application/x-java-serialized-object;class=" + type.getName();
        try
        {
            flavors[0] = new DataFlavor(mimeType);
            flavors[1] = DataFlavor.stringFlavor;
            return flavors;
        }
        catch (ClassNotFoundException e)
        {
            return new DataFlavor[0];
        }
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return DataFlavor.stringFlavor.equals(flavor) || "application".equals(flavor.getPrimaryType())
                && "x-java-serialized-object".equals(flavor.getSubType())
                && flavor.getRepresentationClass().isAssignableFrom(this.obj.getClass());
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
    {
        if (!this.isDataFlavorSupported(flavor))
        {
            throw new UnsupportedFlavorException(flavor);
        }

        if (DataFlavor.stringFlavor.equals(flavor))
        {
            return this.obj.toString();
        }

        return this.obj;
    }

    private Serializable obj;
}
