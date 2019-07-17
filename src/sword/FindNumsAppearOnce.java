package sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :liupf
 * @description :一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @date :2019/04/16 23:14
 **/
public class FindNumsAppearOnce {
    public static void main(String[] args) {

    }

    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>(16);

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
            } else {
                set.remove(array[i]);
            }
        }
        num1[0] = set.iterator().next();
        set.remove(set.iterator().next());
        num2[0] = set.iterator().next();

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
