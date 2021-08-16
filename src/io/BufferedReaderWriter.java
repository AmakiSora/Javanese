package io;

import java.io.*;

/**
 * BufferedReader和BufferedWriter的使用
 * 带缓冲区的字符流
 */
public class BufferedReaderWriter {
    private void bufferedCopyFile(String oldPath,String newPath){
        try (FileReader fileReader = new FileReader(oldPath);
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(newPath);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             ){
            String s;
            while((s = reader.readLine())!= null){
                writer.write(s);
            }
            //缓冲区的内容写入到文件
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void test(){
        String oldPath = "D:\\cosmos\\test\\old.txt";
        String newPath = "D:\\cosmos\\test\\new.txt";
        bufferedCopyFile(oldPath,newPath);
    }
}
