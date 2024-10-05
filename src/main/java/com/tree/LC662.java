package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC662 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
      //root = [1,3,2,5,3,null,9]
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        LC662 maximumWidth = new LC662();
        int width = maximumWidth.widthOfBinaryTree(root);
        System.out.println(width);
    }

    static class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       ArrayDeque<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(root,1));
       int maxWidth = 0;
       while(!queue.isEmpty()){
            maxWidth = Integer.max(maxWidth ,queue.peekLast().level-queue.peekFirst().level+1);
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.pollFirst();
                int currLevel = pair.level;
                TreeNode currentNode = pair.node;
                if(currentNode.left!=null){
                    queue.add(new Pair(currentNode.left, 2*currLevel));
                }
                if(currentNode.right!=null){
                    queue.add(new Pair(currentNode.right,(2*currLevel)+1));
                }
            }

       }
       return maxWidth;
    }
}
