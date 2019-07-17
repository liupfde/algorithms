package sword;

/**
 * @author :liupf
 * @description :输入两棵二叉树A，B，判断B是不是A的子结构。（ps: 约定空树不是任意一个树的子结构）
 * @date :2019/02/27 22:19
 **/
public class HasSubtree {
    public static void main(String[] args) {

    }

    public static boolean hasSubtree(TreeNode rootA, TreeNode rootB) {

        boolean result = false;

        if (rootA != null && rootB != null) {
            if (rootA.val == rootB.val) {
                result = doesAHasB(rootA,rootB);
            }
            if (!result) {
                result = hasSubtree(rootA.left, rootB);
            }
            if (!result) {
                result = hasSubtree(rootA.right, rootB);
            }
        }

        return result;
    }

    private static boolean doesAHasB(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {
            return true;
        }
        if (rootA == null) {
            return false;
        }
        if (rootA.val != rootB.val) {
            return false;
        }
        return doesAHasB(rootA.left,rootB.left) && doesAHasB(rootA.right,rootB.right);
    }
}
