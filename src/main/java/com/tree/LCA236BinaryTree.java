package com.tree;

import com.sun.source.tree.Tree;

public class LCA236BinaryTree {

    
      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      }
    public static void main(String[] args) {
     // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left= new TreeNode(0);
        LCA236BinaryTree lca = new LCA236BinaryTree();
        TreeNode node = lca.lowestCommonAncestor(root,root.left, root.right);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null || root==p || root==q){
           return root;
       }
       TreeNode left = lowestCommonAncestor(root.left,p,q);
       TreeNode right = lowestCommonAncestor(root.right,p,q);
       if(left==null)
           return right;
       else if(right==null)
           return left;
       else return root;
    }
}
