package designPattern.singleton;

/**
 * 懒汉式加载(线程不安全)
 */
public class LazyLoading {
    private static LazyLoading uniqueInstance;

    private LazyLoading() {}

    public static LazyLoading getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazyLoading();
        }
        return uniqueInstance;
    }
}
