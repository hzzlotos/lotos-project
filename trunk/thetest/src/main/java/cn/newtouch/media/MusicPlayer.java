package cn.newtouch.media;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

//需要添加mp3spi
public class MusicPlayer
{
    public static void play()
    {
        try
        {
            File file = new File("F:\\Music\\Gonna Fly Now - 群星.mp3");

            // 取得文件输入流
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            // 文件格式
            AudioFormat audioFormat = audioInputStream.getFormat();
            // 转换mp3文件编码
            if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED)
            {
                audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16,
                        audioFormat.getChannels(), audioFormat.getChannels() * 2, audioFormat.getSampleRate(), false);
                audioInputStream = AudioSystem.getAudioInputStream(audioFormat, audioInputStream);
            }

            // 打开输出设备
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);
            // 输出设备
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // 读取数据到缓存数据
            int cnt;
            byte tempBuffer[] = new byte[1024];
            while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1)
            {
                if (cnt > 0)
                {
                    // 写入缓存数据
                    sourceDataLine.write(tempBuffer, 0, cnt);
                }
            }
            // Block等待临时数据被输出为空
            sourceDataLine.drain();
            sourceDataLine.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        MusicPlayer.play();
    }
}