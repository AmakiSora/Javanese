package net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP的网络编程
 */
public class TCPConnection {
    public void test() throws InterruptedException {
        new Thread(this::server).start();//启动服务器
        Thread.sleep(3000);
        client();
    }
    private void server(){//服务端
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8888);//指定自身端口号
            socket = ss.accept();//接受来自客户端的socket
            is = socket.getInputStream();
            //读取数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int l;
            while ((l = is.read(buffer)) != -1){
                baos.write(buffer,0,l);
            }
            System.out.println("服务端:"+baos.toString());
            System.out.println("服务端:收到来自"+socket.getInetAddress().getHostAddress()+"的信息");

            //服务端向客户端发消息
            os = socket.getOutputStream();
            os.write("服务器返回的消息!".getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(baos != null){
                try { baos.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(is != null){
                try { is.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(socket != null){
                try { socket.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(ss != null){
                try { ss.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(os != null){
                try { os.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
        }
    }

    private void client(){//客户端
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress i = InetAddress.getByName("127.0.0.1");
            socket = new Socket(i,8888);//地址，端口号
            os = socket.getOutputStream();
            os.write("客户端发出的信息！".getBytes());

            socket.shutdownOutput();//关闭数据输出

            //接受服务端的消息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int l;
            while ((l = is.read(buffer)) != -1){
                baos.write(buffer,0,l);
            }
            System.out.println("客户端："+baos.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (os != null){
                try { os.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if (socket != null){
                try { socket.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(baos != null){
                try { baos.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
            if(is != null){
                try { is.close(); }
                catch (IOException e){ e.printStackTrace(); }
            }
        }
    }
}
