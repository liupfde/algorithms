package sword;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/04/19 09:57
 **/
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "student. a am I";
        String s = reverseSentence(str);
        System.out.println(s);
    }

    public static String reverseSentence(String str) {
        if (str == null) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);

        return new String(chars);
    }

    private static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++; r--;
        }
    }
}
