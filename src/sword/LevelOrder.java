package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :liupf
 * @description :二叉树层序遍历
 * @date :2019/06/10 15:56
 **/
public class LevelOrder {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(8);
        if (pRoot == null) {
            return arrayLists;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(pRoot);
        Queue<TreeNode> queue2 = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>(8);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            list.add(node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                arrayLists.add(list);
                list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
        }

        return arrayLists;
    }

    /**
     * 递归的方法解决
     * @param arrayLists
     * @param depth
     * @param node
     */
    private static void print(ArrayList<ArrayList<Integer>> arrayLists, int depth, TreeNode node) {
        if (node == null) {
            return;
        }

        arrayLists.add(new ArrayList<>());
        arrayLists.get(depth - 1).add(node.val);

        print(arrayLists, depth + 1, node.left);
        print(arrayLists, depth + 1, node.right);
    }
}
