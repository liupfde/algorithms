package sword;

/**
 * @author :liupf
 * @description :输入一个链表，输出该链表中倒数第k个结点。
 *               解决 利用两个指针 让第一个先走k
 * @date :2019/02/23 13:59
 **/
public class KthToTail {
    public static void main(String[] args) {

    }

    public static ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k <= 0) {
            return null;
        }

        int i = 0;
        ListNode fir = head;
        ListNode sec = head;
        while (fir.next != null && i != k) {
            fir = fir.next;
            i++;
        }

        while (fir.next != null){
            fir = fir.next;
            sec = sec.next;
        }

        return sec;
    }
}

class ListNode {
    int val;
    ListNode next ;

    ListNode(int val) {
        this.val = val;
    }
}