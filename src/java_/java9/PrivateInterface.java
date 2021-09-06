package java_.java9;

/**
 * 接口的私有方法(接口)
 * java9新特性
 */
public interface PrivateInterface {
    static void methodStatic(){
        System.out.println("接口中的静态方法");
    }
    default void methodDefault(){
        System.out.println("接口中的默认方法");

        methodPrivate();//可以在接口里调用private方法,实现类不能调用
    }
    private void methodPrivate(){
        System.out.println("接口中的私有方法");//java9开始支持,不能在接口外调用
    }
}
