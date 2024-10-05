package com.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

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
        VerticalTraversal.TreeNode root = new VerticalTraversal.TreeNode(1);
        root.left = new VerticalTraversal.TreeNode(2);
        root.left.left = new VerticalTraversal.TreeNode(4);
        root.left.right = new VerticalTraversal.TreeNode(10);
        root.left.left.right = new VerticalTraversal.TreeNode(5);
        root.left.left.right.right = new VerticalTraversal.TreeNode(6);
        root.right = new VerticalTraversal.TreeNode(3);
        root.right.left = new VerticalTraversal.TreeNode(9);
        root.right.right = new VerticalTraversal.TreeNode(10);

        List <List< Integer >> results = new ArrayList<>();
        VerticalTraversal VerticaTraversal = new VerticalTraversal();
        results = VerticaTraversal.findVertical(root);
        System.out.println(results);
    }
     static  class Tuple{
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col){
            this.node=node;
            this.row=row;
            this.col = col;
        }

     }
    private List<List<Integer>> findVertical(TreeNode root) {
      TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
      Queue<Tuple> queue = new LinkedList<>();
      queue.add(new Tuple(root,0,0));

      while(!queue.isEmpty()){
          Tuple tuple = queue.poll();
          TreeNode node = tuple.node;
          int x = tuple.row;
          int y = tuple.col;

          if(!map.containsKey(x)){
              map.put(x, new TreeMap<>());
          }
          if(!map.get(x).containsKey(y)){
              map.get(x).put(y, new PriorityQueue<>());
          }
          map.get(x).get(y).add(node.val);

          if(node.left!=null){
              queue.add(new Tuple(node.left, x-1,y+1));
          }
          if(node.right!=null){
              queue.add(new Tuple(node.right, x+1, y+1));
          }
      }

      List<List<Integer>> resultList = new ArrayList<>();
      for(TreeMap<Integer,PriorityQueue<Integer>> nestedMap: map.values()){
          List<Integer> result = new ArrayList<>();
          for(PriorityQueue<Integer> node : nestedMap.values()){
              while(!node.isEmpty()){
                  result.add(node.poll());
              }
          }
          resultList.add(result);
      }
      return resultList;
    }
}
