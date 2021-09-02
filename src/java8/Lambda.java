package java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式
 *      Lambda允许把函数作为一个方法的参数(函数作为参数传递到方法中)
 *      Lambda表达式的本质是作为函数式接口的实现(接口中只有一个方法被称为函数式接口)
 *      ->为lambda操作符
 *      ->左边为形参列表(接口中的抽象方法的形参列表)
 *      ->右边为方法体(重写的抽象方法的方法体)
 *      语法格式:
 *          1 无参,无返回值
 *              Runnable r = () -> System.out.println("useLambda");
 *          2 有参,无返回值
 *              Consumer<String> c = (String str) -> {System.out.println(str);};
 *          3 只有一个参数,无返回值,数据类型省略,括号省略(由编译器自行判断,即类型推断)
 *              Consumer<String> c = s -> System.out.println(s);
 *          4 两个或两个以上参数,多条语句,可以有返回值
 *              Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
 * 方法引用
 *      方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 */
public class Lambda {
    @SuppressWarnings("all")
    public void oldWay() {//旧的使用方式
        System.out.println("------OldWay------");
        //线程接口
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("old,Thread");
            }
        };
        r.run();

        //比较器
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(1, 2));

        //消费型接口
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o.toString());
            }
        };
        consumer.accept("Old,consumer");
    }

    public void useLambda() {//Lambda使用方式
        System.out.println("------useLambda------");
        //线程接口
        Runnable r = () -> System.out.println("Lambda,Thread");
        r.run();
        //比较器
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(1, 2));

        //消费型接口
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Lambda,consumer");
    }

    private void useMethodReferences() {//方法引用使用方式
        System.out.println("------useMethodReferences------");
        //比较器
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1, 2));

        //消费数据
        Consumer consumer = System.out::println;
        consumer.accept("MethodReferences,consumer");
    }

    public void test() {
        oldWay();
        useLambda();
        useMethodReferences();
    }
}
