package mergesort;

import java.util.Arrays;

/**
 * 归并排序的递归实现
 *
 * @author liupfde
 */
public class MergeSort {
    public static void main(String args[]) {
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 递归使用归并排序 对arr[l...r]的范围进行排序
     * 边界问题一定要定义清楚
     */
    private static void mergeSort(int[] arr, int l, int r) {

        //提前创建好数组 避免递归时频繁创建新的数组
        int temp[] = new int[arr.length];
        //左边指针值小于右边才继续执行
        if (l < r) {
            int mid = (l + r) / 2;
            //对左部分进行递归排序
            mergeSort(arr, l, mid);
            //对右部分进行递归排序
            mergeSort(arr, mid + 1, r);
            //对最后拍好序的两段进行从l到mid到r的排序
            __merge(arr, l, mid, r, temp);

            //System.out.println(Arrays.toString(arr));
        }
    }

    private static void __merge(int[] arr, int l, int mid, int r, int[] temp) {

        //初始化,i指向左半部分的起始索引位置l;j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        //指向原数组的第一个值
        int t = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            }
        }

        //把左边剩余的移入数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //把右边剩余的移入数组
        while (j <= r) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (l <= r) {
            arr[l++] = temp[t++];
        }
    }
}
