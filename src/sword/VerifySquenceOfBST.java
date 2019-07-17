package sword;

/**
 * @author :liupf
 * @description :输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *               如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @date :2019/03/02 22:23
 **/
public class VerifySquenceOfBST {
    public static void main(String[] args) {

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        return verifySquenceOfBST(sequence, sequence.length);
    }

    private boolean verifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }
        int root = sequence[length - 1];
        int i = 0;
        //左子树中小于根结点值的位置
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        //判断左子树是否是平衡二叉树
        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(sequence, i);
        }
        //判断右子树是否是二叉搜索树
        boolean right = true;
        if (i < length - 1) {
            right = verifySquenceOfBST(sequence, length - i - 1);
        }

        return left && right;
    }
}
