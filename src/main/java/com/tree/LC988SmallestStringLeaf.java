package com.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class LC988SmallestStringLeaf {

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


   static class Pair{
          TreeNode node;
          String pattern;
          TreeNode parent;

          Pair(TreeNode node, String pattern, TreeNode parent){
              this.node=node;
              this.pattern = pattern;
              this.parent = parent;
          }
  }
    public String smallestFromLeaf(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, "" + (char) (97 + root.val), null));
        List<String> lst = new ArrayList<>();
        if (root == null)
            return "";
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            TreeNode current = currentPair.node;
            String pattern = currentPair.pattern;
            if (current != null) {
                if (current.left == null && current.right == null) {
                    lst.add(currentPair.pattern);
                }
                if (current.left != null) {
                    queue.add(new Pair(current.left, ((char) (97 + current.left.val)) + pattern, current));
                }

                if (current.right != null) {
                    queue.add(new Pair(current.left, ((char) (97 + current.right.val)) + pattern, current));
                }

            }
        }
        Comparator<String> comparator = String::compareTo;
        lst.sort(comparator);
        return lst.get(0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        LC988SmallestStringLeaf smallestStringLeaf = new LC988SmallestStringLeaf();
        String str = smallestStringLeaf.smallestFromLeaf(root);
        System.out.println(str);
    }
}
