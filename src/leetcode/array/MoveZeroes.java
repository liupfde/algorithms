package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {

    public static void main(String args[]){
        int nums[] = {12,0,6,6,0,45,0,2};
        int arr[] = {0,1,0,3,12};
        fastMoveZeroes(nums);
        for (int i:nums){
            System.out.println(i);
        }
    }

    public static void moveZeroes(int nums[]){

        if(nums==null||nums.length==0){
            return;
        }

        List list = new ArrayList();

        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }

        for(int i = 0;i<list.size();i++){
            nums[i] = (int)list.get(i);
        }

        for(int i = list.size();i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void fastMoveZeroes(int nums[]){
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                if(k!=i){
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                }else
                    k++;
            }
        }
    }
}
