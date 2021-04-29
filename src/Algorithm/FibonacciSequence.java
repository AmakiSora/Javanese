package Algorithm;

import java.util.Arrays;

/**
 * 斐波那契数列
 */
public class FibonacciSequence {
    public int[] getArray(int n){//斐波那契数组,空间复杂度O(N)
        int[] fib = new int[n + 1];
        if (n<1){
            fib[0]=0;
            return fib;
        }else if (n==1){
            fib[0]=0;
            fib[1] = 1;
            return fib;
        }else {
            fib[1] = 1;
            for (int i = 2; i <= n; i++){
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib;
        }
    }
    public int getN(int n){//三变量求第n个数,空间复杂度O(1)
        if (n <= 1){return n;}
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
    public void test(){//测试用
        System.out.println(Arrays.toString(getArray(20)));
        System.out.println(getN(14));
    }
}
