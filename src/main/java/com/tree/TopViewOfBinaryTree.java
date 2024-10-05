package com.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TopViewOfBinaryTree {

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
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TopViewOfBinaryTree  topView = new TopViewOfBinaryTree();
        List<Integer> result = topView.findTopView(root);
        System.out.println(result);
    }

    static class Pair{
        TreeNode node;
        int level;

        Pair(int level, TreeNode node){
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> findTopView(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if(root==null){
            return  result;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, root));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if(!map.containsKey(level)){
                map.put(level, new ArrayList<Integer>());
            }
            map.get(level).add(node.val);

            if(node.left!=null){
                queue.add(new Pair(level-1, node.left));
            }
            if(node.right!=null){
                queue.add(new Pair(level+1, node.right));
            }
        }

        for(List<Integer> list : map.values()){
            result.add(list.get(0));
        }


     return  result;
    }



}
