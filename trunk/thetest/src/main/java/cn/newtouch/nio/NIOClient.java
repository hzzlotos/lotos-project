package cn.newtouch.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient
{

    /* 标识数字 */
    private int        flag          = 0;

    /* 缓冲区大小 */
    private int        BLOCK         = 4096;

    /* 接受数据缓冲区 */
    private ByteBuffer sendbuffer    = ByteBuffer.allocate(this.BLOCK);

    /* 发送数据缓冲区 */
    private ByteBuffer receivebuffer = ByteBuffer.allocate(this.BLOCK);

    private Selector   selector;

    public NIOClient(String address, int port) throws IOException
    {
        // 打开socket通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞方式
        socketChannel.configureBlocking(false);
        // 打开选择器
        this.selector = Selector.open();
        // 注册连接服务端socket动作
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
        // 连接
        socketChannel.connect(new InetSocketAddress(address, port));
    }

    // 监听
    public void listen() throws IOException
    {

        while (true)
        {

            // 选择一组键，其相应的通道已为 I/O 操作准备就绪。
            // 此方法执行处于阻塞模式的选择操作。
            this.selector.select();
            // 返回此选择器的已选择键集。
            Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
            System.out.println(selectionKeys.size());
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext())
            {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                this.handleKey(selectionKey);
                // selectionKeys.clear();
            }
        }
    }

    // 处理请求
    private void handleKey(SelectionKey selectionKey) throws IOException
    {
        SocketChannel client;
        String receiveText;
        String sendText;

        int count = 0;

        // 测试此键的通道是否已准备好接受新的套接字连接。

        if (selectionKey.isConnectable())
        {
            System.out.println("client connect");
            client = (SocketChannel) selectionKey.channel();
            // 判断此通道上是否正在进行连接操作。
            // 完成套接字通道的连接过程。
            if (client.isConnectionPending())
            {
                client.finishConnect();
                System.out.println("完成连接!");
                this.sendbuffer.clear();
                this.sendbuffer.put("Hello,Server".getBytes());
                this.sendbuffer.flip();
                client.write(this.sendbuffer);
            }
            client.register(this.selector, SelectionKey.OP_READ);
        }
        else
            if (selectionKey.isReadable())
            {
                client = (SocketChannel) selectionKey.channel();
                // 将缓冲区清空以备下次读取
                this.receivebuffer.clear();
                // 读取服务器发送来的数据到缓冲区中
                count = client.read(this.receivebuffer);
                if (count > 0)
                {
                    receiveText = new String(this.receivebuffer.array(), 0, count);
                    System.out.println("客户端接受服务器端数据--:" + receiveText);
                    client.register(this.selector, SelectionKey.OP_WRITE);
                }

            }
            else
                if (selectionKey.isWritable())
                {
                    this.sendbuffer.clear();
                    client = (SocketChannel) selectionKey.channel();
                    sendText = "message from client--" + (this.flag++);
                    this.sendbuffer.put(sendText.getBytes());
                    // 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
                    this.sendbuffer.flip();
                    client.write(this.sendbuffer);
                    System.out.println("客户端向服务器端发送数据--：" + sendText);
                    client.register(this.selector, SelectionKey.OP_READ);
                }
    }

    public static void main(String[] args) throws IOException
    {
        NIOClient server = new NIOClient("localhost", 8888);
        server.listen();
    }
}
