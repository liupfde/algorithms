package sword;

/**
 * @author :liupf
 * @description :输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @date :2019/04/15 21:18
 **/
public class IsBalanced {
    public static void main(String[] args) {

    }

    public static boolean isBalancedTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1 &&
                isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    private static boolean isBalanced = true;

    private static int getTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
    }

    private static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getDepth(node.left);
        int right = getDepth(node.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return right > left ? right + 1 : left + 1;
    }
}
