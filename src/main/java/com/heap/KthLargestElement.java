package com.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
     int[] nums = {3,2,1,5,6,4};
     int k = 2;
     KthLargestElement kthLargestElement = new KthLargestElement();
     int x = kthLargestElement.findKthLargest(nums, k);
        System.out.println(x);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val:nums){
            pq.offer(val);
        }
        while(pq.size()>k){
            pq.poll();
        }
        System.out.println(pq.peek());
        return pq.peek();
    }

}
