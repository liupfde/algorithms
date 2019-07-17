package sword;

/**
 * @author :liupf
 * @description :给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *               注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @date :2019/05/20 22:58
 **/
public class GetNext {
    public static void main(String[] args) {

    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        getNext(pNode.left);
        System.out.println(pNode.val);
        getNext(pNode.right);

        return null;

    }
}
