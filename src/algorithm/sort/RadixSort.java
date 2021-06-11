package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 基数排序
 */
public class RadixSort {
    public int[] smallToLarge(int[] a){
        int maxDigit = getMaxDigit(a);
        return radixSort(a, maxDigit);
    }
    private int getMaxDigit(int[] a) {//获取最高位数
        int maxValue = getMaxValue(a);
        return getNumLenght(maxValue);
    }
    private int getMaxValue(int[] a) {//获取最大值
        int maxValue = a[0];
        for (int value : a) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] a, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < a.length; j++) {
                int bucket = ((a[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], a[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    a[pos++] = value;
                }
            }
        }
        return a;
    }
    private int[] arrayAppend(int[] a, int value) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = value;
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
