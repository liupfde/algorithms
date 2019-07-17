package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :liupf
 * @description :给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 *               填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 *               如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *               初始状态下，所有 next 指针都被设置为 NULL。
 * @date :2019/07/10 21:35
 **/
public class Connect {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        ArrayList<Node> nodes = new ArrayList<>(16);
        queue1.offer(root);
        
        while (!queue1.isEmpty()) {
            Node node = queue1.poll();
            nodes.add(node);
            
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            
            if (queue1.isEmpty()) {
                for (int i = 0; i < nodes.size() - 1; i++) {
                    nodes.get(i).next = nodes.get(i + 1);
                }

                nodes.clear();

                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
        }

        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}