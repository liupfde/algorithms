package sword;

/**
 * @author :liupf
 * @description :将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 *               要求不能使用字符串转换整数的库函数。
 *               数值为0或者字符串不是一个合法的数值则返回0。
 * @date :2019/04/23 22:45
 **/
public class StrToInt {
    public static void main(String[] args) {
        String str = "-2147483648";
        System.out.println(strToInt(str));
    }

    public static int strToInt(String str) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }

        //判断第一个字符是不是标志符号 "+"或者"-"  1:是符号 0:不是符号
        int start = 0;
        //是否是负数标志  0:正数  1:负数
        int symbol = 0;

        char[] chars = str.toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }

        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }

            int sum = result * 10 + (chars[i] - '0');
            //判断是否是整型溢出  例如,3*10+5=35,如果(35-5)/10不等于3，那么久产生了溢出
            if ((sum - (chars[i] - '0')) / 10 != result) {
                return 0;
            }

            result = result * 10 + (chars[i] - '0');

        }

        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }
}
