package io;

import java.io.*;

/**
 * FileOutputStream和FileInputStream类的使用
 * 文件字节流
 */
public class FileIOStream {
    private void writeToFile(String path) throws IOException{//写入文件
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
//        fos = new FileOutputStream(new File("D:\\cosmos\\test\\fos.txt"));//另一种构造方式
            fos.write(97);//ASCII码写入

            byte[] bytes = {98,99};//用byte数组写入
            fos.write(bytes);

            bytes = "de".getBytes();//字符串写入
            fos.write(bytes);

            bytes = "xxxYYYxxx".getBytes();//指定位置写入
            fos.write(bytes,3,3);//字符数组，起始位置，写多少个

            fos.write("\r\n".getBytes());//换行
        /*
            不同系统换行符不同
            windows换行为\r\n   实测\n好像也行
            linux换行为\n
            mac换行为\r
         */

            //构造函数中第二个参数append默认为false，即从头开始写入，如果为true，则在末尾开始写入
            fos = new FileOutputStream(path,true);
            fos.write("COSMOS".getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                //IO流最后都需要释放资源,最好用try catch finally来保证释放
                if (fos != null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void readFromFile(String path){//读取文件
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            /*
                从此输入流中读取一个字节的数据。 如果尚无可用输入，则此方法会阻塞。
                返回值为当前字节的ASCII码，如果到达文件末尾，则为-1 。
                注意:换行符等特殊字符也会读出
             */
            System.out.println(fis.read());
            System.out.println((char) fis.read());

            //读出所有数据(readAllBytes)
            byte[] b = fis.readAllBytes();
            System.out.println(new String(b));

            //读出所有数据(循环)
            int i;
            while ((i = fis.read()) != -1){//循环读取
                System.out.print((char) i);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void test() throws IOException {
        writeToFile("D:\\cosmos\\test\\fos.txt");
        readFromFile("D:\\cosmos\\test\\fis.txt");
    }
}
