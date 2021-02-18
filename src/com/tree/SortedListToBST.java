package com.tree;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
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
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
//        return toList(head);
        return doublePoint(head);
    }

    TreeNode doublePoint(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) pre.next = null;
        TreeNode node = new TreeNode(slow.val);
        node.left = doublePoint(slow);
        node.right = doublePoint(slow.next);
        return node;
    }

    private TreeNode toList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return inorder(arr, 0, arr.size());
    }

    TreeNode inorder(List<Integer> arr, int left, int right) {
        if (left <= right && right < arr.size()) {
            int middle = left + (right - left) / 2;
            Integer midVal = arr.get(middle);
            if (midVal == null) return null;
            TreeNode node = new TreeNode();
            node.val = midVal;
            node.left = inorder(arr, left, middle - 1);
            node.left = inorder(arr, middle + 1, right);
            return node;
        }
        return null;
    }
}
