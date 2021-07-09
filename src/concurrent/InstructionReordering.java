package concurrent;


import java.util.HashSet;

/**
 * 指令重排现象
 */
public class InstructionReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;
    public void test() throws InterruptedException {
        HashSet<String> set = new HashSet<>();
        while (true){
            Thread A = new Thread(()->{
                a = 1;
                x = b;
            });

            Thread B = new Thread(()->{
                b = 1;
                y = a;
            });

            A.start();
            B.start();
            A.join();
            B.join();

            set.add("(" + x + "," + y + ")");
            System.out.println(set);
            x = 0;
            y = 0;
            a = 0;
            b = 0;
        }
    }
}
