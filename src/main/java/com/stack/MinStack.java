package com.stack;

import java.util.Stack;

public class MinStack {
    Stack<Pair> stack = new Stack<>();

    class Pair{
        int min; int val;
    }
    public MinStack() {

    }

    public void push(int val) {
       if(stack.isEmpty()){
           Pair pair = new Pair();
           pair.min=val;
           pair.val=val;
           stack.push(pair);
       }else{
          Pair oldPair =  stack.peek();
          if(oldPair.min<val){
              Pair newPair = new Pair();
              newPair.min= oldPair.min;
              newPair.val= val;
              stack.push(newPair);
          }else{
              Pair newPair = new Pair();
              newPair.min= val;
              newPair.val= val;
              stack.push(newPair);
          }
       }
    }

    public void pop() {
        if(stack.isEmpty()){
            return ;
        }
       Pair pair = stack.pop();
    }

    public int top() {
        if(stack.isEmpty()){
            return 0;
        }
       Pair pair = stack.peek();
       return pair.val;
    }

    public int getMin() {
        if(stack.isEmpty()){
            return 0;
        }
      Pair pair = stack.peek();
      return pair.min;
    }
}
