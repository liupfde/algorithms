package bubble_sort;

/**冒泡排序，从第一个元素开始，依次比较相邻两个元素的大小
 * 最终选出最大(小)的排在最后
 * 设有n元素,则第一次比较n-1次
 */
public class BubbleSort {
    public static void bubble_sort0(int arr[]){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){//因为每排序好一个元素，就相当于下一次少排序依次，所以在这里要 减 i!
                int temp;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    for (int a:arr){
                        System.out.print(a + " ");
                    }
                    System.out.println("--------------");
                }
            }
        }
    }

    /**
     * 上一个方法的等价实现
     */
    public static void bubbleSort1(int arr[]){
        for(int i = 0;i<arr.length;i++){
            for(int j = arr.length-2;j>=i;j--){//j>=i 等同于上面方法相同位置的说明
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    for(int a:arr){
                        System.out.print(a+" ");
                    }
                    System.out.println("");
                }
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {1,23,4,5,76,34,2,2,2,13,78};
        //bubble_sort0(arr);
        System.out.println("我是分割线啊啊啊啊啊啊啊啊");
        bubbleSort1(arr);
    }
}
