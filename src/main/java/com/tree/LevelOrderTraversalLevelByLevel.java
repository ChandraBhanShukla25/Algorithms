package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalLevelByLevel {

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
        //20 10 30 5 15 25 35
        TreeNode root =  new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        LevelOrderTraversalLevelByLevel levelTraversal = new LevelOrderTraversalLevelByLevel();
        List<List<Integer>> levelOrderList = levelTraversal.levelOrderTraversal(root);
        System.out.println(levelOrderList);

    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode temp = queue.poll();
                result.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            resultList.add(new ArrayList<>(result));
            result.clear();;
        }
        return resultList;
    }
}
