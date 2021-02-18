package com.dailyproblem;

import org.w3c.dom.ls.LSException;

import java.util.Stack;

public class Sum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode tmp = null;
        int jinwei = 0;
        while (!stack.empty()) {
            ListNode listNode;
            if (!stack2.empty()) {
                int i = stack.pop().val + stack2.pop().val + jinwei;
                jinwei = 0;
                if (i >= 10) {
                    listNode = new ListNode(i - 10);
                    jinwei = 1;
                } else {
                    listNode = new ListNode(i);
                }
            } else {
                int i = stack.pop().val + jinwei;
                jinwei = 0;
                if (i >= 10) {
                    listNode = new ListNode(i - 10);
                    jinwei = 1;
                } else {
                    listNode = new ListNode(i);
                }
            }
            listNode.next = tmp;
            tmp = listNode;

        }
        ListNode listNode;
        while (!stack2.empty()) {
            listNode = stack2.pop();
            if ((listNode.val = listNode.val + jinwei) >= 10) {
                listNode.val = listNode.val - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            listNode.next = tmp;
            tmp = listNode;
        }
        if (jinwei > 0) {
            listNode = new ListNode(jinwei);
            listNode.next = tmp;
            tmp = listNode;
        }
        return tmp;

    }

    // 链表反转
    public ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean flag) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int msg = 0;

        ListNode listNode = null;
        while (l1 != null) {
            ListNode listNode1 = null;
            if (l2 != null) {
                int i = l1.val + l2.val + msg;
                if (i >= 10) {
                    listNode1 = new ListNode(i - 10);
                    msg = 1;
                } else {
                    listNode1 = new ListNode(i);
                    msg = 0;
                }
                l2=l2.next;
            } else {
                int i = l1.val + msg;
                if (i >= 10) {
                    listNode1 = new ListNode(i - 10);
                    msg = 1;
                } else {
                    listNode1 = new ListNode(i);
                    msg = 0;
                }

            }
            listNode1.next = listNode;
            listNode = listNode1;
            l1=l1.next;
        }
        while (l2!=null){
            ListNode listNode1 = null;
            int i = l2.val + msg;
            if (i >= 10) {
                listNode1 = new ListNode(i - 10);
                msg = 1;
            } else {
                listNode1 = new ListNode(i);
                msg = 0;
            }
            listNode1.next = listNode;
            listNode = listNode1;
            l2=l2.next;
        }
        if(msg>0){
            ListNode listNode1 = new ListNode(msg);
            listNode1.next=listNode;
            listNode=listNode1;
        }
        return listNode;


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
//        listNode.next = new ListNode(9);
        ListNode listNode1 = new ListNode(5);
        Sum sum = new Sum();
        System.out.println(sum.addTwoNumbers(listNode, listNode1,false));
    }
}
//Definition for singly-linked list.

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
