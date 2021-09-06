package java_.io;

import java.io.*;

/**
 * InputStreamReader和OutputStreamWriter的使用
 * 转换流，可以将字节流转换为字符流
 * 转换完后正常按照字符流使用
 */
public class IOToReaderWriter {

    public void test() throws IOException {
        File file = new File("");
        //输入流
        FileInputStream fileInputStream = new FileInputStream(file);//输入字节流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//字节流转换为字符流
        FileReader fileReader = new FileReader(String.valueOf(inputStreamReader));//输入字符流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//缓冲字符流

        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file);//输出字节流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);//字节流转换为字符流
        FileWriter fileWriter = new FileWriter(String.valueOf(outputStreamWriter));//输出字符流
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);//缓冲字符流

    }
}
