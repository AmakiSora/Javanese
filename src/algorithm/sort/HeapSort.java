package algorithm.sort;

import datastructure.Heap_;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 */
public class HeapSort {
    public int[] smallToLarge(int[] a){
        Heap_ heap = new Heap_(true,a);
        int c = heap.getHeap().length;
        for (int i = c - 1; i > 0; i--) {
            heap.exchange(0, i);
            c--;
            heap.maxHeapify(0, c);
        }
        return a;
    }
    public void test(){
        int sum = 20;
        int[] a = new int[sum];
        for (int i = 0; i < sum; i++) {
            a[i] = new Random().nextInt(sum);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(smallToLarge(a)));
    }
}
