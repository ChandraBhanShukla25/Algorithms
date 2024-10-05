package com.dynamicprogramming;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HouseRobber337 {
    
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
          int level;
          TreeNode node;

          Pair(int level, TreeNode node){
              this.level=level;
              this.node=node;
          }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        HouseRobber337 robber337 = new HouseRobber337();
        int x = robber337.rob(root);
        System.out.println(x);
    }



// last =0 -NotPicked
//    Last==1 , Picked
public int rob(TreeNode root) {
    int[] results = robSubtree(root);
    return Math.max(results[0], results[1]);
}
    private int[] robSubtree(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] leftResults = robSubtree(node.left);
        int[] rightResults = robSubtree(node.right);

        int robNode = node.val + leftResults[1] + rightResults[1];
        int notRobNode = Math.max(leftResults[0], leftResults[1]) + Math.max(rightResults[0], rightResults[1]);

        // An array of two elements corresponding to robbing or not robbing the current node
        return new int[]{robNode, notRobNode};
    }
}
