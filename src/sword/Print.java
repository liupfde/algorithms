package sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author :liupf
 * @description :按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 *               第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *               {8,6,10,5,7,9,11}
 *               [[8],[10,6],[5,7,9,11]]
 * @date :2019/06/08 21:13
 **/
public class Print {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(16);
        if (pRoot == null) {
            return arrayLists;
        }

        //记录层数的奇偶
        int i = 1;
        //存储奇数层node的栈
        Stack<TreeNode> odd = new Stack<>();
        //存储偶数层的栈
        Stack<TreeNode> even = new Stack<>();

        odd.push(pRoot);
        while (!odd.empty() || !even.empty()) {
            if (i % 2 != 0) {
                if (!odd.empty()) {
                    ArrayList<Integer> list = new ArrayList<>(8);
                    //TODO 判空
                    while (!odd.empty()) {
                        TreeNode node = odd.pop();
                        list.add(node.val);
                        if (node.left != null) {
                            even.push(node.left);
                        }
                        if (node.right != null) {
                            even.push(node.right);
                        }
                    }
                    arrayLists.add(list);
                    i++;
                }
            } else {
                if (!even.empty()) {
                    ArrayList<Integer> list = new ArrayList<>(8);
                    while (!even.empty()) {
                        TreeNode node = even.pop();
                        list.add(node.val);
                        if (node.right != null) {
                            odd.push(node.right);
                        }
                        if (node.left != null) {
                            odd.push(node.left);
                        }
                    }
                    arrayLists.add(list);
                    i++;
                }
            }
        }

        return arrayLists;
    }
}
