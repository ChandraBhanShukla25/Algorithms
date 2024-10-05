package com.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagTraversalLC103 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]

        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ZigZagTraversalLC103 zigZagTraversalLC103 = new ZigZagTraversalLC103();
        List<List<Integer>> resultList = zigZagTraversalLC103.printZigZag(root);
        System.out.println(resultList);
    }

    public List<List<Integer>> printZigZag(TreeNode root){


        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        List<List<Integer>> resultList = new ArrayList<>();

        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            List<Integer> result = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode temp = queue.poll();
                    if(level%2==0) {
                        result.add(temp.val);
                    }else{
                        stack.add(temp.val);
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }

                    if(temp.right!=null){
                        queue.add(temp.right);
                    }

                }
                level = level+1;
                while (!stack.isEmpty()){
                    result.add(stack.pop());
                }
                resultList.add(new ArrayList<>(result));
                result.clear();
            }
        return resultList;
    }
}
