package dp;

/**
 * @author :liupf
 * @description :TODO
 * @date :2018/12/20 14:35
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int res = rob(nums);
        System.out.println(res);
    }

    public static int[] memory;

    public static int rob(int[] nums) {
        memory = new int[nums.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        return tryRob(nums,0);
    }

    private static int tryRob(int[] nums, int index){
        if (index >= nums.length){
            return 0;
        }
        if (memory[index] != -1){
            return memory[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memory[index] = res;
        return res;
    }

    public static int rob1(int[] nums){
        int length = nums.length;
        memory = new int[length];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        if (nums.length == 0){
            return 0;
        }
        memory[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                memory[i] = Math.max(memory[i], nums[j] + (j + 2 < length ? memory[j + 2] : 0));
            }
        }
        return memory[0];
    }
}
