package mergesort;

import java.util.Arrays;

/**
 * 归并排序的递归实现
 *
 * @author liupfde
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 5, 76, 34, 2, 2, 2, 13, 78};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归使用归并排序 对arr[l...r]的范围进行排序
     * 边界问题一定要定义清楚
     */
    public static void mergeSort(int[] arr, int l, int r) {
        int[] temp = new int[arr.length];
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            mergeSort(arr, l, mid, r, temp);
        }
    }

    private static void mergeSort(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }
            if (arr[i] >= arr[j]) {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid){
            temp[t++] = arr[i++];
        }
        while (j <= r){
            temp[t++] = arr[j++];
        }

        t = 0;
        while (l <= r){
            arr[l++] = temp[t++];
        }
    }
}
