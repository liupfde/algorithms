package leetCode.array;

import java.util.Arrays;

/**
 * leetCode第167号题目
 *
 */
public class TwoSum {
    public static void main(String args[]){
        int arr[] = {1,2,3,5,6,9,12,23,24};
        twoSum(arr,12);

    }

    /**
     * 使用对撞指针解决
     * @param arr
     */
    public static int[] twoSum(int arr[],int target) {
        int l = 0, r = arr.length-1;
        if (arr == null || arr.length == 0) {
            return null;
        }
        while(l<r){
            for (int i = 0; i < arr.length; i++) {
                if (arr[l] + arr[r] == target) {
                    int nums[] = {l+1,r+1};
                    return nums;
                } else if (arr[l] + arr[r] < target) {
                    l++;
                } else if (arr[i] + arr[r] > target) {
                    r--;
                }
            }
        }
        return null;
    }
}
