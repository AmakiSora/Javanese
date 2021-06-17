package designpattern.singleton;

/**
 * 静态内部类(线程安全)
 */
public class StaticInner {

    private StaticInner() {}

    private static class SingletonHolder {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static StaticInner getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
