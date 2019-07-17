package sword;

import java.util.ArrayList;

/**
 * @author :liupf
 * @description :输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *               如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @date :2019/04/18 10:02
 **/
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        ArrayList list = findNumbersWithSum(array, 15);
        System.out.println(list.toString());
    }

    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    return list;
                }
            }
        }

        //另一种方法 时间复杂度为O(n)
        int pl = 0, pr = array.length - 1;

        while (pl < pr) {
            if (array[pr] + array[pl] == sum) {
                list.add(array[pl]);
                list.add(array[pr]);
                return list;
            } else if (array[pl] + array[pr] < sum) {
                pl++;
            } else {
                pr--;
            }
        }

        return new ArrayList<>();
    }
}
