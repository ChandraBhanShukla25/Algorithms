package com.stack;

public class ImplementStackUsingArray {

    public static void main(String[] args) {
       CustomStack customStack = new CustomStack();
       customStack.push(10);
       customStack.push(15);
        System.out.println(customStack.size());
        System.out.println(customStack.pop());
        System.out.println(customStack.top());
        System.out.println(customStack.size());
        System.out.println(customStack.pop());
        System.out.println(customStack.size());
        System.out.println(customStack.pop());
        System.out.println(customStack.top());
    }

    static class CustomStack{
        int top=-1;
        int[] arr = new int[1000];
        int size = arr.length;

        void push(int x){
            if(top==size){
                return;
            }
          arr[++top]=x;
        }

        int pop(){
            if(top==-1){
                return top;
            }else {
                return arr[top--];
            }
        }

        int top(){
            if(top==-1){
                return -1;
            }
           return arr[top];
        }

        int size(){
           return top+1;
        }
    }
}
