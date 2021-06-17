package designpattern.singleton;

/**
 * 懒汉式加载(线程安全)
 */
public class LazyLoadingSynchronized {

    private static LazyLoadingSynchronized uniqueInstance;

    private LazyLoadingSynchronized() {}

    public static synchronized LazyLoadingSynchronized getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazyLoadingSynchronized();
        }
        return uniqueInstance;
    }
}
