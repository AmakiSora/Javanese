package java_.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API
 *      Stream是Java8中处理集合的关键抽象概念
 *      它可以指定你希望对集合进行的操作,可以执行非常复杂的查找,过滤和映射数据等操作
 *      使用Stream API对集合数据进行操作,就类似于使用sL执行的数据库查询,也可以使用Stream API来并行执行操作
 *      简言之，Stream API提供了一种高效且易于使用的处理数据的方式(在java中做sql做的事)
 *      注意:
 *          stream 自己不会存储元素
 *          stream不会改变源对象,相反,他们会返回一个持有结果的新Stream
 *          Stream 操作是延迟执行的,这意味着他们会等到需要结果的时候才执行
 */
@SuppressWarnings("all")//关闭警告
public class StreamAPI {
    private void streamInstantiation(){//Stream流的创建
        //通过集合创建
        ArrayList<String> strings = new ArrayList<>();
        //default Stream<E> stream():返回一个顺序流
        Stream<String> stream1 = strings.stream();
        //default Stream<E> parallelStream():返回一个并行流
        Stream<String> stream2 = strings.parallelStream();

        //通过数组创建
        int[] a = {1,2,3,4,5};
        String[] as = {"12","21"};
        //static<T> Stream<T> stream(T[] array):返回一个流
        IntStream stream3 = Arrays.stream(a);
        Stream<String> stream4 = Arrays.stream(as);


        //通过Stream的of()创建
        Stream<Integer> Stream5 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> Stream6 = Stream.of(null, null);//of里可以有null
//        Stream<Integer> Stream7 = Stream.of(null);//但不能只有一个null,只有一个null会抛出空指针异常

        //创建无限流
        //迭代  public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        //生成  public static<T> Stream<T> generate(Supplier<? extends T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        System.out.println("-----------------------");

    }
    private void streamIntermediate(){//Stream流的中间操作
        String[] as = {"1","233","271","4399","998","996","996","996","999","110"};
        Stream<String> stream = Arrays.stream(as);

        stream.filter(e -> e.contains("1")).forEach(System.out::println);//筛选带有1的字符串,filter过滤
        System.out.println("-----------------------");//一旦使用了foreach这种终止操作,stream就会关闭

        Arrays.stream(as).limit(3).forEach(System.out::println);//截断流,使其元素不超过给定的数量,.limit限制
        System.out.println("-----------------------");

        Arrays.stream(as).skip(3).forEach(System.out::println);//跳过前n个元素,若流中不足n个,则返回空,skip跳过
        System.out.println("-----------------------");

        Arrays.stream(as).distinct().forEach(System.out::println);//通过元素的hashcode()和equals()方法去除重复元素,distinct去重
        System.out.println("-----------------------");

        Arrays.stream(as).map(Integer::parseInt).forEach(System.out::println);//映射,接受一个函数作为参数,将元素转换成其他信息
        System.out.println("-----------------------");

        Arrays.stream(as).sorted().forEach(System.out::println);//按照自然顺序排序,sorted排序
        System.out.println("-----------------------");

        Arrays.stream(as).sorted(Comparator.comparingInt(Integer::parseInt)).forEach(System.out::println);//按照规则定制排序,sorted排序
        System.out.println("-----------------------");

    }
    private void streamTerminate(){//Stream流的终止操作
        Integer[] as = {12,26,33,1,233,4399,996,996,996,999};

        Arrays.stream(as).forEach(System.out::println);//内部迭代
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).allMatch(s -> s.equals(1)));//检查是否匹配所有元素(所有元素中是否都是1)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).anyMatch(s -> s.equals(1)));//检查是否至少匹配一个元素(所有元素中是否至少含有一个1)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).noneMatch(s -> s.equals(1)));//检查是否没有匹配所有元素(所有元素中是否都有没有1)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).sorted().findFirst());//返回第一个元素,中间可以排个序啥的
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).findAny());//返回任意一个元素(因为是串行流,所以会按顺序取,改成parallelStream就不同了)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).count());//返回元素的个数
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).max(Comparator.naturalOrder()));//返回元素的最大值
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).min(Comparator.naturalOrder()));//返回元素的最小值
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).reduce(0,Integer::sum));//归约,将流中的元素反复结合起来,得到一个值,经常和map一起用(例子是计算所有元素的合)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).reduce(Integer::sum));//归约,将流中的元素反复结合起来,得到一个Optional<T>(例子是计算所有元素的合)
        System.out.println("-----------------------");

        System.out.println(Arrays.stream(as).collect(Collectors.toList()));//收集,将流转换为其他形式(例子转换为list)
        System.out.println("-----------------------");



    }
    public void test(){
        streamInstantiation();//流的创建
        streamIntermediate();//中间操作
        streamTerminate();//终止操作
    }
}
