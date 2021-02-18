package com.tree;

import sun.reflect.generics.tree.Tree;

import java.text.ParseException;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public StringBuilder serialize(TreeNode root,StringBuilder stringBuilder) {
        if(root==null){
            stringBuilder.append("null").append(",");
            return stringBuilder;
        }
        stringBuilder.append(root.val).append(",");
        stringBuilder.append(serialize(root.left,stringBuilder));
        stringBuilder.append(serialize(root.right,stringBuilder));
        return stringBuilder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)return null;
        String[] split = data.split(",");

        return deserialize(split,0);
    }

    private TreeNode deserialize(String[] split,int index) {

        TreeNode treeNode ;
        if(split[index].equals("null")){
            treeNode=null;
        }else {
            treeNode=new TreeNode(Integer.parseInt(split[index]));
            treeNode.left=deserialize(split,++index);
            treeNode.right=deserialize(split,++index);
        }
        return treeNode;
    }
}
