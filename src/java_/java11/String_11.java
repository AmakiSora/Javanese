package java_.java11;

/**
 * 新增字符串处理方法
 * java11新特性
 */
public class String_11 {
    public void test(){
        //判断字符串是否为空白
        System.out.println(" \t \n ".isBlank());//制表符,换行符,空格都算空白
        //去除首尾空白
        System.out.println("   Amaki Sora   ".strip());
        //去除尾部空白
        System.out.println("   Amaki Sora   ".stripTrailing());
        //去除首部空白
        System.out.println("   Amaki Sora   ".stripLeading());
        //复制字符串
        System.out.println("java".repeat(3));
        //行数统计
        System.out.println("a \n b \n c".lines().count());
    }
}
