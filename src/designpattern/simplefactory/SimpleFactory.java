package designpattern.simplefactory;

/**
 * 简单工厂模式 测试
 */
public class SimpleFactory {
    public void test() {
        Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","3.3 GHz");
        Computer server = ComputerFactory.getComputer("server","16 GB","10 TB","5.0 GHz");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }
}
