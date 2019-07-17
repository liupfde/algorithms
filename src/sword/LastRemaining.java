package sword;

import java.util.LinkedList;

/**
 * @author :liupf
 * @description :约瑟夫环
 * @date :2019/04/21 23:23
 **/
public class LastRemaining {
    public static void main(String[] args) {

    }

    /**使用数组模拟环 */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int[] arr = new int[n];
        int count = n , step = 0;
        int i = -1;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (arr[i] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                arr[i] = -1;
                step = 0;
                count--;
            }
        }

        return i;
    }

    /**
     * 使用链表解决约瑟夫环
     * @param n 链表的长度
     * @param m 喊到几出去
     * @return
     */
    public static int lastRemainingWithList(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }

        int k = 0;
        while (linkedList.size() > 1) {
            k = (k + m - 1) % linkedList.size();
            linkedList.remove(k);
        }

        return linkedList.get(0);
    }
}
