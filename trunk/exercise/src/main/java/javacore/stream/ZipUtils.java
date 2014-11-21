package javacore.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{

    /**
     * 功能描述：压缩文件对象
     * 
     * @param zipFileName 压缩文件名(带有路径)
     * @param inputFile 文件对象
     * @return
     * @throws Exception
     */
    public static void zip(String zipFileName, String inputFile) throws Exception
    {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, new File(inputFile), "");
        out.close();
    }

    /**
     * 
     * @param out 压缩输出流对象
     * @param file
     * @param base
     * @throws Exception
     */
    public static void zip(ZipOutputStream outputStream, File file, String base) throws Exception
    {
        System.out.println("---------------------" + file.getName());
        if (file.isDirectory())
        {
            File[] fl = file.listFiles();
            outputStream.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (File element : fl)
            {
                zip(outputStream, element, base + element.getName());
            }
        }
        else
        {
            outputStream.putNextEntry(new ZipEntry(base));
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bs = new byte[inputStream.available()];
            inputStream.read(bs);
            outputStream.write(bs);
            inputStream.close();
        }
    }

    /**
     * 功能描述：将压缩文件解压到指定的文件目录下
     * 
     * @param zipFileName 压缩文件名称(带路径)
     * @param outputDirectory 指定解压目录
     * @return
     * @throws Exception
     */
    public static void unzip(String zipFileName, String outputDirectory) throws Exception
    {
        ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName));
        unzip(inputStream, outputDirectory);
        inputStream.close();
    }

    public static void unzip(ZipInputStream inputStream, String outputDirectory) throws Exception
    {
        ZipEntry zipEntry = null;
        FileOutputStream outputStream = null;
        try
        {
            while ((zipEntry = inputStream.getNextEntry()) != null)
            {
                System.out.println("================" + zipEntry.getName());
                if (zipEntry.isDirectory())
                {
                    String name = zipEntry.getName();
                    name = name.substring(0, name.length() - 1);
                    File file = new File(outputDirectory + File.separator + name);
                    file.mkdir();
                }
                else
                {
                    File file = new File(outputDirectory + File.separator + zipEntry.getName());
                    file.createNewFile();
                    outputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int bytesRead = 0;
                    while ((bytesRead = inputStream.read(buffer)) > 0)
                    {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                }
            }
            inputStream.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
    }

    public static void main(String[] args)
    {
        try
        {
            zip("F:\\zipTest\\test.zip", "F:\\docs\\张家港");
            System.out.println("success");
            unzip("F:\\zipTest\\test.zip", "F:\\zipTest\\unzip");
            System.out.println("success");
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
}