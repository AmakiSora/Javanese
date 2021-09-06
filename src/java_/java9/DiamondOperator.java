package java_.java9;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 钻石操作符<>
 * 钻石操作符是在 java7 中引入的，可以让代码更易读，但它不能用于匿名的内部类。
 * 在 java9 中， 它可以与匿名的内部类一起使用，从而提高代码的可读性。
 */
@SuppressWarnings("all")
public class DiamondOperator {
    public void test(){
        ArrayList<String> a = new ArrayList<>();//java7的新特性(类型推断)
        Comparator<String> c = new Comparator<>() {//等价于new Comparator<String>,java9新特性(匿名内部类的钻石操作符)
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }
}
