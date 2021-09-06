package java_.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 *      一个有且仅有一个抽象方法,但是可以有多个非抽象方法的接口
 *      函数式接口可以被隐式转换为 lambda 表达式
 *      函数式接口用注解@FunctionalInterface来标识
 * Java内置四大核心函数式接口
 *      1 消费型接口 Consumer<T>  有入参,无返回值,方法为 void accept(T t) 只进不出
 *      2 供给型接口 Supplier<T>  无入参,有返回值,方法为 T get() 只出不进
 *      3 函数型接口 Function<T,R>有入参,有返回值,方法为 R apply(T t) 一进一出
 *      4 断定型接口 Predicate<T> 有入参,返回值为boolean,方法为 boolean test(T t) 一进判断
 * 其他内置函数式接口
 *      1 BiFunction<T,U,R>     两个入参,有返回值,方法为 R apply(T t,U u) 两进一出
 *      2 UnaryOperator<T>      一个入参,有返回值,入参和返回值相同,方法为 T apply(T t) 同进同出
 *      3 BinaryOperator<T>     两个入参,有返回值,入参和返回值相同,方法为 T apply(T t1,T t2) 两进同出
 *      4 BiConsumer<T,U>       两个入参,无返回值,方法为 void accept(T t,U u) 两进不出
 *      5 BiPredicate<T,U>      两个入参,返回值为boolean,方法为 boolean test(T t,U u) 两进判断
 */
public class FunctionalInterface_ {
    //消费型接口 Consumer<T>  有入参,无返回值,方法为void accept(T t) 只进不出
    private void consumer_(String str, Consumer<String> consumer){
        consumer.accept(str);
    }

    //供给型接口 Supplier<T>  无入参,有返回值,方法为T get() 只出不进
    private String supplier_(Supplier<String> supplier){
        return supplier.get();
    }

    //函数型接口 Function<T,R>有入参,有返回值,方法为R apply(T t) 一进一出
    private String function_(String str, Function<String,String> function){
        return function.apply(str);
    }

    //断定型接口 Predicate<T> 有入参,返回值为boolean,方法为boolean test(T t) 判断
    private boolean predicate_(String str, Predicate<String> predicate){
        return predicate.test(str);
    }
    public void test(){
        consumer_("233", System.out::println);
        System.out.println(supplier_(() -> "233"));
        System.out.println(function_("233",s -> s));
        System.out.println(predicate_("233",s -> true));
    }
}
