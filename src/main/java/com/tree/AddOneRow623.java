package com.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRow623 {

      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  static class Pair{
        TreeNode node;
        int level;
        TreeNode parent;
        Pair(TreeNode node, int level, TreeNode parent){
            this.node=node;
            this.level = level;
            this.parent=parent;
        }
  }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,1,null));
        while(!queue.isEmpty()){
            Pair currentPair = queue.poll();
            TreeNode current = currentPair.node;
            int currentLevel = currentPair.level;
            TreeNode parentNode = currentPair.parent;
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            int leftLevel = 0;
            int rightLevel = 0;
            if(currentLevel==depth){
                if(parentNode!=null){
                    TreeNode tempLeft = parentNode.left;
                    TreeNode tempRight = parentNode.right;
                    parentNode.left = new TreeNode(val);
                    parentNode.right = new TreeNode(val);
                    parentNode.left.left = tempLeft;
                    parentNode.right.right = tempRight;
                }
                return root;
            }
            if(current.left!=null){
                leftNode = current.left;
                leftLevel = currentLevel+1;
                parentNode=current;
                queue.add(new Pair(leftNode,leftLevel,parentNode));
            }

            if(current.right!=null){
                rightNode = current.right;
                rightLevel = currentLevel+1;
                parentNode=current;
                queue.add(new Pair(rightNode,rightLevel,parentNode));
            }

        }
      return root;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        AddOneRow623 addOneRow623 = new AddOneRow623();
        TreeNode resultNode = addOneRow623.addOneRow(root, 1,2);

        printLevelOrder(resultNode);

    }

    static void printLevelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

}
