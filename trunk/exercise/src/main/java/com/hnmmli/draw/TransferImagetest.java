package com.hnmmli.draw;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TransferImagetest implements Transferable
{
    private Image theImage;

    public TransferImagetest(Image image)
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
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
    {
        if (flavor.equals(DataFlavor.imageFlavor))
        {
            return this.theImage;
        }
        return null;
    }

    public static void main(String[] args)
    {
        setToClip();
        getByClip();
    }

    public static void setToClip()
    {
        try
        {
            Image image = ImageIO.read(new File("g:/ce8wbQXWT9qI.jpg"));
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            TransferImagetest selection = new TransferImagetest(image);
            clipboard.setContents(selection, null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void getByClip()
    {
        try
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor flavor = DataFlavor.imageFlavor;
            if (clipboard.isDataFlavorAvailable(flavor))
            {
                BufferedImage image = (BufferedImage) clipboard.getData(flavor);
                ImageIO.write(image, "jpg", new File("g:/cliptest.jpg"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}