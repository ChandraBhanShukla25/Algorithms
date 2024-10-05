package com.stack;

import java.util.Stack;

public class QueueUsingStack {


    static class MyQueue {
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
          while(!inStack.empty()){
              outStack.push(inStack.peek());
              inStack.pop();
          }
          inStack.push(x);
          while(!outStack.empty()){
              inStack.push(outStack.peek());
              outStack.pop();
          }
        }

        public int pop() {
           return inStack.pop();
        }

        public int peek() {
           return inStack.peek();
        }

        public boolean empty() {
           return inStack.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());

    }
}
