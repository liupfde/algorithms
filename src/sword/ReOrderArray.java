package sword;

import java.util.Arrays;

/**
 * @author :liupf
 * @description :输入一个整数数组,实现一个函数来调整该数组中数字的顺序,使得所有的奇数位于数组的前半部分,
 *               所有的偶数位于数组的后半部分,并保证奇数和奇数,偶数和偶数之间的相对位置不变。
 * @date :2019/02/22 22:02
 **/
public class ReOrderArray {
    public static void main(String[] args) {
        int[] array = {2};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reOrderArray(int[] array) {

        if (array.length == 0) {
            return;
        }

        //奇数
        int odd = 0;
        //偶数
        int even = 0;

        int k = 0;
        while (array[k] % 2 != 0) {
            k++;
            if (k == array.length) {
                return;
            }
        }

        //第一个偶数
        even = k++;

        if (k == array.length) {
            return;
        }

        while (array[k] % 2 == 0) {
            k++;
            if (k == array.length) {
                return;
            }
        }

        //第一个偶数后的第一个奇数
        odd = k;

        int o = odd;
        int temp = array[odd];
        while (o != even) {
            array[o] = array[o-- - 1];
        }
        array[even] = temp;

        for (int j = odd; j < array.length; j++) {
            int t = j;
            while (array[t] % 2 != 0 && array[t - 1] % 2 == 0 && t > 0) {
                int p = array[t];
                array[t] = array[t - 1];
                array[t - 1] = p;
                t--;
            }
        }

    }
}
