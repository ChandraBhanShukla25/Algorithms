package com.tree;

public class DiameterOfBinaryTree {
      int diameter = 0;
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

    public static void main(String[] args) {

          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(3);
          root.left.left= new TreeNode(4);
          root.left.right = new TreeNode(5);
         DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
         int diam = diameterOfBinaryTree.findDiameter(root);
         System.out.println(diam);
    }

    public int findDiameter(TreeNode root){
          if(root==null){
              return  0;
          }
          int lh= findDiameter(root.left);
          int rh = findDiameter(root.right);
          diameter = Integer.max(diameter, lh+rh);
          return 1+Integer.max(lh, rh);
    }
}
