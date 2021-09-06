package java_.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多用户服务端
 * 可接收多个客户端的Socket连接
 * 服务端每接受到一个Socket请求后都交给一个线程来处理客户端的数据
 * 缺点:
 *      1.每个Socket接收到,都会创建一个线程,线程的竞争、切换上下文影响性能
 *      2.每个线程都会占用栈空间和CPU资源
 *      3.并不是每个socket都进行IO操作,即不发消息也进行阻塞等待
 *      4.客户端的并发访问增加时,服务端将呈现1:1的线程开销,访问量越大,系统将发生线程栈溢出,线程创建失败,最终导致进程宕机或者僵死,从而不能对外提供服务。
 */
public class MultiUserServer {//BIO模式
    @SuppressWarnings("all")//关闭警告
    public void test(){
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true){
                Socket socket = ss.accept();
                System.out.println("服务器启动!");
                //创建独立的线程来处理
                new Thread(()->{
                    try {
                        System.out.println(Thread.currentThread().getName()+"已连接");
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String msg;
                        while ((msg = br.readLine())!=null){
                            System.out.println(Thread.currentThread().getName()+":"+msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
