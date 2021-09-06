package java_.java9;

import java.io.*;

/**
 * try-with-resources
 * try-with-resources是Java7中一个新的异常处理机制,它能够很容易地关闭在try-catch语句块中使用的资源
 * try-with-resources声明在Java9已得到改进
 * 如果你已经有一个资源是final或等效于final变量,您可以在try-with-resources语句中使用该变量,而无需在try-with-resources语句中声明一个新变量
 */
@SuppressWarnings("all")
public class TryWithResources {
    private void oldJavaVersion() {//java7之前关闭流方式
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void java7Version() {//java7提供自动关闭流方式
        try (InputStreamReader is = new InputStreamReader(System.in)) {
            //要求需要关闭的资源必须在try的()中初始化,否则编译不通过
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void java9Version() {//java9可以在其他地方初始化资源
        InputStreamReader is = new InputStreamReader(System.in);
        try (is) {//将需要关闭的资源变量放进()中

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        oldJavaVersion();
        java7Version();
        java9Version();
    }
}
