package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散(Scatter)与聚集(Gather)
 * 分散读取(Scattering Reads):将通道中的数据分散到多个缓冲区中
 * 聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道中
 */
public class Scatter_Gather {
    public void test() throws IOException {
        //分散读取
        RandomAccessFile rafr = new RandomAccessFile("D:\\cosmos\\test\\rafr.txt", "rw");

        FileChannel readChannel = rafr.getChannel();//获取通道
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {buf1,buf2};
        readChannel.read(bufs);

        for (ByteBuffer buffer : bufs){
            buffer.flip();//切换模式
        }
        System.out.println("缓冲区1-----------");
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("缓冲区2-----------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //聚集写入
        RandomAccessFile rafw = new RandomAccessFile("D:\\cosmos\\test\\rafw.txt", "rw");
        FileChannel writeChannel = rafw.getChannel();//获取通道
        writeChannel.write(bufs);

        //实际使用要try-catch-finally
        readChannel.close();
        writeChannel.close();
    }
}
