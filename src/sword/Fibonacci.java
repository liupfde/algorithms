package sword;

/**
 * @author :liupf
 * @description :求第n个斐波那契数  若用递归则n过大时会造成堆栈溢出
 * 使用动态规划 只保留最后两个数  得出最后结果
 * @date :2019/02/21 20:41
 **/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(12));
    }

    public static int fib(int n){
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int fn1 = 0;
        int fn2 = 1;
        int result = 0;

        for (int i = 2; i < n; i++) {
            result = fn1 + fn2;
            fn1 = fn2;
            fn2 = result;
        }
        return result;
    }
}
