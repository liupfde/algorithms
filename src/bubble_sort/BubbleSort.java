package bubble_sort;

/**
 * 冒泡排序，从第一个元素开始，依次比较相邻两个元素的大小
 * 最终选出最大(小)的排在最后
 * 设有n元素,则第一次比较n-1次
 *
 * @author liupfde
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //因为每排序好一个元素，就相当于下一次少排序依次，所以在这里要 减 i!
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    for (int a : arr) {
                        System.out.print(a + " ");
                    }
                    System.out.println("--------------");
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 23, 4, 5, 76, 34, 2, 2, 2, 13, 78};
        bubbleSort(arr);
    }
}
