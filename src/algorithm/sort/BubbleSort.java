package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public int[] smallToLarge(int[] a){
        boolean isChange = false;
        for (int i = 1; i < a.length; i++) {
            isChange = false;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j+1]){
                    int b = a[j+1];
                    a[j+1] = a[j];
                    a[j] = b;
                    isChange = true;
                }
            }
            if (!isChange){ break; }
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
