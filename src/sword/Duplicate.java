package sword;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/04/24 10:22
 **/
public class Duplicate {
    public static void main(String[] args) {

    }

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        int[] arr = new int[length];

        for (int i = 0; i < numbers.length; i++) {
            if (arr[numbers[i]] == 0) {
                arr[numbers[i]]++;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }
}
