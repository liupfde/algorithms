package sword;

import java.util.*;

/**
 * @author :liupf
 * @description :请实现一个函数，用来判断一颗二叉树是不是对称的。
 *               注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @date :2019/05/20 23:31
 **/
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }

        if (lNode != null && rNode != null) {
            return (lNode.val == rNode.val)
                    &&
                    (isSymmetrical(lNode.left, rNode.right))
                    &&
                    (isSymmetrical(lNode.right, rNode.left));
        }

        return false;
    }


    /**
     * 使用队列处理  广度优先遍历
     * @param lNode
     * @param rNode
     * @return
     */
    private boolean isSymmetricalByBFS(TreeNode lNode, TreeNode rNode) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(lNode);
        nodes.offer(rNode);

        while (!nodes.isEmpty()) {
            TreeNode left = nodes.poll();
            TreeNode right = nodes.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            nodes.offer(left.left);
            nodes.offer(right.right);
            nodes.offer(left.right);
            nodes.offer(right.left);
        }

        return true;
    }

    private boolean isSymmetricalByDFS(TreeNode lNode, TreeNode rNode) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(lNode);
        nodes.push(rNode);

        while (!nodes.empty()) {
            TreeNode right = nodes.pop();
            TreeNode left = nodes.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            nodes.push(left.left);
            nodes.push(right.right);
            nodes.push(left.right);
            nodes.push(right.left);
        }

        return true;
    }
}
