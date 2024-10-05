package com.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueueLC225 {

    public static void main(String[] args) {
       MyStack stack = new MyStack();
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
       stack.push(10);
       stack.push(3);
        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());


    }

    static class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        public MyStack() {

        }

        public void push(int x) {
           queue.add(x);
           for(int i=0;i<queue.size()-1;i++){
               queue.add(queue.remove());
           }
        }

        public int pop() {
            if(queue.isEmpty()){
                return 0;
            }
          return queue.remove();
        }

        public int top() {
            if(queue.isEmpty()){
                return 0;
            }
         return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
