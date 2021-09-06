package java_.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道:用于源节点与目标节点的连接,在NIO中负责缓冲区中数据的传输
 * java.java.nio.channels.Channel接口:
 *      |--FileChannel  (本地)
 *      |--SocketChannel    (网络)
 *      |--ServerSocketChannel  (网络)
 *      |--DatagramChannel  (网络UDP)
 *
 */
public class FileChannel_ {
    public void test() {
        copyWay1();
        copyWay2();
        copyWay3();
    }
    private void copyWay1() {//利用IO流通过管道完成文件的复制
        try (FileInputStream fis = new FileInputStream("D:\\cosmos\\test\\fis.txt");
             FileOutputStream fos = new FileOutputStream("D:\\cosmos\\test\\fos.txt");
             //获取通道
             FileChannel inChannel = fis.getChannel();
             FileChannel outChannel = fos.getChannel()) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf) != -1) {
                buf.flip();//切换写模式
                outChannel.write(buf);//写入
                buf.clear();//清空
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void copyWay2() {//使用直接缓冲区完成文件复制(速度更快,但不一定是最好)
        try(//在JDK1.7中的NIO2,针对通道提供了静态方法open()
            FileChannel inChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\in.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\out.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE)//CREATE没有则创建,有则覆盖;CREATE_NEW没有则创建,有则报错
            ){
            //内存映射文件
            MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            //直接对缓冲区进行数据操作读写
            byte[] bytes = new byte[inBuffer.limit()];
            inBuffer.get(bytes);
            outBuffer.put(bytes);
            outBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void copyWay3() {//使用transfer方法完成通道之间的数据传输(和方法2一样,不过是更方便)
        try (FileChannel inChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\in.txt"), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("D:\\cosmos\\test\\out.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE)//CREATE没有则创建,有则覆盖;CREATE_NEW没有则创建,有则报错
        ){
            inChannel.transferTo(0,inChannel.size(),outChannel);//接通管道
//            outChannel.transferFrom(inChannel,0,inChannel.size());//可替代上面
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
