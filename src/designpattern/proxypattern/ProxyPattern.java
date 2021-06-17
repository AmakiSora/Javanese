package designpattern.proxypattern;

/**
 * 代理模式 测试
 */
public class ProxyPattern {
    public void test() {
        Image image = new ProxyImage("test_image.jpg");
        // 图像将从磁盘加载
        image.display();
        // 图像不需要从再次加载
        image.display();
    }
}
