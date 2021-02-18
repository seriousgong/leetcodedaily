package com.dailyproblem;

public class MinStack {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    int length;
    LinkNode endNode;
    int  minVal;
    /** initialize your data structure here. */
    public MinStack() {
        endNode = null;
        length =0;
        minVal=Integer.MAX_VALUE;
    }

    public void push(int x) {
        LinkNode node = new LinkNode(x);
        if(endNode!=null){
            endNode.next=node;
            node.last=endNode;
            endNode=endNode.next;
        }else endNode=node;
        minVal = minVal>node.val?x:minVal;
    }

    public void pop() {
        if(endNode.val!=minVal){
            endNode=endNode.last;
        }else{
            endNode = endNode.last;
            LinkNode node = endNode;
            int minValue = Integer.MAX_VALUE;
            while (node!=null){
                minValue=Math.min(minValue,node.val);
                node = node.last;
            }
            this.minVal=minValue;
        }

    }

    public int top() {
        return endNode==null?0:endNode.val;
    }

    public int getMin() {
        return minVal;
    }
    public static  class LinkNode {
        int val;
        LinkNode next=null;
        LinkNode last=null;
        public LinkNode() {
        }

        public LinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "val=" + val +
                    ", last=" + last +
                    '}';
        }
    }
}
