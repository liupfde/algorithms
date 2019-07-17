package sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :liupf
 * @description :输入一棵二叉树，求该树的深度。
 *               从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @date :2019/03/23 00:28
 **/
public class TreeDepth {
    public static void main(String[] args) {

    }

    /** 非递归*/
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (nodeQueue.size() != 0) {
            TreeNode node = nodeQueue.poll();
            count++;
            if (node.left != null) {
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }
            if (count == nextCount) {
                nextCount = nodeQueue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    /** 递归*/
    public static int treeDepthNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepthNum(root.left);
        int right = treeDepthNum(root.right);
        int depth = Math.max(left, right) + 1;
        return depth;
    }
}
