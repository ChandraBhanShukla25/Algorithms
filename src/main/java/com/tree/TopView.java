package com.tree;

import java.util.*;

public class TopView {


    static class TreeNode{
        int val;
        TopView.TreeNode left;
        TopView.TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TopView.TreeNode left, TopView.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TopView.TreeNode root = new TopView.TreeNode(3);
        root.left= new TopView.TreeNode(9);
        root.right = new TopView.TreeNode(20);
        root.right.left = new TopView.TreeNode(15);
        root.right.right = new TopView.TreeNode(7);

        List< Integer > results = new ArrayList<>();
        TopView topView = new TopView();
        results = topView.findView(root);
        System.out.println(results);

        results = topView.findBottomView(root);
        System.out.println(results);

        results = topView.findRightView(root);
        System.out.println(results);
        results = topView.findLeftView(root);
        System.out.println(results);
    }

    static  class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    private List<Integer> findView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        Map<Integer,List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if(!map.containsKey(level)){
               map.put(level,new ArrayList<>());
            }
            map.get(level).add(node.val);
            if(node.left!=null){
                queue.add(new Pair(node.left, level-1 ));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right, level+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(List<Integer> lst : map.values()){
            result.add(lst.get(0));
        }

        return result;

    }

    private List<Integer> findBottomView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        Map<Integer,List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if(!map.containsKey(level)){
                map.put(level,new ArrayList<>());
            }
            map.get(level).add(node.val);
            if(node.left!=null){
                queue.add(new Pair(node.left, level-1 ));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right, level+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(List<Integer> lst : map.values()){
            result.add(lst.get(lst.size()-1));
        }

        return result;

    }

    private List<Integer> findRightView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        Map<Integer,List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if(!map.containsKey(level)){
                map.put(level,new ArrayList<>());
            }
            map.get(level).add(node.val);
            if(node.right!=null){
                queue.add(new Pair(node.right, level+1 ));
            }
            if(node.right!=null){
                queue.add(new Pair(node.left, level+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(List<Integer> lst : map.values()){
            result.add(lst.get(0));
        }

        return result;

    }

    private List<Integer> findLeftView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        Map<Integer,List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if(!map.containsKey(level)){
                map.put(level,new ArrayList<>());
            }
            map.get(level).add(node.val);
            if(node.left!=null){
                queue.add(new Pair(node.left, level+1 ));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right, level+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(List<Integer> lst : map.values()){
            result.add(lst.get(0));
        }

        return result;

    }
}
