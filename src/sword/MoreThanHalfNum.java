package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liupf
 * @description :数组中出现次数超过一半的数字
 * @date :2019/03/04 15:27
 **/
public class MoreThanHalfNum {
    public static void main(String[] args) {
        System.out.println(9 / 2);
    }

    public int moreThanHalfNum(int [] array) {

        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else {
                int t = map.get(array[i]) + 1;
                if (t > array.length / 2) {
                    return array[i];
                } else {
                    map.put(array[i], t);
                }
            }
        }
        return 0;
    }
}
