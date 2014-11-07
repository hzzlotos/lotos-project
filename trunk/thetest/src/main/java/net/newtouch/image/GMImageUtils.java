package net.newtouch.image;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.im4java.core.GMOperation;
import org.im4java.core.GraphicsMagickCmd;
import org.im4java.process.Pipe;

public class GMImageUtils
{
    public static void main(String[] arge)
    {
        try
        {
            // cropImageCenter("g:/DSC_0287.JPG", "g:/DSC_0287-123-123.JPG", 100, 100);

            FileInputStream in = new FileInputStream("g:/DSC_0287.JPG");
            byte[] bs = new byte[in.available()];
            in.read(bs);
            in.close();
            cropImageCenter(bs, 100, 100);
            // testPipe();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void cropImageCenter(String srcPath, String desPath, int rectw, int recth) throws Exception
    {
        GMOperation op = new GMOperation();
        GraphicsMagickCmd cmd = new GraphicsMagickCmd("convert");
        op.resize(rectw, recth);
        op.addImage(srcPath);
        op.addImage(desPath);
        cmd.run(op);
    }

    public static byte[] cropImageCenter(byte[] src, int rectw, int recth) throws Exception
    {
        GMOperation op = new GMOperation();
        op.resize(rectw, recth, '!');
        op.addImage("-");
        op.addImage("jpg:-");
        // Pipe pipeIn = new Pipe(new ByteArrayInputStream(src), null);
        Pipe pipeIn = new Pipe(new FileInputStream("g:/DSC_0287.JPG"), null);
        FileOutputStream out = new FileOutputStream("g:/DSC_0287-123-123.JPG");
        Pipe pipeOut = new Pipe(null, out);
        GraphicsMagickCmd cmd = new GraphicsMagickCmd("convert");
        cmd.setInputProvider(pipeIn);
        cmd.setOutputConsumer(pipeOut);

        cmd.run(op);
        return null;
    }
}