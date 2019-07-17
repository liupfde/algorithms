package sword;

import java.util.HashMap;

/**
 * @author :liupf
 * @description :统计一个数字在排序数组中出现的次数。
 * @date :2019/04/11 21:41
 **/
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {3,3,3,3,4,5};
        System.out.println(getNumberOfK(array, 3));

    }

    public static int getNumberOfK(int[] array , int k) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }

        int p = getPOfK(array, 0, array.length - 1, k);

        int l = p - 1, r = p + 1;
        int num = 1;
        while (l >= 0 && array[l] == k) {
            l--;
            num++;
        }
        while (r <= array.length - 1 && array[r] == k) {
            r++;
            num++;
        }
        return num;
    }

    private static int getPOfK(int[] array, int l, int r, int k) {
        int p = l + (r - l) / 2;

        if (array[p] == k) {
            return p;
        } else if (array[p] < k) {
            return getPOfK(array, p + 1, r, k);
        } else {
            return getPOfK(array, l, p - 1, k);
        }
    }
}
