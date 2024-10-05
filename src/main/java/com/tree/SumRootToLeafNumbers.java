package com.tree;

import java.util.*;

public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.left==null && current.right==null){
                sum+=current.val;
                continue;
            }
            if(current.left!=null){
                current.left.val+=10*current.val;
                stack.push(current.left);
            }
            if(current.right!=null){
                current.right.val += current.val*10;
                stack.push(current.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        int sum = sumRootToLeafNumbers.sumNumbers(root);
        System.out.println(sum);
    }
}
