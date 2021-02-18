package com.dailyproblem;

public class addTwoNumbers {
    public static void main(String[] args) {
        System.out.println((char) '0'+1);
        System.out.println(addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int jinwei=0;
        int num=0;
        ListNode header = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        header.next=temp;
        while (l1!=null||l2!=null||jinwei==1){
            num=jinwei;
            jinwei=0;
            if(l1!=null){
                num+=l1.val;
            }
            if(l2!=null){
                num+=l2.val;
            }
            if(num>=10){
                num-=10;
                jinwei=1;
            }
            if(temp.val==-1){
                temp.val=num;
            }else {
                temp.next=new ListNode(num);
                temp = temp.next;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return header.next;
    }

    private static String toString(ListNode l1) {
        if(l1==null){
            return "";
        }
        return l1.val+""+toString(l1.next);
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

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
