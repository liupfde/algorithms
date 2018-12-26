package dp;

/**
 * @author :liupf
 * @description :
 * @date :2018/12/17 22:46
 **/
public class Fibonacci {

    static int[] memory;
    public static void main(String[] args) {
        int n = 20;
        memory = new int[n + 1];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        int res = fibo(n);
        System.out.println(res);
    }

    /**
     * 自上而下
     * 记忆化搜索  把递归中产生的大量重复数据存储起来
     * 初始化数组全部为-1 若数组中的某一个值为-1说明没有计算过 否则再进行递归
     * @param n
     * @return
     */
    public static int fib(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        if (memory[n] == -1){
            memory[n] = fib(n- 1) + fib(n - 2);
        }

        return memory[n];
    }

    /**
     * 动态规划 : 自下而上的解决问题
     * @param n
     * @return
     */
    public static int fibo(int n){
        memory[0] = 0;
        memory[1] = 1;
        for (int i = 2; i < memory.length; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
}
