package sword;

import java.util.ArrayList;

/**
 * @author :liupf
 * @description :小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *               但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *               没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *               现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @date :2019/04/16 23:36
 **/
public class FindContinuousSequence {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        if (sum < 3) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(16);

        int plow = 1, phigh = 2;
        while (plow < phigh) {
            int n = (plow + phigh) * (phigh - plow + 1) / 2;
            if (n == sum) {
                ArrayList<Integer> list = new ArrayList<>(16);
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                lists.add(list);
                plow++;
            } else if (n < sum) {
                phigh++;
            } else {
                plow++;
            }
        }

        return lists;
    }
}
