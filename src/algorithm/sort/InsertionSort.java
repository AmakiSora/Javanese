package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 */
public class InsertionSort {
    public int[] smallToLarge(int[] a){
        for (int i = 1; i < a.length; i++) {
            int b = a[i];
            int j = i;
            while (j > 0 && b < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            if (j != i) a[j] = b;
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
