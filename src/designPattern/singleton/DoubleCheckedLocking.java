package designPattern.singleton;

/**
 * 双重校验锁(线程安全)
 */
public class DoubleCheckedLocking {
    private volatile static DoubleCheckedLocking uniqueInstance;

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
