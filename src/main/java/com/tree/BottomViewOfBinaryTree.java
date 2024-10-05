package com.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class BottomViewOfBinaryTree {

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
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        BottomViewOfBinaryTree bottomViewOfBinaryTree = new BottomViewOfBinaryTree();
        List<Integer> result = bottomViewOfBinaryTree.bottomView(root);
        System.out.println(result);
    }

    public List<Integer> bottomView(TreeNode root){
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair( 0,root));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

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


        for(List<Integer> lst : map.values()){
            result.add(lst.get(lst.size()-1));
        }

        return result;
    }


}
