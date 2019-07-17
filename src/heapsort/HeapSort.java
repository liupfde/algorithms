package heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String args[]){
        int a[] = {16,14,10,8,7,9,3,2,4,1};
        heapSort1(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort0(int[] arr){
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for(int i = 0;i<arr.length;i++){
            maxHeap.insert(arr[i]);
        }

        for (int i = arr.length-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void heapSort1(int[] arr){
        MaxHeap maxHeap = new MaxHeap(arr,arr.length);
        for(int i = arr.length-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }
}
