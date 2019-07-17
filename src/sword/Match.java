package sword;

/**
 * @author :liupf
 * @description :实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *               模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *               在本题中，匹配是指字符串的所有字符匹配整个模式。
 *               例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @date :2019/04/24 21:38
 **/
public class Match {
    public static void main(String[] args) {
        char[] str = new char[0];
        char[] pattern = new char[0];
        boolean b = match(str, pattern);
        System.out.println(b);
    }

    public static boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        int ps = 0, pp = 0;
        return match(str, ps, pattern, pp);
    }

    private static boolean match(char[] str, int ps, char[] pattern, int pp) {
        if (ps == str.length - 1 && pp == pattern.length - 1) {
            return true;
        }
        if (ps != str.length && pp == pattern.length - 1) {
            return false;
        }

        if (pattern[pp + 1] != '*') {
            if ((ps != str.length && str[ps] == pattern[pp]) || (ps != str.length && pattern[pp] == '.')) {
                return match(str, ps + 1, pattern, pp + 1);
            } else {
                return false;
            }
        } else if (pp < pattern.length - 1 && pattern[pp + 1] == '*'){
            if ((ps != str.length && str[ps] == pattern[pp]) || (ps != str.length && pattern[pp] == '.')) {
                return match(str, ps, pattern, pp + 2) || match(str, ps + 1, pattern, pp);
            } else {
                return match(str, ps, pattern, pp + 2);

            }
        }
        return false;
    }

}
