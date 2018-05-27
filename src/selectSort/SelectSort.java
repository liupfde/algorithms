package selectSort;
/**
 * 简单的选择排序
 * author liupf
 *
 * 多次比较，一次交换
 */
public class SelectSort {
    public static void main(String args[]){
        int a[] = {1,23,4,5,76,34,2,2,2,13,78};
        selectSort(a);
    }

    public static void selectSort(int s[]){

        int min;
        int length = s.length;
        for(int i=0;i<length;i++){

            min = i;//当前最小值的下标
            //先进行多次比较，找出最小的值
            for(int j = i+1;j<length;j++){
                if (s[j]<s[min]) {
                    min = j;//将本次比较最小值的下标赋给min
                }
            }
            //交换数据
            if(i<min){
                int temp = s[i];
                s[i] = s[min];
                s[min] = temp;
            }
        }

        for (int i:s) {
            System.out.print(i+" ");
        }
    }
}
