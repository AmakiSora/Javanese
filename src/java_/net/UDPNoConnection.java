package java_.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 基于UDP的网络编程
 */
public class UDPNoConnection {
    public void test() throws InterruptedException {
        new Thread(this::receiver).start();//开启接收端
        Thread.sleep(3000);
        sender();
    }
    private void sender() {//发送端
        try (DatagramSocket socket = new DatagramSocket()){
            byte[] str = "发送端的消息！".getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(str,str.length,ip,8888);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void receiver(){//接收端
        try (DatagramSocket socket = new DatagramSocket(8888)){//指定端口号
            byte[] str = new byte[50];
            DatagramPacket packet = new DatagramPacket(str,str.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
