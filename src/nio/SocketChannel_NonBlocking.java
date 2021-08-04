package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
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
 *
 * 选择器(Selector):
 *      Selector的作用是Java NIO中管理一组多路复用的SelectableChannel对象,并能够识别通道是否为诸如读写事件做好准备的组件
 *      当调用register(Selector sel, int ops)将通道注册选择器时,选择器对通道的监听事件,需要通过第二个参数ops指定
 *      可以监听的事件类型（可使用SelectionKey 的四个常量表示）:
 *          读: SelectionKey.OP_READ (1)
 *          写 : SelectionKey.OP_WRITE (4)
 *          连接: SelectionKey.OP_CONNECT (8)
 *          接收 : SelectionKey.OP_ACCEPT (16)
 *      若注册时不止监听一个事件,则可以使用位或(|)操作符连接
 */
public class SocketChannel_NonBlocking {//非阻塞写法
    public void test() throws InterruptedException {
        new Thread(this::server).start();
        Thread.sleep(3000);
        for (int i = 0; i < 5; i++) {
            new Thread(()-> client(Thread.currentThread().getName()+":hello!")).start();
        }
    }
    private void server(){//服务端
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //切换为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8888));
            //获取选择器
            Selector selector = Selector.open();
            //将通道注册到选择器上,并且指定"监听接收事件"
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //轮询式的获取选择器上已经准备就绪的事件
            while (selector.select()>0){
                //获取当前选择器中所有注册的"选择键(已就绪的监听事件)"
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    //获取准备就绪的事件
                    SelectionKey sk = it.next();
                    //判断具体是什么事件
                    if (sk.isAcceptable()){//如果是接收到连接的事件
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);//切换成非阻塞模式
                        socketChannel.register(selector,SelectionKey.OP_READ);//注册到选择器上
                    }else if (sk.isReadable()){//如果是接收到读取的事件
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        while ((socketChannel.read(buf)) > 0){
                            buf.flip();
                            System.out.println(new String(buf.array()));
                            buf.clear();
                        }
                    }
                    //删除选择键(SelectionKey)
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void client(String data) {//客户端
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
            socketChannel.configureBlocking(false);//切换为非阻塞模式
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(data.getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try { if (socketChannel!=null) socketChannel.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
