package leetcode.list;

import leetcode.ListNode;

/**
 * @author :liupf
 * @description :找到两个单链表相交的起始节点。
 * @date :2019/07/01 20:00
 **/
public class IntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = getListNodeLength(headA);
        int lB = getListNodeLength(headB);

        if (lA > lB) {
            int i = lA - lB;
            while (i > 0) {
                headA = headA.next;
                i--;
            }

            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        } else {
            int i = lB - lA;
            while (i > 0) {
                headB = headB.next;
                i--;
            }

            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headB;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    private int getListNodeLength(ListNode head) {
        int i = 0;

        if (head == null) {
            return i;
        }

        while (head != null) {
            head = head.next;
            i++;
        }

        return i;
    }
}

