package com.drcl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtil
{
    public static final String PACKAGE_HEAD = "\\paper_"; // 试卷头部名称

    /**
     * 将指定目录、文件压缩
     * 
     * @param basePath
     * @param zipname
     * @throws Exception
     */
    public static void zipFile(String basePath, String zipname)
    throws Exception
    {
        zipFile(new File(basePath), zipname);
    }

    /**
     * 将指定目录、文件压缩，无主目录
     * 
     * @param basePath
     * @param zipname
     * @throws Exception
     */
    public static void zipFileNoBaseFolder(String basePath, String zipname)
    throws Exception
    {
        File base = new File(basePath);
        if (base.isDirectory())
        {
            File[] files = base.listFiles();
            List<File> listFiles = new LinkedList<File>();
            for (File file : files)
            {
                listFiles.add(file);
            }
            zipFile(listFiles, zipname);
        }
    }

    /**
     * 将指定目录、文件压缩
     * 
     * @param basePath
     * @param zipname
     * @throws Exception
     */
    public static void zipFile(File zipFile, String zipname) throws Exception
    {
        List<File> list = new ArrayList<File>();
        list.add(zipFile);
        zipFile(list, zipname);
    }

    /**
     * 将指定多个目录、文件压缩
     * 
     * @param basePath
     * @param zipname
     * @throws Exception
     */
    public static void zipFile(List<File> zipFiles, String zipname)
    throws Exception
    {
        ZipEntry ze = null;
        byte[] buffer = new byte[1024];
        int readLen = 0;
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipname));
        for (File f : zipFiles)
        {
            for (File file : getFiles(f))
            {
                ze = new ZipEntry(getRelativePath(file, f));
                ze.setSize(file.length());
                ze.setTime(file.lastModified());
                zos.putNextEntry(ze);
                InputStream in = new BufferedInputStream(new FileInputStream(
                        file));
                while ((readLen = in.read(buffer, 0, 1024)) != -1)
                {
                    zos.write(buffer, 0, readLen);
                }
                in.close();
            }
        }
        zos.close();
    }

    /**
     * 解压
     * 
     * @param parentPath
     * @param file
     * @throws Exception
     */
    public static void unZipFlie(String parentPath, String file)
    throws Exception
    {
        unZipFlie(parentPath, new File(file));
    }

    /**
     * 解压
     * 
     * @author mlv
     * @param parentPath
     * @param parent
     * @throws Exception
     */
    public static void unZipFlie(String parentPath, File upload)
    throws Exception
    {
        File parent = new File(parentPath);
        if (!parent.exists() && !parent.mkdirs())
        {
            throw new IOException();
        }

        ZipInputStream zis = new ZipInputStream(new FileInputStream(upload));
        ZipEntry ze = null;

        while ((ze = zis.getNextEntry()) != null)
        {
            if (ze.isDirectory())
            {
                File dir = new File(parentPath + "/" + ze.getName());
                dir.mkdirs();
                continue;
            }
            String name = ze.getName();
            File child = new File(parent, name);
            mkParent(child.getParentFile());
            FileOutputStream output = new FileOutputStream(child);
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = zis.read(buffer)) > 0)
            {
                output.write(buffer, 0, bytesRead);
            }
            output.flush();
            output.close();
        }
        zis.close();

    }

    /**
     * 保存文件
     * 
     * @param namePath
     * @param upload
     * @throws IOException
     * @author qingang
     * @since 2012-03-27修改
     */
    public static void saveFile(String namePath, File upload)
    throws IOException
    {

        FileOutputStream output = new FileOutputStream(new File(namePath));
        FileInputStream input = new FileInputStream(upload);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = input.read(buffer)) > 0)
        {
            output.write(buffer, 0, bytesRead);
        }
        output.flush();
        output.close();
        input.close();
    }

    /**
     * 解压时，生成上级目录
     * 
     * @author mlv
     * @param parent
     */
    public static void mkParent(File parent)
    {
        if (!parent.exists())
        {
            if (!parent.getParentFile().exists())
            {
                mkParent(parent.getParentFile());
            }
            parent.mkdir();
        }
    }

    public static List<File> getFiles(File fileDir)
    {
        List<File> listFiles = new LinkedList<File>();
        // 判断给定的fileDir是否为文件，如果是则直接返回
        if (fileDir.isFile())
        {
            listFiles.add(fileDir);
            return listFiles;
        }
        // 如果是目录则遍历该目录
        File[] files = fileDir.listFiles();
        for (File file : files)
        {
            if (file.isFile())
            {
                listFiles.add(file);
            }
            else
            {
                // 对方法进行递归调用
                listFiles.addAll(getFiles(file));
            }
        }
        return listFiles;
    }

    /**
     * 给定根目录，返回另一个文件名的相对路径，用于zip文件中的路径
     * 
     * @param file
     * @param baseDir
     * @return
     */
    private static String getRelativePath(File file, File base)
    {
        String filename = file.getName();
        while (true)
        {
            if (file.equals(base))
            {
                break;
            }
            file = file.getParentFile();
            if (file == null)
            {
                break;
            }

            filename = file.getName() + "/" + filename;
        }
        return filename;
    }

    /**
     * 复制单个文件
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf.txt
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     */
    public static void copyFile(String oldPath, String newPath)
    {
        try
        {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists())
            {
                // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                mkParent(new File(newPath).getParentFile());
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1)
                {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
            System.out.println("删除文件夹操作 成功执行");
        }
        catch (Exception e)
        {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 复制整个文件夹内容
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf
     * @param newPath
     *            String 复制后路径 如：f:/fqf/ff
     */
    public static void copyFolder(String oldPath, String newPath)
    {
        try
        {
            (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (String element : file)
            {
                if (oldPath.endsWith(File.separator))
                {
                    temp = new File(oldPath + element);
                }
                else
                {
                    temp = new File(oldPath + File.separator + element);
                }
                if (temp.isFile())
                {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath
                            + "/" + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1)
                    {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory())
                {
                    // 如果是子文件夹
                    copyFolder(oldPath + "/" + element, newPath + "/" + element);
                }
            }
            System.out.println("复制文件夹操作 成功执行");
        }
        catch (Exception e)
        {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception
    {
        // zipFileNoBaseFolder("E:/index", "e:/a.zip");
        //copyFile("D:\\课件\\052.wmv", "e:\\052.wmv");
        // unZipFlie("e:/b","e:/a.zip");
        // unZipFlie("e:/c/","e:/b.zip");
        System.err.println("-------"+System.currentTimeMillis());

    }
}
