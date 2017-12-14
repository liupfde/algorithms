package bubble_sort;

/**
 * 冒泡排序的改进
 *
 * 通过设置标志变量来记录是否发生了数据交换
 * 如果进行排序时并未发生数据交换，说明顺序已排好 立即结束排序
 * 避免不必要的时间消耗
 */
public class Change_BubbleSort {
    public static void change_bubble_sort(int arr[]){
        int i = arr.length-1;
        while(i>0){
            int change;//设置标志
            for (int j = 0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    change = j;//记录最后一次交换的位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }else {
                    change = 0;//如果是排好序的就退出循环
                }
                i = change;//因为最后一次的位置后肯定是排序好的 下一次扫描到最后依次的位置就停下来
            }
            for(int x = 0;x<arr.length;x++){
                System.out.print(arr[x]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[] = {12,34,4,21,98,15,43,2};
        change_bubble_sort(arr);
        System.out.println("----------------------");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/**
 *这个改进的算法还有一些 bug 目前能力有限  留待日后解决
 */