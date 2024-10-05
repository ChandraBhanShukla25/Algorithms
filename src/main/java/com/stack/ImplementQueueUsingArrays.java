package com.stack;

public class ImplementQueueUsingArrays {


    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        System.out.println(customQueue.size());
        customQueue.add(10);
        customQueue.add(20);
        System.out.println(customQueue.peek());
        System.out.println(customQueue.remove());
        System.out.println(customQueue.size());
        System.out.println(customQueue.peek());
        System.out.println(customQueue.remove());
        System.out.println(customQueue.size());
    }


    static class CustomQueue{
        int[] queue = new int[1000];
        int top = -1;
        int bottom = -1;

       void add(int x){
           queue[++top]=x;
       }
       int remove(){
           return queue[++bottom];
       }
       int size(){
           return top-bottom;
       }

       public int peek() {
           return -1;
        }
    }
}
