package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author :liupf
 * @description :给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *               例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *               他们的最大值分别为{4,4,6,6,6,5}；
 *               针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *               {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *               {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @date :2019/06/11 21:02
 **/
public class MaxInWindows {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindowsUpgrade(num, 3));
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>(16);
        if (size > num.length || size == 0) {
            return list;
        }

        for (int i = 0; i <= num.length - size; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < size; j++) {
                set.add(num[i + j]);
            }
            list.add(set.last());
        }

        return list;
    }

    public static ArrayList<Integer> maxInWindowsUpgrade(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>(16);
        if (size > num.length || size == 0) {
            return list;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(0);
        for (int i = 1; i < size; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.peekFirst()]) {
                queue.pollLast();
            }

            queue.push(i);
        }

        for (int i = size; i < num.length; i++) {
            list.add(queue.peekFirst());

            while (!queue.isEmpty() && num[i] >= num[queue.peekFirst()]) {
                queue.pollLast();
            }

            if (!queue.isEmpty() && queue.peekFirst() <= i - size) {
                queue.pollFirst();
            }

            queue.push(i);
        }
        list.add(queue.peekFirst());

        return list;
    }
}
