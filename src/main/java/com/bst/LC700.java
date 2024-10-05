package com.bst;


import com.sun.source.tree.Tree;

public class LC700 {


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 2;
        LC700 lc700 = new LC700();
        TreeNode node = lc700.searchBST(root, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if(root!=null && root.val!=val){
            root = root.val<val ? searchBST(root.right,val) : searchBST(root.left,val);
        }
        return root;
    }
}
