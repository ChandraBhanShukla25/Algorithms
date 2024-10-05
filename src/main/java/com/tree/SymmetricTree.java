package com.tree;

import com.sun.source.tree.Tree;

import java.util.List;

public class SymmetricTree {


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left!=null || right==null) return false;

        if(left==null || right!=null) return false;

        return left.val==right.val && symmetric(left, right) && symmetric(right,left);
    }
}
