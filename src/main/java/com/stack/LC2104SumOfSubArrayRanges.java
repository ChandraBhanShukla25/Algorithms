package com.stack;

import java.util.Stack;

public class LC2104SumOfSubArrayRanges {

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       LC2104SumOfSubArrayRanges subArrayRanges = new LC2104SumOfSubArrayRanges();
       long x = subArrayRanges.subArrayRanges(nums);
        System.out.println(x);
    }

    public long subArrayRanges(int[] nums) {
        int maxSum = 0;
      for(int i=0;i<nums.length;i++){
          int min = Integer.MAX_VALUE;
          int max = Integer.MIN_VALUE;
          for(int j=i; j<nums.length;j++){
              min = Integer.min(nums[j], min);
              max = Integer.max(nums[j], max);
              maxSum = Integer.max(maxSum, max-min);
          }
      }
      return maxSum;
    }
}
