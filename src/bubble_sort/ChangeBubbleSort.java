package bubble_sort;

import java.util.Arrays;

/**
 * 冒泡排序的改进
 *
 * 通过设置标志变量来记录是否发生了数据交换
 * 如果某一次程序进行排序时并未发生数据交换，说明顺序已排好 立即结束排序
 * 避免不必要的 比较 时间消耗
 * @author liupfde
 */
public class ChangeBubbleSort {
    public static void change_bubble_sort(int[] arr) {
        //设置标记
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = arr.length - 2; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
        }
    }
    public static void main(String args[]){
        int[] arr = {1,23,4,5,76,34,2,2,2,13,78};
        change_bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}