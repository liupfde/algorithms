package insertSort;

public class Insert {
    public static void main(String args[]){
        int a[] = {1,23,4,5,76,34,2,2,2,13,78};
        insertSort(a);
    }

    public static void insertSort(int a[]){
        for(int i = 1;i<a.length;i++){
            if(a[i-1]>a[i]){        //前一个数比后一个数大
                int target = a[i];  //设置哨兵，判断何时退出循环
                int j;
                for(j=i-1;a[j]>target;j--){
                    a[j+1] = a[j];  //记录后移
                }
                a[j+1] = target;
            }
            for (int x:a){
                System.out.print(x+" ");
            }
            System.out.println(" ");
        }
    }
}
