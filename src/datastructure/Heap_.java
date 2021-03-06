package datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆(数组实现的完全二叉树)
 */
public class Heap_ {
    private final int[] heap;
    private final int size;
    public Heap_(int...a){//默认大顶堆
        size = a.length;
        heap = a;
        buildMaxHeap();
    }
    public Heap_(Boolean b,int...a){
        size = a.length;
        heap = a;
        if (b) buildMaxHeap();//true为大顶堆
        else buildMinHeap();//false为小顶堆
    }
    public void show(){
        System.out.println(Arrays.toString(heap));
    }
    public int[] getHeap(){
        return heap;
    }
    private void buildMaxHeap() {//大顶堆
        for (int i = (int) Math.floor(size / 2); i >= 0; i--) {
            maxHeapify(i,size);
        }
    }
    private void buildMinHeap() {//小顶堆
        for (int i = (int) Math.floor(size / 2); i >= 0; i--) {
            minHeapify(i,size);
        }
    }
    public void maxHeapify(int i,int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < size && heap[left] > heap[max])
            max = left;
        if (right < size && heap[right] > heap[max])
            max = right;
        if (max != i) {
            exchange(i, max);
            maxHeapify(max,size);
        }
    }
    public void minHeapify(int i,int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        if (left < size && heap[left] < heap[min])
            min = left;
        if (right < size && heap[right] < heap[min])
            min = right;
        if (min != i) {
            exchange(i, min);
            minHeapify(min,size);
        }
    }
    public void exchange(int a, int b){
        int c = heap[a];
        heap[a] = heap[b];
        heap[b] = c;
    }
    public void test(){
        int x = 20;
        int[] a = new int[x];
        for (int i = 0; i < x; i++)
            a[i] = new Random().nextInt(100);
//        Heap_ h = new Heap_(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        Heap_ h = new Heap_(false,a);
        h.show();
    }

}

