package com.tree;

import java.util.*;

public class BurnTree {

    public static void main(String[] args) {
        BurnTree sol = new BurnTree();

        // Create the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.right.left = new Node(7);
        root2.left.right.right = new Node(8);
        root2.right = new Node(3);
        root2.right.right = new Node(6);
        root2.right.right.right = new Node(9);
        root2.right.right.right.right = new Node(10);

        int start = 8;

        // Get the time to burn the tree
        int result = minTime(root, start);
       // List<Integer> lst = List.of(1 ,2, 3, 4, 5, null, 6, null, null,7, 8, null, 9, null,null, null, null ,null, 10);
       // Node root1 = createTree(lst, 0);

        int result1 = minTime(root2, 8);
        System.out.println("Time to burn the tree: " + result1);
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        HashMap<Node, Node> map = new HashMap<>();
        Node targetNode  = bfsToParentMap(root, map, target);
        int maxDistance = findMaxDistance( targetNode, map);
        System.out.println(maxDistance);
        return maxDistance;
    }
    public static Node createTree(List<Integer> lst, int index){
        if(index<lst.size() && lst.get(index)!=null){
            Node root = new Node(lst.get(index));
            root.left = createTree(lst, 2*index+1);
            root.right = createTree(lst, 2*index+2);
            return root;
        }
        return null;
    }

    private static int findMaxDistance(Node targetNode, HashMap<Node, Node> map) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        visited.add(targetNode);
        queue.offer(targetNode);
        int time = 0;
        while(!queue.isEmpty()){
            int burn = 0;
            for(int i=0;i<queue.size();i++){
                Node node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    burn = 1;
                   queue.add(node.left);
                   visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    burn=1;
                    queue.add(node.right);
                    visited.add(node.right);
                }

                if(map.get(node)!=null && !visited.contains(map.get(node))){
                    burn=1;
                    queue.add(map.get(node));
                    visited.add(map.get(node));
                }
            }
            if(burn==1){
                time++;
            }
        }
        return time;
    }

    private static Node bfsToParentMap(Node root, HashMap<Node, Node> parentMap, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = new Node(-1);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.data == target){
                targetNode = node;
            }
            if(node.left!=null){
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right!=null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
     return targetNode;
    }
}
