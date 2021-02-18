package com.tree;

public class RecoverFromPreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        RecoverFromPreorder recoverFromPreorder = new RecoverFromPreorder();
//        System.out.println(recoverFromPreorder.recoverFromPreorder("1-2--3--4-5--6--7"));
//        System.out.println(recoverFromPreorder.recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(recoverFromPreorder.recoverFromPreorder("1-401--349---90--88"));
        System.out.println(recoverFromPreorder.recoverFromPreorder("1-401"));
        System.out.println(recoverFromPreorder.recoverFromPreorder("1"));
    }

    int index;

    public TreeNode recoverFromPreorder(String S) {
        if(S==null||S.length()==0)return null;
        index = 0;
        return dliver(S.toCharArray(), 0);
    }

    private TreeNode dliver(char[] toCharArray, int level) {

        int _count = 0;
        if (level != 0) {
            for (index++; index < toCharArray.length; index++) {
                if (toCharArray[index] != '-') break;
                _count++;
            }
            if (level > _count) {
                index-=_count+1;
                return null;
            }

        }
        int nodeValue=0;
        for (index=index; index < toCharArray.length; index++) {
            if(toCharArray[index]=='-'){
                index--;
                break;
            }
            nodeValue=nodeValue*10+toCharArray[index]-48;
        }
        TreeNode treeNode = new TreeNode(nodeValue);
        treeNode.left = dliver(toCharArray, level + 1);
        treeNode.right = dliver(toCharArray, level+1);
        return treeNode;
    }

}
