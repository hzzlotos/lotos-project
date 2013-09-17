package cn.newtouch.Topic.ffmpeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MediocreExecJavac
{
    /**
     * 取得时长
     * 
     * @param command
     * @return
     */
    public static String runLenCmd(String file, String command)
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            System.out.println("command" + command);
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            // System.out.println("<ERROR>");
            String len = "";
            while ((line = br.readLine()) != null)
            {
                if (line.trim().startsWith("Duration"))
                {
                    len = line.substring(12, line.indexOf(","));
                    len = len.indexOf(".") > 0 ? len.substring(0, len
                            .indexOf(".")) : len;
                }
            }
            // System.out.println("</ERROR>");
            proc.waitFor();
            // System.out.println("Process exitValue: " + exitVal);
            return len;
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        return "0";
    }

    // 读时长信息
    public static String readtime(String file)
    {
        String timelen = "";
        String cmd = "D:\\ffmpeg\\bin\\ffmpeg -i " + file;
        timelen = runLenCmd(file, cmd);
        return timelen;
    }

    /**
     * 
     * 视频截图
     * 
     * @param ffmpegpath
     *            ffmpeg.exe的目录
     * @param inputFilePath
     *            需截图的视频文件全路径（含文件名）
     * @param outFilePath
     *            截出图片存储路径
     * @param outFileName
     *            截出图片名
     * @param imageFormat
     *            截出图片格式（.jpg、.gif等）
     * @param screenTime
     *            截出图片视频定位时间（单位：秒）
     * @param sense
     *            截出图片分辨率（如：210x120）
     * @return 截出图片全路径
     */
    public static String processImg(String ffmpegpath, String inputFilePath,
            String outFilePath, String outFileName, String imageFormat,
            int screenTime, String sense)
    {

        List<String> commend = new ArrayList<String>();
        commend.add(ffmpegpath);
        commend.add("-i");
        commend.add(inputFilePath);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add(String.valueOf(screenTime));
        commend.add("-t");
        commend.add("0.001");
        commend.add("-s");
        commend.add(sense);
        commend.add(outFilePath + outFileName + imageFormat);

        try
        {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return outFileName + imageFormat;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // 运行命令
    public java.io.OutputStream runCmd(String command)
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            System.out.println("command" + command);
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
            {
                if (line.trim().startsWith("Duration"))
                {
                    System.out.println("00-"
                            + line.substring(8, line.indexOf(",")));
                }
                System.out.println("dsf--" + line);
            }
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
            return proc.getOutputStream();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        return null;
    }

    // 视频转码，infile输入文件(包括完整路径)，outfile输出文件
    public boolean transfer(String infile, String outfile)
    {
        String avitoflv = "D:\\ffmpeg\\bin\\ffmpeg -i " + infile
                + " -ar 22050 -ab 56 -f flv -y -s 320x240 " + outfile;
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(avitoflv);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
            return false;
        }
        return true;
    }

    // 读取文件,fileName输入文件，id行数
    public static String readFile(String fileName, int id)
    {
        String dataStr = "";
        FileInputStream fis = null;
        try
        {
            FileReader file = new FileReader(fileName);// 建立FileReader对象，并实例化为fr
            BufferedReader br = new BufferedReader(file);// 建立BufferedReader对象，并实例化为br
            String Line = br.readLine();// 从文件读取一行字符串
            dataStr = Line;
            br.close();// 关闭BufferedReader对象
        }
        catch (Exception e)
        {
        }
        finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            }
            catch (Exception e)
            {
            }
        }
        return dataStr;
    }

    /**
     * 递归处理目录
     * 
     * @param me
     * @param pathFile
     */
    private void handlePath(MediocreExecJavac me, String parentPath,
            File pathFile, String outFile)
    {

        // 遍历目录的视频文件,支持flv，wmv，
        for (File tmpfile : pathFile.listFiles())
        {
            // 时长
            if (tmpfile.isDirectory())
            {
                handlePath(me, parentPath, tmpfile, outFile);
            }
            else
            {
                String timelen = me.readtime(tmpfile.getAbsolutePath());
                String rpath = tmpfile.getAbsolutePath();
                rpath = rpath.substring(rpath.indexOf(parentPath)
                        + parentPath.length() + 1);
                writeFile(outFile, rpath + "," + timelen);
                System.out.println(rpath + " timelen is :" + timelen);
            }
        }
        return;
    }

    private void writeFile(String outFile, String linemsg)
    {
        FileWriter bufferedOutput = null;

        try
        {
            bufferedOutput = new FileWriter(outFile, true);
            bufferedOutput.write(linemsg);
            bufferedOutput.write("\n");
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            try
            {
                bufferedOutput.close();
            }
            catch (Exception e)
            {
                // TODO: handle exception
            }
        }

    }

    public static void main(String args[])
    {
        String filepath = "D:\\ffmpeg\\flv\\ccjj.flv";
        System.out.println(MediocreExecJavac.readtime(filepath));

        System.out.println("=====================================");
        System.out.println(MediocreExecJavac.processImg(
                "D:\\ffmpeg\\bin\\ffmpeg", "D:\\ffmpeg\\flv\\ccjj.flv",
                "D:\\ffmpeg\\output\\", "priName", ".jpg", 5, "210x120"));
    }
}