package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API
 *      Stream是Java8中处理集合的关键抽象概念
 *      它可以指定你希望对集合进行的操作,可以执行非常复杂的查找,过滤和映射数据等操作
 *      使用Stream API对集合数据进行操作,就类似于使用sL执行的数据库查询,也可以使用Stream API来并行执行操作
 *      简言之，Stream API提供了一种高效且易于使用的处理数据的方式
 *      注意:
 *          stream 自己不会存储元素
 *          stream不会改变源对象,相反,他们会返回一个持有结果的新Stream
 *          Stream 操作是延迟执行的,这意味着他们会等到需要结果的时候才执行
 */
public class StreamAPI {
    private void sc(){
        //通过集合创建
        ArrayList<String> strings = new ArrayList<>();
        //default Stream<E> stream():返回一个顺序流
        Stream<String> stringStream = strings.stream();
        //default Stream<E> parallelStream():返回一个并行流
        Stream<String> parallelStream = strings.parallelStream();

        //通过数组创建
        int[] arr = {1,2,3,4,5};
        //
        IntStream stream = Arrays.stream(arr);

        //通过Stream的of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        //创建无限流
        //迭代
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);


    }
    public void test(){

    }
}
