package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 */
public class SelectionSort {
    public int[] smallToLarge(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int b = a[i];
                a[i] = a[min];
                a[min] = b;
            }
        }
        return a;
    }
    public void test(){
        int sum = 10;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(smallToLarge(a)));
    }
}
