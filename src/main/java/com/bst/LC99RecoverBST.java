package com.bst;

import java.util.List;

public class LC99RecoverBST {

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public static void main(String[] args) {
      List<Integer> lst = List.of(1,3,null,null,2);

    }

    public void recoverTree(TreeNode root) {
       inOrder(root);
       if(first!=null && second!=null){
           int temp = first.val;
           first.val=second.val;
           second.val=temp;
       }
    }

    private void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        if(prev!=null && prev.val>node.val){
            if(first==null) {
                first=prev;
            }
            second=node;
            prev=node;
            inOrder(node.right);
        }
    }

}
