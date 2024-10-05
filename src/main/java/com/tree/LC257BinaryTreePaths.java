package com.tree;

import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePaths {

    
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

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<String> lst = new ArrayList<>();
        binaryTree(root, lst, "");
        return lst;
    }

    private void binaryTree(TreeNode root, List<String> lst, String str) {
          if(root==null)
              return;
          str+=root.val;
          if(root.left==null && root.right==null){
              lst.add(str);
          }else{
              str+="->";
              binaryTree(root.left, lst,str);
              binaryTree(root.right,lst,str);
          }
    }

    public static void main(String[] args) {
        //root = [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        LC257BinaryTreePaths binaryTreePaths = new LC257BinaryTreePaths();
        List<String> lst = binaryTreePaths.binaryTreePaths(root);
        System.out.println(lst);

    }
}
