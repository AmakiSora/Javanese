package java_.java9;

import java_.io.BufferedIOStream;

import java.io.*;

/**
 * IO流的TransferTo
 * 从此输入流中读取所有字节,并按照读取顺序将字节写入给定的输出流
 * 返回时,此输入流将位于流的末尾,此方法不会关闭任一流
 * 此方法可能会无限期地阻止从输入流读取或写入输出流
 * 输入和/或输出流异步关闭或线程在传输期间中断的情况下的行为是高度特定于输入和输出流的,因此未指定
 * 如果从输入流读取或向输出流写入时发生I/O错误,则可能会在读取或写入某些字节后发生
 * 因此,输入流可能不在流的末尾,一个或两个流可能处于不一致状态
 * 如果发生 I/O 错误,强烈建议立即关闭两个流
 */
public class IOTransferTo {
    private void oldJavaVersion(){
        new BufferedIOStream().test();
    }
    private void java9Version(){
        try (InputStream is = new FileInputStream("D:\\cosmos\\test\\1.txt");
             OutputStream os = new FileOutputStream("D:\\cosmos\\test\\2.txt")){
            //将输入流中的数据自动复制到输出流
            is.transferTo(os);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void test(){
        oldJavaVersion();
        java9Version();
    }
}
