package leetcode.oct;

public class day4 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int flag = 0;
        ListNode header = new ListNode();
        ListNode last = header;
        int zero = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int sum = flag;
            flag = 0;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            }

            if (l1 != null) {
                l1.val = sum;
                last.next = l1;
                last = last.next;
            } else if (l2 != null) {
                l2.val = sum;
                last.next = l2;
                last = last.next;
            } else {
                ListNode node = new ListNode(sum);
                last.next = node;
                last = last.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) l2 = l2.next;
        }
        return header.next;
    }
}