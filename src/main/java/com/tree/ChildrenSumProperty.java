package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {


    public static int isSumProperty(Node root) {
       if(root== null || (root.left==null && root.right==null)) return 1;
       else{
           int leftData = 0;
           int rightData = 0;

           if(root.left!=null) leftData = root.left.data;
           if(root.right!=null) rightData = root.right.data;

           if(root.data==leftData+rightData && (isSumProperty(root.left)!=0 && isSumProperty(root.right)!=0)){
               return 1;
           }else return 0;
       }
    }

    public static void main(String[] args) {
        Node root = new Node(35);
        root.left = new Node(20);
        root.right = new Node(15);
        root.left.left = new Node(15);
        root.left.right = new Node(5);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        int isSum = isSumProperty(root);
        System.out.println(isSum);
    }
}
