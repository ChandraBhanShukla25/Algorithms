package com.tree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewBinaryTree {


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
    static  class Pair{
        TreeNode node;
        int level;

        Pair(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        LeftViewBinaryTree leftView = new LeftViewBinaryTree();
        List<Integer> result = leftView.findLeftView(root);
        System.out.println(result);
    }

    private List<Integer> findLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int level = 0;
        leftView(root, result, level);
        return result;
    }

    private void leftView(TreeNode root, List<Integer> result, int level) {
        if(root==null){
            return ;
        }
        if(level==result.size()){
            result.add(root.val);
        }

        leftView(root.left, result, level+1);
        leftView(root.right, result, level+1);
    }
}
