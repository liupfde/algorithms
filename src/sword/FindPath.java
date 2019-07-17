package sword;

import java.util.ArrayList;

/**
 * @author :liupf
 * @description :输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @date :2019/03/03 21:58
 **/
public class FindPath {
    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>(16);
    ArrayList<Integer> list = new ArrayList<>(16);
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return result;
    }
}
