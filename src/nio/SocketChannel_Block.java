package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道
 * java.nio.channels.Channel接口:
 *      |--SelecttableChannel
 *          |--SocketChannel    (网络)
 *          |--ServerSocketChannel  (网络服务端)
 *          |--DatagramChannel  (网络UDP)
 *
 *          |--Pipe.SinkChannel
 *          |--Pipe.SourceChannel
 */
public class SocketChannel_Block {//阻塞写法
    public void test() throws InterruptedException {//模拟客户端上传文件
        new Thread(this::server).start();
        Thread.sleep(3000);
        client();
    }
    private void server() {//服务端
        ServerSocketChannel serverSocketChannel = null;
        FileChannel fileChannel = null;
        SocketChannel socketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            fileChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\receive.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            serverSocketChannel.bind(new InetSocketAddress(8888));//绑定连接
            socketChannel = serverSocketChannel.accept();//获取与客户端连接的通道
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (socketChannel.read(buf)!= -1){
                buf.flip();
                fileChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { if (socketChannel!=null) socketChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
            try { if (fileChannel!=null) fileChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
            try { if (serverSocketChannel!=null) serverSocketChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
    private void client() {//客户端
        SocketChannel socketChannel = null;
        FileChannel fileChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
            fileChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\send.txt"), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (fileChannel.read(buf)!=-1){
                buf.flip();
                socketChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { if (fileChannel!=null) fileChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
            try { if (socketChannel!=null) socketChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
