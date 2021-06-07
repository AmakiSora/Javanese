package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 */
public class CountingSort {
    public int[] smallToLarge(int[] a,int maxValue){
        int size = maxValue + 1;//防止越界
        int[] b = new int[size];
        for (int value : a) {
            b[value]++;
        }
        int Index = 0;
        for (int j = 0; j < size; j++) {
            while (b[j] > 0) {
                a[Index++] = j;
                b[j]--;
            }
        }
        return a;
    }
    public void test() {
        int sum = 30;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(smallToLarge(a,sum)));
    }
}
