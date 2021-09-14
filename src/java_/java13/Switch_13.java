package java_.java13;

/**
 * Switch
 * java13新特性
 */
@SuppressWarnings("all")
public class Switch_13 {
    private void oldJavaVersion() {
        String x = "3";
        int i;
        switch (x) {
            case "1":
                i = 1;
                break;
            case "2":
                i = 2;
                break;
            default:
                i = x.length();
        }
        System.out.println(i);
    }
    private void java13Version() {
        String x = "3";
        int i = switch (x) {
            case "1" : yield 1;//yield关键字表示返回给i的值(和return不一样)
            case "2" : yield 2;
            default : {//长的表达式可以用{}来表示了->{}也可以
                yield i = x.length();
            }
        };
        System.out.println(i);
    }
    public void test() {
        oldJavaVersion();
        java13Version();
    }

    enum ABC {
        A, B, C, D, E, F, G
    }
}
