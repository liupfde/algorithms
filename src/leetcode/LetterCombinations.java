package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/07/16 15:00
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "234";
        //System.out.println(letterCombinations(digits).size());
    }

    static String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static StringBuilder sb = new StringBuilder();
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(27);

        if (digits == null || digits.length() == 0) {
            return res;
        }

        combinations(digits, 0, res);

        return res;
    }

    private static void combinations(String digits, int n, List<String> res) {
        if (n == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < numbers[digits.charAt(n) - '0'].length(); i++) {
            sb.append(numbers[digits.charAt(n) - '0'].charAt(i));
            combinations(digits, n + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
