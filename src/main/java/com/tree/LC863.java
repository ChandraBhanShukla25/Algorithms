package com.tree;

import java.util.*;

public class LC863 {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null) parentMap.put(node.left, node);
            if(node.right!=null) parentMap.put(node.right, node);
        }

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;
        while(!queue.isEmpty()){
            if(currentDistance==k){
                while(!queue.isEmpty()){
                    result.add(queue.poll().val);
                }
                return result;
            }
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDistance++;
        }
        return result;
    }



    public static TreeNode createTree(List<Integer> lst, int index){
        if(index<lst.size() && lst.get(index)!=null){
            TreeNode root = new TreeNode(lst.get(index));
            root.left = createTree(lst, 2*index+1);
            root.right = createTree(lst, 2*index+2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> lst = List.of(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode root = createTree(lst, 0);
        LC863 lc863 = new LC863();
        lc863.distanceK(root, new TreeNode(5), 2 );
    }
}
