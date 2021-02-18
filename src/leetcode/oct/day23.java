package leetcode.oct;

public class day23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        day23 da = new day23();
        System.out.println(da.isPalindrome(new ListNode(1, new ListNode(2, null))));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode slow = header;
        ListNode fast = header.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*将后端链表倒转*/
        ListNode fastHeader = new ListNode(-1);
        if (fast != null) {
            /*奇数个中间node无需比对*/
            slow = slow.next;
        }
        slow = slow.next;
        while (slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = fastHeader.next;
            fastHeader.next = temp;
        }
        return isPalindrome(head, fastHeader.next);
    }

    private boolean isPalindrome(ListNode node1, ListNode node2) {
        while (node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
