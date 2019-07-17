package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liupf
 * @description :在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *               并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 * @date :2019/03/24 23:33
 **/
public class FirstNotRepeatingChar {
    public static void main(String[] args) {

    }

    public int firstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.put(c,map.get(c) + 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
