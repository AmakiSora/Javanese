package java_.java12;

/**
 * Switch
 * java12新特性
 *
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
                num = 2;
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

    private void java12Version() {
        int num;
        ABC abc = ABC.A;
         num = switch (abc) {
            case A -> 1;
            case B, C, D -> 2;
            case E, F, G -> 3;
            default -> 4;
        };
        System.out.println(num);
    }

    public void test() {
        oldJavaVersion();
        java12Version();
    }

    enum ABC {
        A, B, C, D, E, F, G
    }
}
