package leetcode;

/**
 * @author :liupf
 * @description :给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @date :2019/04/09 20:41
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("noonbobob"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length();) {
            if (s.length() - i <= maxLen / 2) {
                break;
            } else {
                int left = i, right = i;
                while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(right)) {
                    right++;
                }
                i = right + 1;
                while (right < s.length() - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                    right++;
                    left--;
                }
                if (maxLen <= right - left + 1) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static String longestPalindromeDP(String s) {
        return null;
    }
}
