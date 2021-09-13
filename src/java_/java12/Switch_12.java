package java_.java12;

/**
 * Switch
 * java12新特性
 */
@SuppressWarnings("all")
public class Switch_12 {
    private void oldJavaVersion() {
        int num;
        ABC abc = ABC.A;
        switch (abc) {
            case A:
                num = 1;
            case B:
            case C:
            case D:
                num = 2;//不写break会自动跳到加一条继续执行
            case E:
            case F:
            case G:
                num = 3;
                break;
            default:
                num = 4;
        }
        System.out.println(num);
    }
/*
    private void java12Version() {
        int num;
        ABC abc = ABC.A;
         num = switch (abc) {//现在可以赋值了
            case A -> 1;//改用箭头符号
            case B, C, D -> 2;//多个相同的结果可以用逗号连接
            case E, F, G -> 3;//不写break也不会跳到下面执行
            default -> 4;
        };
        System.out.println(num);
    }
*/
    public void test() {
        oldJavaVersion();
//        java12Version();
    }

    enum ABC {
        A, B, C, D, E, F, G
    }
}
