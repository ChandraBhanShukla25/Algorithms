package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

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

        InOrder inOrder = new InOrder();
        List<Integer> preOrderList = inOrder.traverse(root);
        System.out.println(preOrderList);
    }

    public List<Integer> traverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root!=null) {
                stack.push(root);
                root=root.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.peek();
                result.add(root.val);
                stack.pop();
                root= root.right;
            }
        }
        return  result;
    }
}
