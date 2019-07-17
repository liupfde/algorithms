package sword;

/**
 * @author :liupf
 * @description :输入一个链表，反转链表后，输出新链表的表头。
 * @date :2019/02/25 00:17
 **/
public class ReverseList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode pPre = null;
        ListNode p = head;
        ListNode newHead = null;
        while (p != null) {
            ListNode pNext = p.next;
            if (pNext == null) {
                newHead = p;
            }

            p.next = pPre;
            pPre = p;
            p = pNext;

        }
        return newHead;
    }
}