package sword;

import java.util.*;

/**
 * @author :liupf
 * @description :请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *               例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *               当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *               如果当前字符流没有存在出现一次的字符，返回#字符。
 * @date :2019/04/30 10:04
 **/
public class FirstAppearingOnce {
    public static void main(String[] args) {
        String str = "google";
        FirstAppearingOnce fao = new FirstAppearingOnce();
        fao.insert(str);
        char c = fao.firstAppearingOnce();
        System.out.println(c);
    }

    Map<Character, Integer> map = new HashMap<>(128);
    Queue<Character> queue = new LinkedList<>();
    public void insert(String ch) {
        if (ch == null || ch.length() == 0) {
            return;
        }
        for (int i = 0; i < ch.length(); i++) {
            if (!map.containsKey(ch.charAt(i))) {
                map.put(ch.charAt(i), 1);
            } else {
                map.put(ch.charAt(i), map.get(ch.charAt(i)) + 1);
            }

            if (map.get(ch.charAt(i)) == 1) {
                queue.add(ch.charAt(i));
            }
        }

    }

    public char firstAppearingOnce() {
        while (!queue.isEmpty() && map.get(queue.peek()) >= 2) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            return '#';
        }

        return queue.peek();
    }

    /**
     * 第二种做法
     */

    Map<Character, Integer> lMap = new LinkedHashMap<>(16);
    public void insert0(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, 1);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    public char firstAppearingOnce0() {
        for (Map.Entry<Character, Integer> entry : lMap.entrySet()){
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '#';
    }
}
