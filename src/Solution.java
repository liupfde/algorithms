import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/07/01 15:42
 **/
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);

        root.left = l;
        root.right = r;
        l.left = null;
        l.right = null;
        r.left = rl;
        r.right = rr;
        rl.left = null;
        rl.right = null;
        rr.left = null;
        rr.right = null;

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
