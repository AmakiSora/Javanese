package nio;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

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
public class DatagramChannel_ {//UDP的通道写法
    public void test() throws InterruptedException {
        new Thread(this::receive).start();
        Thread.sleep(3000);
        for (int i = 0; i < 5; i++) {
            new Thread(()->send(Thread.currentThread().getName()+":hello!")).start();
        }
    }
    private void send(String data){//发送端
        try (DatagramChannel datagramChannel = DatagramChannel.open();){
            datagramChannel.configureBlocking(false);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(data.getBytes());
            buf.flip();
            datagramChannel.send(buf,new InetSocketAddress("127.0.0.1",8888));
            buf.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void receive(){//接收端
        try{
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            datagramChannel.bind(new InetSocketAddress(8888));
            Selector selector = Selector.open();
            datagramChannel.register(selector, SelectionKey.OP_READ);
            while (selector.select() > 0){
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey sk = it.next();
                    if (sk.isReadable()){
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        datagramChannel.receive(buf);
                        buf.flip();
                        System.out.println("接收端:"+new String(buf.array()));
                        buf.clear();
                    }
                }
                it.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
