package java_.io;

import java.io.*;

/**
 * DataOutputStream和DataInputStream的使用
 * 数据流,可以把数据和数据类型一并写到文件中,输出的文件并非文本文件
 * DataOutputStream写的文件只能用DataInputStream读，并且读的时候需要知道写入的顺序
 * 读的顺序和写的顺序一致才能正常取出数据
 */
public class DataIOStream {
    private void dataOutputStream(String path) {
        try (DataOutputStream dos =new DataOutputStream(new FileOutputStream(path))){
            byte b = 1;
            short s = 2;
            int i = 3;
            long l = 4L;
            float f = 5.0F;
            double d = 6.0;
            boolean bl = false;
            char c = '7';
            String str = "8";

            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(bl);
            dos.writeChar(c);
            dos.writeChars(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void dataInputStream(String path) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))){
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            long l = dis.readLong();
            float f = dis.readFloat();
            double d = dis.readDouble();
            boolean bl = dis.readBoolean();
            char c = dis.readChar();
            String str = String.valueOf(dis.readChar());

            System.out.println(b);
            System.out.println(s);
            System.out.println(i);
            System.out.println(l);
            System.out.println(f);
            System.out.println(d);
            System.out.println(bl);
            System.out.println(c);
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void test() {
        String path = "D:\\cosmos\\test\\data";
        dataOutputStream(path);
        dataInputStream(path);
    }
}
