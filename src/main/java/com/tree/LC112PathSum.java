package com.tree;

public class LC112PathSum {
    int sum =0;
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
        LC112PathSum pathSum = new LC112PathSum();
        int target = 9;
         boolean isValid = pathSum.findSum(root, target);
        System.out.println(isValid);
    }

    public boolean findSum(TreeNode root, int target){
        sum +=  root.val;
        if(target==sum){
            return true;
        }
        if(root.left!=null) {
            findSum(root.left, target);
        }
        if(root.right!=null) {
            findSum(root.right, target);
        }
        return sum==target;
    }
}
