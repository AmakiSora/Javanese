package java_.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 缓冲区:在NIO中负责数据的存取
 * 缓冲区就是数组,用于存储不同数据类型的数据
 * 根据数据类型的不同(boolean除外),都有相应的缓冲区
 *      ByteBuffer
 *      CharBuffer
 *      ShortBuffer
 *      IntBuffer
 *      LongBuffer
 *      FloatBuffer
 *      DoubleBuffer
 * 管理方式:通过Allocate()获取缓冲区
 * 存取数据的方法:put() get()
 * 缓冲区的属性:
 *      capacity:容量,表示缓冲区中最大的存储容量,声明后不可更改
 *      limit:界限,表示缓冲区中可以操作数据的大小(limit后数据不能进行读写)
 *      position:位置,表示缓冲区中正在操作数据的位置
 *      三者满足 position <= limit <= capacity
 * 直接与非直接缓冲区:
 *      非直接缓冲区:通过allocate()方法分配缓冲区,将缓冲区建立在JVM的内存中
 *      直接缓冲区:通过allocateDirect()方法分配直接缓冲区,将缓冲区建立在物理内存中,可以提高效率
 */
public class Buffer {
    public void test() throws IOException {
        //allocate():分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);//非直接缓冲区
        System.out.println("是否是直接缓冲区"+buf.isDirect());//判断是否是直接缓冲区
        System.out.println("初始化后:----------------");
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

        //put():利用put方法存入缓冲区
        buf.put("hello!".getBytes());
        System.out.println("put后:------------------");
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

        //flip():切换成读取数据模式
        buf.flip();
        System.out.println("flip后:------------------");
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

        //get():读取数据
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes);
        System.out.println("get后:------------------");
        System.out.println(new String(bytes));
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

        //rewind():可重复读数据,position调0
        buf.rewind();
        System.out.println("rewind后:------------------");
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

        //mark():标记当前位置,后面可以用reset()方法回到当前位置
        System.out.println("mark后:------------------");
        byte[] b1 = new byte[buf.limit()];
        buf.get(b1,0,2);//读取前面两个字符
        System.out.println(new String(b1));
        System.out.println("位置:"+buf.position());//位置
        buf.mark();
        byte[] b2 = new byte[buf.limit()];
        buf.get(b2,0,2);//再读两个字符
        System.out.println(new String(b2));
        System.out.println("位置:"+buf.position());//位置

        //reset():回到标记的位置
        buf.reset();
        System.out.println("reset后:------------------");
        System.out.println("位置:"+buf.position());//位置

        //hasRemaining():判断缓冲区中是否还有数据
        //remaining():查看缓冲区中剩余的数据个数
        System.out.println("remaining:------------------");
        if (buf.hasRemaining())
            System.out.println("剩余:"+buf.remaining());//查看还剩余几个
        else
            System.out.println("无了");

        //clear():清空缓冲区,但是缓冲区数据还在,处于被遗忘状态
        buf.clear();
        System.out.println("clear后:------------------");
        System.out.println("位置:"+buf.position());//位置
        System.out.println("界限:"+buf.limit());//界限
        System.out.println("容量:"+buf.capacity());//容量

    }
}
