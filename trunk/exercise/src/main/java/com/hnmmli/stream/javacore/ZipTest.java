package com.hnmmli.stream.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class ZipTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                ZipTestFrame frame = new ZipTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ZipTestFrame extends JFrame
{
    public static final int DEFAULT_HEIGHT = 300;

    public static final int DEFAULT_WIDTH  = 400;

    private JComboBox       fileCombo;

    private JTextArea       fileText;

    private String          zipname;

    public ZipTestFrame()
    {
        this.setTitle("ZipTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 创建目录
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        // 创建目录选项
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
                int r = chooser.showOpenDialog(ZipTestFrame.this);
                if (r == JFileChooser.APPROVE_OPTION)
                {
                    ZipTestFrame.this.zipname = chooser.getSelectedFile().getPath();
                    ZipTestFrame.this.fileCombo.removeAllItems();
                    ZipTestFrame.this.scanZipFile();
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // 添加显示区域以及下拉框
        this.fileText = new JTextArea();
        this.fileCombo = new JComboBox();
        this.fileCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ZipTestFrame.this.loadZipFile((String) ZipTestFrame.this.fileCombo.getSelectedItem());
            }
        });

        this.add(this.fileCombo, BorderLayout.SOUTH);
        this.add(new JScrollPane(this.fileText), BorderLayout.CENTER);
    }

    public void loadZipFile(final String name)
    {
        this.fileCombo.setEnabled(false);
        this.fileText.setText("");
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception
            {
                try
                {
                    ZipInputStream zin = new ZipInputStream(new FileInputStream(ZipTestFrame.this.zipname));
                    ZipEntry entry;
                    while ((entry = zin.getNextEntry()) != null)
                    {
                        if (entry.getName().equals(name))
                        {
                            Scanner in = new Scanner(zin);
                            while (in.hasNextLine())
                            {
                                ZipTestFrame.this.fileText.append(in.nextLine());
                                ZipTestFrame.this.fileText.append("\n");
                            }
                        }
                        zin.closeEntry();
                    }
                    zin.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done()
            {
                ZipTestFrame.this.fileCombo.setEnabled(true);
            }
        }.execute();
    }

    public void scanZipFile()
    {
        new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception
            {
                ZipInputStream zin = new ZipInputStream(new FileInputStream(ZipTestFrame.this.zipname));
                ZipEntry entry;
                while ((entry = zin.getNextEntry()) != null)
                {
                    this.publish(entry.getName());
                    zin.closeEntry();
                }
                zin.close();
                return null;
            }

            @Override
            protected void process(List<String> names)
            {
                for (String name : names)
                {
                    ZipTestFrame.this.fileCombo.addItem(name);
                }
            }
        }.execute();
    }
}