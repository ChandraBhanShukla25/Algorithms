package com.tree;

public class LC404SumLeftLeaves {


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

    static class Pair {
        TreeNode node;
        boolean isLeft;

        Pair(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }


    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;

        if (root != null) {
            if (isLeaf(root.left)) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }

            res += sumOfLeftLeaves(root.right);
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LC404SumLeftLeaves sum = new LC404SumLeftLeaves();
        int val = sum.sumOfLeftLeaves(root);
        System.out.println(val);
    }


}
