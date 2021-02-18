package leetcode.oct;

import java.util.HashSet;

public class day10 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (flag) {
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
        return null;
    }
}
