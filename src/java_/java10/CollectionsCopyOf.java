package java_.java10;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合的copyOf方法
 * 用于创建一个只读集合
 * java10新特性
 */
public class CollectionsCopyOf {
    public void test(){
        //如果本身就是只读集合,通过copyOf获得的就是本身
        var list1 = List.of(1,2,3);
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1);//true

        //如果不是只读集合,通过copyOf会获得一个新的只读集合
        var list2 = new ArrayList<Integer>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);//false
    }
}
