package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 桶排序
 */
public class BucketSort {
    private static final InsertionSort insertionSort = new InsertionSort();

    private int[] smallToLarge(int[] a, int bucketSize) {
        if (a.length == 0) return a;
        int minValue = a[0];
        int maxValue = a[0];
        for (int value : a) {//找到最大最小值
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int j : a) {
            int index = (int) Math.floor((j - minValue) / bucketSize);
            buckets[index] = arrayAppend(buckets[index], j);
        }
        int aIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertionSort.smallToLarge(bucket);
            for (int value : bucket) {
                a[aIndex++] = value;
            }
        }
        return a;
    }
    private int[] arrayAppend(int[] a, int value) {//自动扩容，并保存数据
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
        System.out.println(Arrays.toString(smallToLarge(a,5)));
    }
}
