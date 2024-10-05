package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

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
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        PostOrder postOrder = new PostOrder();
        List<Integer> result = postOrder.traverse(root);
        System.out.println(result);
    }
    public List<Integer> traverse(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        List<Integer> result = new ArrayList<>();
        while(!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left!=null){
                stack1.push(temp.left);
            }
            if(temp.right!=null){
                stack1.push(temp.right);
            }
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }

        return result;
    }
}
