package java_.java9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream API(java9)
 *      Java9改进的StreamAPI添加了一些便利的方法,使流处理更容易,并使用收集器编写复杂的查询
 *      Java9为Stream新增了几个方法:dropWhile、takeWhile、ofNullable,为iterate方法新增了一个重载方法
 */
@SuppressWarnings("all")
public class StreamAPI_9 {

    private void takeWhile_(){
        List<Integer> list = Arrays.asList(9, 6, 5, 4, 1, 8, 2);
        //takeWhile(Predicate<? super T> predicate)返回从头开始的按照指定规则尽量多的元素
        list.stream().takeWhile(i-> i > 3).forEach(System.out::println);//一直获取数据,直到小于等于3,停止获取数据
        System.out.println("----------");
    }

    private void dropWhile_(){
        List<Integer> list = Arrays.asList(9, 6, 5, 4, 1, 8, 2);
        //dropWhile(Predicate<? super T> predicate)返回从按照指定规则的元素开始的尽量多的元素(和takeWhile相反)
        list.stream().dropWhile(i-> i > 3).forEach(System.out::println);//一直丢弃数据,直到小于等于3,开始获取数据
        System.out.println("----------");
    }

    private void ofNullable_(){
        //java8的of方法
        Stream.of(1,null);//这种方法不能存储单个null,会抛出异常
        //java9新增ofNullable方法
        Stream.ofNullable(233);//ofNullable方法允许创建一个单元素Stream,可以包含一个非空元素
        Stream.ofNullable(null).count();//也可以创建一个空Stream
        System.out.println("----------");
    }
    private void iterate_(){
        //java8的iterate方法,iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        //java9新增的iterate方法,iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
        Stream.iterate(0,t -> t < 20,t -> t + 2).forEach(System.out::println);
        System.out.println("----------");
    }

    public void test(){
        takeWhile_();
        dropWhile_();
        ofNullable_();
        iterate_();
    }
}
