package com.heap;

import java.util.PriorityQueue;

public class KthSmallestElememt {

    public static void main(String[] args) {
       int arr[] = {7 ,10, 4, 3, 20, 15};
       int k=3;
       int x = kthSmallest(arr,0,arr.length,k);
        System.out.println(x);
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr){
            pq.add(i);
        }

        while(pq.size()>arr.length-k+1){
            pq.poll();
        }

        System.out.println(pq.peek());

        return pq.peek();

    }
}
