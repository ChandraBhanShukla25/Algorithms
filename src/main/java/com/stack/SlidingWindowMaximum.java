package com.stack;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
       int[] nums = {1,3,-1,-3,5,3,6,7};
       int k = 3;

       SlidingWindowMaximum maximum = new SlidingWindowMaximum();
       int[] arr = maximum.maxSlidingWindow(nums, k);
       Arrays.stream(arr).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx=0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!q.isEmpty() && q.peek()==i-k){
                q.poll();
            }

            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                result[idx++]=nums[q.peek()];
            }

        }
        return result;
    }
}
