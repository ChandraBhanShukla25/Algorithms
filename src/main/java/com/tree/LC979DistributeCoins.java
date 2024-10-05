package com.tree;

public class LC979DistributeCoins {

    static int totalMoves = 0;
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
       TreeNode root = new TreeNode(3);
       root.left = null;
       root.right = null;
       LC979DistributeCoins distributeCoins = new LC979DistributeCoins();
       totalMoves = distributeCoins.distributeCoins(root);
        System.out.println(totalMoves);
    }

    public int distributeCoins(TreeNode root) {
       if(root==null){
           return 0;
       }
       int leftMoves = distributeCoins(root.left);
       int rightMoves = distributeCoins(root.right);
       totalMoves+=Math.abs(leftMoves)+Math.abs(rightMoves);
       return leftMoves+rightMoves+root.val-1;
    }
}
