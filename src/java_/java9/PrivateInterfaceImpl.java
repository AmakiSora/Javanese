package java_.java9;
/**
 * 接口的私有方法(实现类)
 * java9新特性
 */
public class PrivateInterfaceImpl implements PrivateInterface {

    @Override
    public void methodDefault() {
        System.out.println("重写默认方法");

    }

    public void test(){
        //接口中的静态方法只能由接口自己调用(实现类不能调用静态方法)
        PrivateInterface.methodStatic();
        PrivateInterfaceImpl impl = new PrivateInterfaceImpl();
        impl.methodDefault();

    }
}
