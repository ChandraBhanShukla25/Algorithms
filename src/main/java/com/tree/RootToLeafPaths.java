package com.tree;

import java.util.ArrayList;

public class RootToLeafPaths {

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        ArrayList<ArrayList<Integer>> paths = Paths(root);
        System.out.println(paths);
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        getPaths(root, list, new ArrayList<>());
        return list;
    }

    private static void getPaths(Node root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> result) {
        result.add(root.data);
        if(root.left==null && root.right==null){
            list.add(new ArrayList<>(result));
            return;
        }

        getPaths(root.left,list,new ArrayList<>(result));
        getPaths(root.right,list,new ArrayList<>(result));
    }
}
