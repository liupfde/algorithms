package bubble_sort;

/**
 * 冒泡排序的改进
 *
 * 通过设置标志变量来记录是否发生了数据交换
 * 如果某一次程序进行排序时并未发生数据交换，说明顺序已排好 立即结束排序
 * 避免不必要的 比较 时间消耗
 */
public class Change_BubbleSort {
    public static void change_bubble_sort(int arr[]){
        boolean flag = true;//设置标记
        for(int i = 0;i<arr.length&&flag;i++){
            flag = false;
            for(int j = arr.length-2;j>=i;j--){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
                for(int a:arr){
                    System.out.print(a+" ");
                }
                System.out.println("----------------");
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {1,23,4,5,76,34,2,2,2,13,78};
        change_bubble_sort(arr);
    }
}
/**
 *这个改进的算法还有一些 bug 目前能力有限  留待日后解决
 *
 * 重写代码，与上一次的思路有所区别
 * 现在想来 上一次的思路可能是错误的
 */