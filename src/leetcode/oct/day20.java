package leetcode.oct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day20 {


    public static class ListNode {

        int val;

        ListNode next;


        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode header = new ListNode(-1);
        ListNode temp = header;
        header.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        System.out.println(header.next);
        day20 d = new day20();
        d.reorderList(header.next);
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode slow = header;
        ListNode fast = header.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow);
        System.out.println(fast);
        if (fast != null) {
            /*slow是终点*/
            slow = slow.next;
        }
        slow.next = null;
        ListNode fHeader = new ListNode(-1);
        while (fast != null) {
            ListNode temp = fHeader.next;
            fHeader.next = fast;
            fHeader.next.next = temp;
            fast = fast.next;
        }
        System.out.println(fHeader);
        ListNode node = header;
        ListNode l1 = slow;
        ListNode l2 = fHeader.next;
        while (l2 != null) {
            if (l1 != null) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
                node.next = l2;
                node = node.next;
                l2 = l2.next;
        }
        System.out.println(head);
    }
}
