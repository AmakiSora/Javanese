package other;

/**
 * 泛型
 * 常用泛型标识: T,E,K,V
 * 泛型支持包装类(String,Integer,...),不支持基本数据类型(int,char,...)
 *
 * 泛型类
 * class 类名<泛型标识,泛型标识,...>{
 *     private 泛型标识 变量名;
 * }
 *
 * 泛型接口
 * interface 接口名  <泛型标识,泛型标识,...>{
 *     泛型标识 方法名();
 * }
 *
 * 泛型方法
 * 修饰符 <T,E,...> 返回值类型 方法名(形参列表){
 *     方法体
 * }
 */
public class Generics {
    //泛型接口
    private interface GenericInterface<T>{
        //实现类不是泛型类,接口要明确数据类型
        //实现类也是泛型类,实现类类至少要有一个和接口的泛型类型一致
    }
    //泛型类
    public class Generic<T> implements GenericInterface<T>{

        private T key;

        //泛型方法
        public T getKey() {
            return key;
        }

        //泛型方法
        public <T> String getSome(){
            return "233";
        }
    }

    //子类也是泛型类,子类至少要有一个和父类的泛型类型一致
    class ChildGeneric1<T,E> extends Generic<T>{}

    //子类不是泛型类,父类要明确泛型的数据类型
    class ChildGeneric2 extends Generic<String>{}

    public void test(){

        //如果没有指定具体数据类型,则操作类型是Object
        Generic<String> genericStr = new Generic<>();
        genericStr.key = "ABC";
        System.out.println(genericStr.getKey());
        System.out.println(genericStr.getClass());

        Generic<Integer> genericInt = new Generic<>();
        genericInt.key = 123;
        System.out.println(genericInt.getKey());
        System.out.println(genericInt.getClass());

        //泛型类根据不同数据类型创建对象,但本质上是同一类型
        System.out.println(genericStr.getClass()==genericInt.getClass());

    }
}
