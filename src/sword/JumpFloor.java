package sword;

import java.util.Stack;

/**
 * @author :liupf
 * @description :一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *               求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *               解: 实际上是一个斐波那契数列 f(n) = f(n-1)(第一次跳一个台阶则剩余台阶的跳法) +
 *                                              f(n-2)(第一次跳两个台阶则剩余台阶的跳法)
 * @date :2019/02/21 22:07
 **/
public class JumpFloor {
    public static void main(String[] args) {

    }

    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int fn1 = 1;
        int fn2 = 2;
        int result = 0;

        for (int i = 3; i <= target; i++) {
            result = fn1 + fn2;
            fn1 = fn2;
            fn2 = result;
        }
        return result;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()){
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();

    }
}
