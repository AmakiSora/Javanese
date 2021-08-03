package net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多用户客户端
 */
public class MultiUserClient {
    public static void main(String[] args) {
        test();//方便测试
    }
    public static void test(){
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("连接成功!");
            while (true){
                System.out.print("请输入消息:");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
