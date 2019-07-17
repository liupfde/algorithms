package leetcode;

/**
 * @author :liupf
 * @description :T输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *               假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *               例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回ODO
 * @date :2019/07/08 22:16
 **/
public class BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0
        || in == null || in.length == 0) {
            return null;
        }

        return buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode buildTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie) {
            throw new RuntimeException("数据输入错误");
        }

        int value = pre[ps];
        int index = is;
        while (is <= ie && in[index] != value) {
            index++;
        }

        TreeNode root = new TreeNode(value);
        root.left = buildTree(pre, ps + 1, ps + index - is, in, is, index - 1);
        root.right = buildTree(pre, ps + index - is + 1, pe, in, index + 1, ie);

        return root;
    }
}
