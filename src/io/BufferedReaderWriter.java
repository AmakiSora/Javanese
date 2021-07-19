package io;

import java.io.*;

/**
 * BufferedReader和BufferedWriter的使用
 * 带缓冲区的字符流
 */
public class BufferedReaderWriter {
    private void bufferedCopyFile(String oldPath,String newPath){
        BufferedReader reader = null;
        FileReader fileReader = null;
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(oldPath);
            reader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(newPath);
            writer = new BufferedWriter(fileWriter);
            String s = null;
            while((s = reader.readLine())!= null){
                writer.write(s);
            }
            //缓冲区的内容写入到文件
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//其实关闭外层流，内层流也会关闭(看源码)
            if( reader != null ){
                try { reader.close();}
                catch (IOException e) { e.printStackTrace();}
            }
            if( writer != null){
                try { writer.close();}
                catch (IOException e) { e.printStackTrace();}
            }
        }
    }
    public void test(){
        String oldPath = "D:\\cosmos\\test\\old.txt";
        String newPath = "D:\\cosmos\\test\\new.txt";
        bufferedCopyFile(oldPath,newPath);
    }
}
