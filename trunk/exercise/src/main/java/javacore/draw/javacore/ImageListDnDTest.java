package javacore.draw.javacore;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

/**
 * This program demonstrates drag and drop in an image list.
 * 
 * @version 1.00 2007-09-20
 * @author Cay Horstmann
 */
public class ImageListDnDTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new ImageListDnDFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ImageListDnDFrame extends JFrame
{
    public ImageListDnDFrame()
    {
        this.setTitle("ImageListDnDTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // list1 = new ImageList(new File("images1").listFiles());
        // list2 = new ImageList(new File("images2").listFiles());
        this.list1 = new ImageList(new File(ImageListDnDTest.class.getClassLoader().getResource("").getPath()
                + "/images1").listFiles());
        this.list2 = new ImageList(new File(ImageListDnDTest.class.getClassLoader().getResource("").getPath()
                + "images2").listFiles());
        this.setLayout(new GridLayout(2, 1));
        this.add(new JScrollPane(this.list1));
        this.add(new JScrollPane(this.list2));
    }

    private ImageList        list1;

    private ImageList        list2;

    private static final int DEFAULT_WIDTH  = 600;

    private static final int DEFAULT_HEIGHT = 500;
}

class ImageList extends JList
{
    public ImageList(File[] imageFiles)
    {
        DefaultListModel model = new DefaultListModel();
        for (File f : imageFiles)
        {
            model.addElement(new ImageIcon(f.getPath()));
        }

        this.setModel(model);
        this.setVisibleRowCount(0);
        this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.setDragEnabled(true);
        this.setDropMode(DropMode.ON_OR_INSERT);
        this.setTransferHandler(new ImageListTransferHandler());
    }
}

class ImageListTransferHandler extends TransferHandler
{
    // Support for drag
    // 返回源支持的传输动作的类型；COPY、MOVE 和 LINK 的任意按位或组合。
    @Override
    public int getSourceActions(JComponent source)
    {
        System.out.println("111111111111");
        return COPY_OR_MOVE;
    }

    // 创建一个要用作数据传输源的 Transferable。
    @Override
    protected Transferable createTransferable(JComponent source)
    {
        System.out.println("222222222222");
        JList list = (JList) source;
        int index = list.getSelectedIndex();
        if (index < 0)
        {
            return null;
        }
        ImageIcon icon = (ImageIcon) list.getModel().getElementAt(index);
        return new ImageTransferable(icon.getImage());
    }

    // 在导出数据之后调用。
    @Override
    protected void exportDone(JComponent source, Transferable data, int action)
    {
        System.out.println("4444444444444444444");
        if (action == MOVE)
        {
            JList list = (JList) source;
            int index = list.getSelectedIndex();
            if (index < 0)
            {
                return;
            }
            DefaultListModel model = (DefaultListModel) list.getModel();
            model.remove(index);
        }
    }

    // 在拖放操作期间重复调用此方法，以允许开发人员配置传输的可接受性属性，并返回传输的可接受性；返回 true 值指示给定 TransferSupport
    // （它包含该传输的所有细节）所表示的传输在当前是可以接受的，false值指示拒绝该传输。
    // Support for drop
    @Override
    public boolean canImport(TransferSupport support)
    {
        System.out.println("33333333333333333");
        if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
        {
            if (support.getUserDropAction() == MOVE)
            {
                support.setDropAction(COPY);
            }
            return true;
        }
        else
        {
            return support.isDataFlavorSupported(DataFlavor.imageFlavor);
        }
    }

    @Override
    public boolean importData(TransferSupport support)
    {
        JList list = (JList) support.getComponent();
        DefaultListModel model = (DefaultListModel) list.getModel();

        Transferable transferable = support.getTransferable();
        List<DataFlavor> flavors = Arrays.asList(transferable.getTransferDataFlavors());

        List<Image> images = new ArrayList<Image>();

        try
        {
            if (flavors.contains(DataFlavor.javaFileListFlavor))
            {
                List<File> fileList = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                for (File f : fileList)
                {
                    try
                    {
                        images.add(ImageIO.read(f));
                    }
                    catch (IOException ex)
                    {
                        // couldn't read image--skip
                    }
                }
            }
            else
                if (flavors.contains(DataFlavor.imageFlavor))
                {
                    images.add((Image) transferable.getTransferData(DataFlavor.imageFlavor));
                }

            int index;
            if (support.isDrop())
            {
                JList.DropLocation location = (JList.DropLocation) support.getDropLocation();
                index = location.getIndex();
                if (!location.isInsert())
                {
                    model.remove(index); // replace location
                }
            }
            else
            {
                index = model.size();
            }
            for (Image image : images)
            {
                model.add(index, new ImageIcon(image));
                index++;
            }
            return true;
        }
        catch (IOException ex)
        {
            return false;
        }
        catch (UnsupportedFlavorException ex)
        {
            return false;
        }
    }
}
