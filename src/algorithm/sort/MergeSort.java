package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {
    public int[] separate(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(separate(left), separate(right));
    }
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
    public void test() {
        int sum = 10;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(separate(a)));
    }
}
