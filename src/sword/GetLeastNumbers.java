package sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author :liupf
 * @description :输入n个整数，找出其中最小的K个数。
 *               例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @date :2019/03/04 19:23
 **/
public class GetLeastNumbers {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (input.length == 0 || k <= 0 || k > input.length) {
            return list;
        }
        int length = input.length;
        PriorityQueue<Integer> integers = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < length; i++) {
            if (integers.size() < k) {
                integers.offer(input[i]);
            } else if (input[i] < integers.peek()) {
                Integer temp = integers.poll();
                temp = null;
                integers.offer(input[i]);
            }
        }
        for (Integer integer : integers) {
            list.add(integer);
        }
        return list;
    }
}
