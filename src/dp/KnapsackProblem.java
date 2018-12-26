package dp;

/**
 * @author :liupf
 * @description :0-1 背包问题
 * @date :2018/12/21 19:35
 **/
public class KnapsackProblem {
    public static void main(String[] args) {

    }

    public static int[][] memory;
    public static int knapasck(int[] w, int[] v, int c){
        int n = w.length;
        //根据状态转移方程得出 两个参数 初始化为-1
        memory = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                memory[i][j] = -1;
            }
        }
        return bestValue(w, v, n - 1, c);
    }

    /**
     * 记忆化搜索 自顶向下
     * @param w 重量
     * @param v 价值
     * @param index 编号
     * @param c 背包剩余重量
     * @return
     */
    private static int bestValue(int[] w, int[] v, int index, int c){
        if (index < 0 || c <= 0){
            return 0;
        }

        if (memory[index][c] != -1){
            return memory[index][c];
        }

        //第一种选择: 当前物品不放入背包
        int res = bestValue(w,v,index - 1,c);

        //第二种选择: 当前物品放入背包
        if (c >= w[index]){
            res = Math.max(res,v[index] + bestValue(w,v,index - 1,c));
        }
        memory[index][c] = res;
        return res;
    }

    /**
     * 动态规划 自底向上解决
     * @param w
     * @param v
     * @param c
     * @return
     */
    public static int knapasck01(int[] w, int[] v, int c) {
        assert (w.length == v.length);
        int n = w.length;

        if (n == 0) {
            return 0;
        }

        memory = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                memory[i][j] = -1;
            }
        }

        //先考虑最底部问题 即第一行中背包物品最大值
        for (int j = 0; j <= c; j++) {
            memory[0][j] = j >= w[0] ? v[0] : 0;
        }

        //接着考虑剩下物品
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                //第一种策略: 不放入当前物品
                memory[i][j] = (memory[i - 1][j]);
                //第二种策略: 放入当前物品
                if (j >= w[i]) {
                    memory[i][j] = Math.max(memory[i - 1][j], v[i] + memory[i - 1][j - w[i]]);
                }
            }
        }
        return memory[n - 1][c];
    }
}
