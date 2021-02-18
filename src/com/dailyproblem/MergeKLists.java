package com.dailyproblem;

import java.util.List;
/*java.lang.NullPointerException
  at line 35, Solution.mergeKLists
  at line 57, __DriverSolution__.__helper__
  at line 85, __Driver__.main*/

public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))),
                new ListNode(2, new ListNode(6, null))
        };
//        ListNode[] listNodes = new ListNode[]{new ListNode(2,null),null,new ListNode(-1,null)};
        System.out.println(mergeKLists(listNodes));
    }

    // Definition for singly-linked list.
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        ListNode header =null;
        int index = 0;
        int length = lists.length;
        /*找到最小值*/
        while (length > 0) {
            if(lists[0]==null){
                lists[0]=lists[length-1];
                lists[length-1]=null;
                length--;
                continue;
            }
            ListNode temp = new ListNode(lists[0].val,null);
            index=0;
            for (int i = 1; i < length; i++) {
                if(lists[i]==null){
                    lists[i]=lists[length-1];
                    lists[length-1]=null;
                    length--;
                    i--;
                    continue;
                }
                if (temp.val > lists[i].val) {
                    temp.val=lists[i].val;
                    index = i;
                }
            }
            if(listNode==null) {
                listNode=temp;
                header=temp;
            }else{
                listNode.next=temp;
                listNode=listNode.next;
            }
            lists[index] = lists[index].next;
        }
        /*反转链表*/
        return header;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
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

}
