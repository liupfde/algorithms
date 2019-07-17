package shuffle;

import java.util.Random;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/03/28 11:59
 **/
public class Shuffle {
    public static void main(String[] args) {

    }

    public static int[] shuffle(int[] arr) {
        int[] array = new int[arr.length];
        int count = arr.length;
        // 索引
        int cbRandCount = 0;
        // 位置
        int cbPosition;
        int k = 0;
        Random rand = new Random();
        do {
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            array[k++] = arr[cbPosition];
            cbRandCount++;
            // 将最后一位数值赋值给已经被使用的cbPosition
            arr[cbPosition] = arr[r - 1];
        } while (cbRandCount < count);
        return array;
    }
}
