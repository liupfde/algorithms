package sword;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/05/17 21:22
 **/
public class DeleteDuplication {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(4);
        ListNode l9 = new ListNode(5);

        l1.next = l2; l2.next = l3; l3.next = l4;
        l4.next = l5; l5.next = l6; l6.next = l7;
        l7.next = l8; l8.next = l9;

        ListNode listNode = deleteDuplication(l1);
        System.out.println(listNode.val);
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = pHead;
        ListNode p = pHead;
        //衔接的节点
        ListNode linkerHead = dummyHead;
        while (pHead != null) {
            if (pHead.next != null && pHead.val == pHead.next.val) {
                int val = pHead.val;
                while (pHead != null && pHead.val == val) {
                    pHead = pHead.next;
                }
                linkerHead.next = pHead;
            } else {
                linkerHead = pHead;
                pHead = pHead.next;
            }
        }
        return dummyHead.next;
    }
}
