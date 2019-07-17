package sword;

/**
 * @author :liupf
 * @description :输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *               要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *               使用中序遍历  中序遍历的二叉搜索树是从小到大排列
 * @date :2019/03/04 14:56
 **/
public class Convert {
    public static void main(String[] args) {

    }

    /** leftNode是双向链表的头节点  rightNode就是不断的向右移动增加双向链表的节点  */
    TreeNode leftNode = null;
    TreeNode rightNode = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convert(pRootOfTree.left);
        if (rightNode == null) {
            //双向链表的第一个节点
            rightNode = leftNode = pRootOfTree;
        } else {
            //互相指认
            rightNode.right = pRootOfTree;
            pRootOfTree.left = rightNode;
            //rightNode指向双向链表的下一个节点
            rightNode = pRootOfTree;
        }
        convert(pRootOfTree.right);
        //返回双向链表的头节点
        return leftNode;
    }

}
