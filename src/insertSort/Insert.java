package insertSort;

public class Insert {
    public static void main(String args[]){
        int a[] = {0,4,23,1,5,76,34,2,2,2,13,78};
        insertSort(a);
    }

    public static void insertSort(int a[]){

        String str = a.toString();
        for(int i = 1;i<a.length;i++){
            if(a[i-1]>a[i]){        //前一个数比后一个数大
                /*int target = a[i];  //设置哨兵，判断何时退出循环
                int j;
                for(j=i-1;a[j]>target;j--){  //!数组越界问题 为优化性能 不采取每次做判断的处理方式
                更新 新写的代码有问题 所以如果要采用以上代码 或许必须需要加一次检查指令判断j>0 或者强行在代码前加上0(如果数据中有负数也不行 数组越界)
                    a[j+1] = a[j];  //记录后移  将前一个值赋给后一个值
                }
                a[j+1] = target;*/

//                int target = a[i];  //设置哨兵，判断何时退出循环
//                int j;
//                for(j=i-1;a[j]>target;j--){
//                    a[j+1] = a[j];  //记录后移  将前一个值赋给后一个值
//                }
//                a[j+1] = target;

                /**
                 * 在排序时 把元素第一个强行设置为0 或者其他合适的数字
                 * 这样做不仅可以防止元素中有正数时数组越界，也可以防止元素中有负数时的数组越界问题
                 *
                 * 如此排序后 输出数组的第一个元素其实是排序后的最后一个元素
                 * 因此 插入排序时的操作应为 先把得到的数组 加入头一个元素，排序完成后 删除最后一个元素 (如此使用List集合比较方便)
                 * 完美解决问题
                 */
                a[0] = a[i];
                int j;
                for(j=i-1;a[j]>a[0];j--){
                    a[j+1] = a[j];
                }
                a[j+1] = a[0];
                for (int x:a){
                    System.out.print(x+" ");
                }
                System.out.println(" ");
            }
        }
    }
}
