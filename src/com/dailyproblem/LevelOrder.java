package com.dailyproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return twoQueue(root);
//        List<List<Integer>> lists = new ArrayList<>();
//        dliver(root, lists,0);
//        return lists;

    }
    private void dliver(TreeNode root,List<List<Integer>> arrayLists,int level){
        if(root!=null){

          if(arrayLists.size()<=level){
              arrayLists.add(new ArrayList<>());
          }
           arrayLists.get(level).add(root.val);
            dliver(root.left,arrayLists,level+1);
            dliver(root.right,arrayLists,level+1);
        }
    }

    private List<List<Integer>> twoQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        List<List<Integer>> arrayLists = new ArrayList<>();
        queue.offer(root);
        int count = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            while (count != 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue1.offer(node.left);
                    queue1.offer(node.right);
                    List<Integer> levelNodes;
                    if (arrayLists.size() == level) {
                        levelNodes = new ArrayList<>();
                        arrayLists.add(levelNodes);
                    } else {
                        levelNodes = arrayLists.get(level);
                    }
                    levelNodes.add(node.val);
                }
                count--;
            }
            level++;
            count = queue.size();
        }
//            while (!queue1.isEmpty()){
//                TreeNode node = queue1.poll();
//                if(node!=null){
//                    queue.offer(node.left);
//                    queue.offer(node.right);
//                    List<Integer> levelNodes;
//                    if(arrayLists.size()==level){
//                        levelNodes=new ArrayList<>();
//                        arrayLists.add(levelNodes);
//                    }else {
//                        levelNodes = arrayLists.get(level);
//                    }
//                    levelNodes.add(node.val);
//                }
//
//            }
//            level++;
//        }

        return  arrayLists;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
