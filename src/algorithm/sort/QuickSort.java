package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public int[] sort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    private int[] quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
        return a;
    }
    private int partition(int[] a, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (a[i] < a[left]) {
                exchange(a, i, index);
                index++;
            }
        }
        exchange(a, left, index - 1);
        return index - 1;
    }
    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void test() {
        int sum = 10;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sort(a)));
    }
}
