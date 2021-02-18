package leetcode.nov;

import java.util.List;

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

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHeader = new ListNode(-1);
        ListNode evenHeader = new ListNode(-1);
        ListNode odd = oddHeader;
        ListNode even = evenHeader;

        boolean flag = true;
        while (head != null) {
            if (flag) {
                /*奇数*/
                flag = false;
                odd.next = head;
                head = head.next;
                odd = odd.next;
                odd.next = null;
            } else {
                /*偶数*/
                flag = true;
                even.next = head;
                head = head.next;
                even = even.next;
                even.next = null;
            }
        }
        odd.next = evenHeader.next;
        return oddHeader.next;
    }
}
