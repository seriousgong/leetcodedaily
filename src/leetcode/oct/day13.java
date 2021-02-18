package leetcode.oct;

public class day13 {
    public class ListNode {
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
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode header = new ListNode(Integer.MIN_VALUE);
        ListNode node = header;
        ListNode next = header.next;

        boolean flag = false;
        while (head != null) {
            ListNode sin = head;
            head = head.next;
            sin.next = null;
            if (!flag) {
                next = sin;
                flag = true;
            } else {
                sin.next = next;
                node.next = sin;
                node = next;
                next = null;
                flag = false;
            }
        }
        node.next = next;
        return header.next;
    }
}
