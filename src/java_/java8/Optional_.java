package java_.java8;

import java.util.Optional;

/**
 * Optional 类
 *      Optional 类是一个可以为null的容器对象
 *      如果值存在则isPresent()方法会返回true,调用get()方法会返回该对象
 *      Optional 是个容器,它可以保存类型T的值,或者仅仅保存null
 *      Optional 提供很多有用的方法,这样我们就不用显式进行空值检测
 *      Optional 类的引入很好的解决空指针异常
 */
public class Optional_ {
    @SuppressWarnings("all")//关闭警告
    private void useOptional(){

        Optional<Integer> a = Optional.of(666);//必须是非空的
        Optional<Object> b = Optional.empty();//创建一个空的Optional实例
        Optional<Integer> c = Optional.ofNullable(null);//可以为空

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("-----------------");

        System.out.println(a.isPresent());//判断是否包含对象,返回boolean值
        System.out.println(b.isPresent());//判断是否包含对象,返回boolean值
        System.out.println(c.isPresent());//判断是否包含对象,返回boolean值
        System.out.println("-----------------");

        System.out.println(c.orElse(233));//如果c不为null则返回c,如果为null,则返回233
        System.out.println("-----------------");

        System.out.println(a.get());//获取对象的值,如果为null则抛出异常
        System.out.println("-----------------");

        //void ifPresent(Consumer<? super T> consumer)
        c.ifPresent(System.out::println);//如果c不为null则执行Consumer函数,如果为null则不执行
        System.out.println("-----------------");

        //T orElseGet(Supplier<? extends T> supplier)
        c.orElseGet(()-> 233);//如果c不为null则返回c,如果为null,则执行Supplier函数
        System.out.println("-----------------");

        //T orElseThrow(Supplier<? extends X> exceptionSupplier)
        System.out.println(a.orElseThrow());//如果a不为null则返回a,如果为null,则抛出由Supplier函数提供的异常
        System.out.println("-----------------");
        
    }

    public void test(){
        useOptional();
    }
}
