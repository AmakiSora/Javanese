package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * PrintStream和PrintWriter的使用
 * 标准输出流
 * 不需要调用close方法关闭
 *
 * 区别:
 * PrintStream主要操作byte流，而PrintWriter用来操作字符流。读取文本文件时一般用后者。
 *
 * java的一个字符（char）是16bit的，一个BYTE是8bit的
 * PrintStrean是写入一串8bit的数据的。
 * PrintWriter是写入一串16bit的数据的。
 * String缺省是用UNICODE编码，是16bit的。因此用PrintWriter写入的字符串，跨平台性好一些吧。
 * PrintStream的可能会出现字符集乱码吧。
 *
 * PrintStream是用来操作byte,
 * PrintWriter是用来操作Unicode,
 * 一般需要处理中文时用PrintWriter好了
 *
 * Stream用于二进制文件（非文本）
 * Writer/Reader用于文本文件（虽然也是二进制，不过是按照一定的字符编码规则，不像前者）
 * 当然Stream也可用于文本，只不过比writer/reader来的麻烦
 */
public class StandardOutput {

    public void test() throws FileNotFoundException {

        System.out.println("hello world!");//回到hello world!

        //拆开sout,相当于以下例子
        PrintStream ps = System.out;
        ps.print("hello ");
        ps.print("world!");

        //标准输出流不在指向控制台，指向“log”文件
        ps = new PrintStream(new FileOutputStream("D:\\cosmos\\test\\log"),true);
        System.setOut(ps);//修改输出方向，输出到log文件
        System.out.println("change!");

        //PrintWriter和PrintStream的使用大同小异
        //第二个参数autoFlush置为true时，每当输出遇到换行符，缓冲区的内容就被强制全部输出，如同调用了一次flush()。但要注意，如果没遇到换行符，还是会有数据存在缓冲区里。
        PrintWriter pw = new PrintWriter(new FileOutputStream("D:\\cosmos\\test\\log"),true);//
        pw.println("hello pw!");

    }
}
