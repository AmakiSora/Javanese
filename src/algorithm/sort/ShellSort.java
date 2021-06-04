package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 */
public class ShellSort {
    public int[] smallToLarge(int[] a){
        int length = a.length;
        int b;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                b = a[i];
                int j = i - step;
                while (j >= 0 && a[j] > b) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = b;
            }
        }
        return a;
    }
    public void test(){
        int sum = 100;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(smallToLarge(a)));
    }
}
