package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderSingleStack {


    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        PostOrderSingleStack postOrderSingleStack = new PostOrderSingleStack();
        List<Integer> postOrder = postOrderSingleStack.postOrderTrav(root);
        System.out.println(postOrder);
    }

    List<Integer> postOrderTrav(Node root){
      List<Integer> postOrder = new ArrayList<>();
      if(root==null)
          return postOrder;
      Stack<Node> stack = new Stack<>();
      while(root!=null || !stack.isEmpty()){
          if(root!=null){
              stack.push(root);
              root=root.left;
          }else{
              Node temp = stack.peek().right;
              if(temp==null){
                  temp=stack.peek();
                  stack.pop();
                  postOrder.add(temp.data);
                  while (!stack.isEmpty() && temp==stack.peek().right){
                      temp=stack.peek();
                      stack.pop();
                      postOrder.add(temp.data);
                  }
              }else{
                  root=temp;
              }
          }
      }
      return  postOrder;
    }
}
