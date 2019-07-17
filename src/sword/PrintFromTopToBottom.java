package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liupf
 * @description :从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *               使用一个ArrayList模仿一个队列
 * @date :2019/03/02 22:04
 **/
public class PrintFromTopToBottom {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>(16);
        List<TreeNode> queueNodes = new ArrayList<>(32);
        queueNodes.add(root);
        while (queueNodes.size() != 0) {
            TreeNode temp = queueNodes.remove(0);
            if (temp.left != null) {
                queueNodes.add(temp.left);
            }
            if (temp.right != null) {
                queueNodes.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
