package sword;

/**
 * @author :liupf
 * @description :{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *               给一个数组，返回它的最大连续子序列的和，
 * @date :2019/03/04 19:34
 **/
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {

    }
    public int findGreatestSumOfSubArray(int[] array) {
        /** 当前数组和当前值比较的最大值*/
        int res = array[0];
        /** 连续子数组和的最大值*/
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i],max + array[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}
