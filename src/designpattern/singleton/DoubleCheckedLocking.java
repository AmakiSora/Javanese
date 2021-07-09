package designpattern.singleton;

/**
 * 双重校验锁(线程安全)
 */
public class DoubleCheckedLocking {

    private volatile static DoubleCheckedLocking uniqueInstance;
    //加上volatile防止指令重排，即防止在对象还没生成的时候被获取到

    private DoubleCheckedLocking() {}

    public static DoubleCheckedLocking getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleCheckedLocking();
                }
            }
        }
        return uniqueInstance;
    }
}
