package hot100;

public class _206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        loop(head);//迭代
        dliver(head);//递归
        return header;
    }

    private ListNode loop(ListNode head) {
        header = new ListNode(-1);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = header.next;
            header.next = temp;
        }

        return header.next;
    }

    ListNode header;

    private ListNode dliver(ListNode node) {
        if (node == null) return header;
        ListNode dliver = dliver(node.next);
        dliver.next = node;
        node.next = null;
        return node;
    }
}
