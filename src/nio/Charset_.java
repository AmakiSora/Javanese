package nio;

import javax.swing.text.html.parser.Entity;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.util.Map;
import java.util.Set;

/**
 * 字符集(Charset)
 * 编码:字符串->字节数组
 * 解码:字节数组->字符串
 */
public class Charset_ {
    public void test() throws CharacterCodingException {
        Charset cs = Charset.forName("GBK");
//        Charset cs = StandardCharsets.UTF_8;

        //获取编码器
        CharsetEncoder ce = cs.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("字符!");
        charBuffer.flip();

        //编码
        ByteBuffer encodeBuf = ce.encode(charBuffer);

        //解码
        CharBuffer decodeBuf = cd.decode(encodeBuf);
        System.out.println(decodeBuf.toString());
    }

    private void showAllCharset(){//查看所有的字符集
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
