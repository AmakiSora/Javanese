package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符流，只能读写普通文本
 */
public class FileReaderWriter {
    private void fileReader(String path){
        FileReader reader = null;
        try {
            reader = new FileReader(path);
            char[] chars = new char[10];//一次性读取10个字符
            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1){
                System.out.println(new String(chars,0,readCount));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try { reader.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
        }
    }
    private void fileWriter(String path){
        FileWriter writer = null;
        try {
            writer = new FileWriter(path,true);//第二个参数不写默认false
            char[] chars = {'随','便'};
            writer.write(chars);
            writer.write("写点啥");
            writer.flush();//刷新，即写入文件
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (writer != null){
                try { writer.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
        }
    }
    public void test(){
        fileReader("D:\\cosmos\\test\\fr.txt");
        fileWriter("D:\\cosmos\\test\\fw.txt");
    }
}
