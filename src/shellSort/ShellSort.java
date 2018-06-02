package shellSort;

public class ShellSort {
    public static void main(String args[]){
        int a[] = {1,23,4,5,76,34,2,2,2,13,78};
        shellSort(a);
    }

    public static void shellSort(int a[]){
        int increament = a.length;   //增量序列
        do {
            increament = increament/3 + 1;//具体情况视数据的长度而定
            for(int i = increament+1;i<a.length;i++){
                if(a[i]<a[i-increament]){
                    /*将a[i]插入有序增量子表*/
                    a[0] = a[i];
                    int j;
                    for(j = i-increament;j>0&&a[0]<a[j];j-=increament){
                        a[j+increament] = a[j];
                    }
                    a[j+increament] = a[0];
                }
            }
            for(int r : a){
                System.out.print(r+" ");
            }
            System.out.println("");
        }while (increament>1);

    }
}
