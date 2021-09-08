package java_.java10;

import java.util.ArrayList;

/**
 * 局部变量的类型推断
 * java10新特性
 * 注意:
 *      var不是一个关键字,var可以用作变量名或方法名
 */
@SuppressWarnings("all")
public class LocalVariableTypeInference {
    //var num = 10;//全局变量不能用var
    private void oldJavaVersion() {
        int num = 10;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : list) System.out.println(i);
    }

    private void java10Version() {
        var num = 10;
        var list = new ArrayList<Integer>();
        for (var i : list) System.out.println(i);

//        var r = null;//不能使用的情况,使用var必须要初始化,且不为null
//        var arr = {1, 2, 3, 4}//数组的静态初始化也不能用var

    }

    public void test() {
        oldJavaVersion();
        java10Version();
    }
}
