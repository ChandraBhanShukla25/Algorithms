package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalLC545 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        BoundaryTraversalLC545 boundaryTraversal = new BoundaryTraversalLC545();
        List<Integer> result = boundaryTraversal.getBoundary(root);
        System.out.println(result);
    }

    public List<Integer> getBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        leftBoundary(root, result);
        leaf(root, result);
        rightBoundary(root, result);
        return result;
    }

    public void leftBoundary(TreeNode root, List<Integer> result) {
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            if (node.left != null)
                node = node.left;
            else
                node = node.right;

        }
    }

    public void leaf(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null)
            leaf(root.left, result);
        if (root.right != null)
            leaf(root.right, result);
    }

    public void rightBoundary(TreeNode root, List<Integer> result) {
        TreeNode node = root.right;
        List<Integer> rightList = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                rightList.add(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        for (int i = rightList.size() - 1; i >= 0; i--) {
            result.add(rightList.get(i));
        }
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }


}


