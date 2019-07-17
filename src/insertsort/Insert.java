package insertsort;

import java.util.Arrays;

/**
 * @author liupfde
 */
public class Insert {
    public static void main(String args[]){
        int[] a = {1,7,2,8,4};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length;i++){
            //两种写法
//            int t = arr[i];
//            int j = i;
//            for (; j > 0 && t < arr[j-1]; j--){
//                arr[j] = arr[j-1];
//            }
//            arr[j] = t;

            for (int k = i; k > 0; k--) {
                if (arr[k] < arr[k-1]){
                    int temp = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
