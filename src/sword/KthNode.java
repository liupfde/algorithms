package sword;

import java.util.Stack;

/**
 * @author :liupf
 * @description :给定一棵二叉搜索树，请找出其中的第k小的结点。
 *               例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @date :2019/06/11 11:45
 **/
public class KthNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(10);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);

        root.left = l; root.right = r;
        l.left = ll; l.right = lr;
        r.left = rl; r.right = rr;
        ll.left = null; ll.right = null; lr.left = null; lr.right = null;
        rl.left = null; rl.right = null; rr.left = null; rr.right = null;

        System.out.println(kthNodeWithOutRecurs(root, 3).val);
    }

    public static TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        return kthTreeNode(pRoot, k);
    }

    private static int i = 1;
    private static TreeNode kthTreeNode(TreeNode node, int k) {
        if (node != null) {
            TreeNode kthNode = kthTreeNode(node.left, k);
            if (kthNode != null) {
                return kthNode;
            }
            if (i++ == k) {
                return node;
            }
            kthNode = kthTreeNode(node.right, k);
            if (kthNode != null) {
                return kthNode;
            }
        }
        return null;
    }

    /**
     * 中序遍历非递归解法
     * @param root 根节点
     * @param k 第k小
     * @return 第k小节点
     */
    public static TreeNode kthNodeWithOutRecurs(TreeNode root, int k) {
        int index = 1;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.empty()) {
                TreeNode t = stack.pop();
                if (index++ == k) {
                    return t;
                }
                node = t.right;
            }

        }
        return null;
    }
}
