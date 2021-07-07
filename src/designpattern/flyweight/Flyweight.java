package designpattern.flyweight;

/**
 * 享元模式 测试
 */
public class Flyweight {
    public void test(){
        PhoneOSFactory factory = new PhoneOSFactory();
        PhoneOS MIUI = factory.getFlyweight("安卓");//小米
        PhoneOS Flyme = factory.getFlyweight("安卓");//魅族
        PhoneOS HarmonyOS = factory.getFlyweight("鸿蒙");//华为

        MIUI.systemDetails("MIUI");
        Flyme.systemDetails("Flyme");
        HarmonyOS.systemDetails("HarmonyOS");
    }
}
