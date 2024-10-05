package com.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC230Kth {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        findKthSmallest(root, lst);
        Collections.sort(lst);
        return lst.get(k-1);
    }

    private void findKthSmallest(TreeNode root, List<Integer> lst) {
        if(root!=null){
            lst.add(root.val);
            findKthSmallest(root.left, lst);
            findKthSmallest(root.right, lst);
        }
    }

    public static void main(String[] args) {
        List<Integer> l = List.of(3,1,4,5,2);
        int k = 1;
        LC230Kth lc230Kth = new LC230Kth();
        TreeNode root = lc230Kth.createTree(l, 0);
        int val = lc230Kth.kthSmallest(root, k);
        System.out.println(val);
    }

    public TreeNode createTree(List<Integer> lst, int index){
        if(index<lst.size() && lst.get(index)!=null){
            TreeNode root = new TreeNode(lst.get(index));
            root.left = createTree(lst, 2*index+1);
            root.right = createTree(lst, 2*index+2);
            return root;
        }
        return null;
    }
}
