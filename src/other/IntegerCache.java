package other;

import java.lang.reflect.Field;
import java.util.Arrays;
@SuppressWarnings("all")
public class IntegerCache {
    public void test() throws NoSuchFieldException, IllegalAccessException {
        // 获取Integer下的缓存数组
        Class cache = Integer.class.getDeclaredClasses()[0];
        // Integer内部有一个缓存数组,名叫cache,长度为256,值区间为-128到127
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        System.out.println(Arrays.stream(array).count());//cache数组的长度
//        Arrays.stream(array).forEach(System.out::println);//cache数组的所有的值
        // array[129] 的值为 1
        array[130] = array[129];
        // array[130] 的值为 2 ,现改为1
        array[131] = array[129];
        // array[131] 的值为 3 ,现改为1
        Integer a = 1;
        if(a == (Integer)1 && a == (Integer)2 && a == (Integer)3){
            System.out.println("牛逼");
        }
    }
}
