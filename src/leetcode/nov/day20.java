package leetcode.nov;

public class day20 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode header = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;
            if (header.next == null) header.next = node;
            else {
                ListNode temp = header.next;
                ListNode last = header;
                while (temp!= null && temp.val < node.val) {
                    last = last.next;
                    temp = temp.next;
                }
                node.next = last.next;
                last.next = node;
            }
        }

        return header.next;
    }
}
