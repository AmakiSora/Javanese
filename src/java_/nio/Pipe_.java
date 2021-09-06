package java_.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 通道
 * java.java.nio.channels.Channel接口:
 *      |--SelecttableChannel
 *          |--SocketChannel    (网络)
 *          |--ServerSocketChannel  (网络服务端)
 *          |--DatagramChannel  (网络UDP)
 *
 *          |--Pipe.SinkChannel
 *          |--Pipe.SourceChannel
 * Pipe:
 *      Java NIO 管道是2个线程之间的单向数据连接
 *      Pipe有一个source通道和一个sink通道,数据会被写到sink通道,从source通道读取
 */
public class Pipe_ {
    public void test() throws IOException {
        Pipe pipe = Pipe.open();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();

        //将缓冲区中的数据写入管道
        sinkChannel.write(buf);

        //读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }
}
