package sword;

/**
 * @author :liupf
 * @description :给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @date :2019/05/17 18:18
 **/
public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        //如果有环 会相遇
        while (slow != fast) {
            if (slow.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }

        //slow从头开始 fast继续从相遇的地点走  最终在环入口相遇
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
