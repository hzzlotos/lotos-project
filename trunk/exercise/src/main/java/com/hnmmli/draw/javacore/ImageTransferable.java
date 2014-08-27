package com.hnmmli.draw.javacore;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 * This class is a wrapper for the data transfer of image objects.
 */
public class ImageTransferable implements Transferable
{
    /**
     * Constructs the selection.
     * 
     * @param image an image
     */
    public ImageTransferable(Image image)
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
