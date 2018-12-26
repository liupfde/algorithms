package dp;

import java.util.*;

/**
 * @author :liupf
 * @description :leetcode第300号题目
 * @date :2018/12/22 14:40
 **/
public class L300 {
    public static void main(String[] args) {
        int[] nums = {2,23,1,23,43,12};
        System.out.println(lengthOfLIS_violence(nums));
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int lengthOfLIS_violence(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Map<Integer,Integer> map = new HashMap<>(16);
            Integer k = 0;
            map.put(k,nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > map.get(k)){
                    if (j + 1 < nums.length && (nums[j + 1] > map.get(k) && nums[j + 1] < nums[j])){
                        map.put(++k,nums[j + 1]);
                        j++;
                    } else {
                        map.put(++k,nums[j]);
                    }
                }
            }
            set.add(k);
        }
        return set.last() + 1;
    }

}
