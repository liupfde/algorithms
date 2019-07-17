package sword;

/**
 * @author :liupf
 * @description :二叉树的镜像
 * @date :2019/02/27 22:45
 **/
public class Mirror {
    public static void main(String[] args) {

    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }

    }
}
