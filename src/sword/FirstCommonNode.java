package sword;

/**
 * @author :liupf
 * @description :输入两个链表，找出它们的第一个公共结点。
 * @date :2019/03/20 12:16
 **/
public class FirstCommonNode {
    public static void main(String[] args) {

    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int l1 = listNodeLength(pHead1);
        int l2 = listNodeLength(pHead2);
        if (l1 > l2) {
            int n = l1 - l2;
            while (n > 0) {
                pHead1 = pHead1.next;
                n--;
            }
            while (pHead1 != null) {
                if (pHead1 == pHead2) {
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        } else {
            int n = l2 - l1;
            while (n > 0) {
                pHead2 = pHead2.next;
                n--;
            }
            while (pHead1 != null) {
                if (pHead1 == pHead2) {
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    public int listNodeLength(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }

        int count = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            count++;
        }
        return count;
    }
}
