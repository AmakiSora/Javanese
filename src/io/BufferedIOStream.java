package io;

import java.io.*;

/**
 * BufferedInputStream和BufferedOutputStream的使用
 *
 * BufferedInputStream和BufferedOutputStream这两个类分别是FilterInputStream和FilterOutputStream的子类
 * 作为装饰器子类，使用它们可以防止每次读取/发送数据时进行实际的写操作，代表着使用缓冲区。
 *
 * 我们有必要知道不带缓冲的操作，每读一个字节就要写入一个字节，由于涉及磁盘的IO操作相比内存的操作要慢很多
 * 所以不带缓冲的流效率很低。带缓冲的流，可以一次读很多字节，但不向磁盘中写入，只是先放到内存里。
 * 等凑够了缓冲区大小的时候一次性写入磁盘，这种方式可以减少磁盘操作次数，速度就会提高很多！
 *
 * 同时正因为它们实现了缓冲功能，所以要注意在使用BufferedOutputStream写完数据后，
 * 要调用flush()方法或close()方法，强行将缓冲区中的数据写出。否则可能无法写出数据。
 */
public class BufferedIOStream {
    private void bufferedCopyFile(File oldFile, File newFile) {//复制文件
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            inputStream = new FileInputStream(oldFile);
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream(newFile);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] b = new byte[1024];   //代表一次最多读取1KB的内容
            int length = 0 ; //代表实际读取的字节数
            while((length = bufferedInputStream.read(b))!= -1){
                //length 代表实际读取的字节数
                bufferedOutputStream.write(b, 0, length);
            }
            //缓冲区的内容写入到文件
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//先关闭外层流，再关闭内层流,即先打开的后关闭，后打开的先关闭
            if( bufferedOutputStream != null ){
                try { bufferedOutputStream.close();}
                catch (IOException e) { e.printStackTrace();}
            }
            if( bufferedInputStream != null){
                try { bufferedInputStream.close();}
                catch (IOException e) { e.printStackTrace();}
            }
            if( inputStream != null ){
                try { inputStream.close();}
                catch (IOException e) { e.printStackTrace();}
            }
            if ( outputStream != null ) {
                try { outputStream.close();}
                catch (IOException e) { e.printStackTrace();}
            }
        }
    }
    public void test() throws FileNotFoundException {
        File oldFile = new File("D:\\cosmos\\test\\bis.txt");
        File newFile = new File("D:\\cosmos\\test\\bos.txt");
        bufferedCopyFile(oldFile,newFile);
    }
}
