package com.tree;

import java.util.*;

public class RightViewBinaryTreeLc199 {


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

        Pair(int level,TreeNode node){
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

        RightViewBinaryTreeLc199 rightView = new RightViewBinaryTreeLc199();
        List<Integer> result = rightView.rightSideView(root);
        System.out.println(result);
    }

    private List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root==null){
            return  result;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        queue.add(new Pair(0, root));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;
            if(!map.containsKey(level)){
                map.put(level, new ArrayList<Integer>());
            }
            map.get(level).add(node.val);

            if(node.right!=null){
                queue.add(new Pair(level+1, node.right));
            }
            if(node.left!=null){
                queue.add(new Pair(level+1, node.left));
            }
        }

        for(List<Integer> lst: map.values()){
            result.add(lst.get(0));
        }
        return  result;
    }

}
