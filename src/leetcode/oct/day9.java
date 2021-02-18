package leetcode.oct;

import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class day9 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {

        ListNode node = head;
        if (node == null) return false;
        if (node.next == null || node.next.next == null) return false;
        ListNode slow = node.next;
        ListNode fast = node.next.next;
        while (slow != null && fast != null) {

            if (slow == fast) return true;
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else break;
        }

        return false;

    }
}
