package sword;

/**
 * @author :liupf
 * @description :对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *               例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * @date :2019/04/18 23:33
 **/
public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString(str, 3));
    }

    public static String leftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }

        String s1 = str.substring(0, n);
        System.out.println(s1);
        String s2 = str.substring(n);
        return s2 + s1;
    }
}
