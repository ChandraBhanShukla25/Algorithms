package com.tree;

import java.util.*;

public class VerticalOrderTraversalLC314 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List <List< Integer >> results = new ArrayList<>();
        VerticalOrderTraversalLC314 verticalOrderTraversalLC314 = new VerticalOrderTraversalLC314();
        results = verticalOrderTraversalLC314.findVertical(root);
        System.out.println(results);

    }

    static  class Tuple{
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }

    }
    private List<List<Integer>> findVertical(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.add(new Tuple(root, 0,0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int x = tuple.row;
            int y = tuple.col;
            TreeNode node = tuple.node;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                queue.offer(new Tuple(node.left, x-1,y+1));
            }
            if(node.right!=null){
                queue.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> nestedMap: map.values()){
            List<Integer> result = new ArrayList<>();
            resultList.add(result);
            for(PriorityQueue<Integer> nodes : nestedMap.values()){
                while(!nodes.isEmpty()) {
                  resultList.get(resultList.size()-1).add(nodes.poll());
                }

            }

        }

       return  resultList;
    }
}
