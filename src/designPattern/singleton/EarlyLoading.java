package designPattern.singleton;

/**
 * 饿汉式(线程安全)
 */
public class EarlyLoading {
    private static final EarlyLoading instance = new EarlyLoading();
    private EarlyLoading (){}
    public static EarlyLoading getInstance() {
        return instance;
    }
}
