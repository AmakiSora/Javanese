package java_.java9;

import java.util.*;

/**
 * 集合的不可变实例(只读集合)
 * 变成只读集合后不能进行增删改,会抛出UnsupportedOperationException异常
 * java9新特性更简洁快速的创建
 */
@SuppressWarnings("all")
public class UnmodifiableCollections {
    private void oldjavaVersion() {
        List<String> a = new ArrayList<>();
        a.add("a");
        a = Collections.unmodifiableList(a);
        System.out.println(a);

        Set<Integer> s = Collections.unmodifiableSet(new HashSet<>());
        System.out.println(s);

        List<Integer> l = Arrays.asList(1, 2, 3);//其实直接这样创建也是只读集合
        System.out.println(l);
    }

    private void java9Version() {
        List<String> a = List.of("a", "b", "c");
        System.out.println(a);

        Set<Integer> s = Set.of(1,2,3);
        System.out.println(s);

        Map<String, Integer> m = Map.of("name", 233, "id", 101);
        System.out.println(m);

        Map<String, Integer> n = Map.ofEntries(Map.entry("name", 996), Map.entry("id", 1));
        System.out.println(n);
    }

    public void test() {
        oldjavaVersion();
        java9Version();
    }
}
