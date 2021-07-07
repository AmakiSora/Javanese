package designpattern.flyweight;

/**
 * 手机系统具体类
 */
public class ConcretePhoneOS implements PhoneOS {

    private final String internalSystem;//内部系统

    public ConcretePhoneOS(String internalSystem) {
        this.internalSystem = internalSystem;
    }

    @Override
    public void systemDetails(String ExternalSystem) {
        System.out.println("对象地址: " + System.identityHashCode(this));
        System.out.println("内在系统: " + internalSystem);
        System.out.println("外部系统: " + ExternalSystem);
        System.out.println("----------------------");
    }
}
