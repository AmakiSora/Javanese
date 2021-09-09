package java_.java11;

import java.util.Optional;

/**
 * Optional新增方法
 * java11新特性
 */
@SuppressWarnings("all")
public class Optional_11 {
    public void test(){
        Optional<Integer> a = Optional.of(666);//必须是非空的
        Optional<Object> b = Optional.empty();//创建一个空的Optional实例
        Optional<Integer> c = Optional.ofNullable(null);//可以为空

        //判断value是否为空
        System.out.println(a.isEmpty());
        System.out.println(b.isEmpty());
        System.out.println(c.isEmpty());

        //和isPresent结果相反
        System.out.println(a.isPresent());//判断是否包含对象,返回boolean值
        System.out.println(b.isPresent());//判断是否包含对象,返回boolean值
        System.out.println(c.isPresent());//判断是否包含对象,返回boolean值
    }
}
