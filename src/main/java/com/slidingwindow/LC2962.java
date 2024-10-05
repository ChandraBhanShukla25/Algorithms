package com.slidingwindow;

import java.util.Arrays;

public class LC2962 {

    public static void main(String[] args) {
        int [] nums = {1,3,2,3,3};
        int k = 2;
        LC2962 lc2962 = new LC2962();
        long count = lc2962.countSubarrays(nums, k);
        System.out.println(count);
    }

    public long countSubarrays(int[] nums, int k) {
       int high = 0;
       int low = 0;
       int count = 0;
       int res = 0;
       int n = nums.length;
       int max = Arrays.stream(nums).max().getAsInt();
       int maxCount = 0;
       while(high<n){
          if(nums[high]==max){
              maxCount++;
          }
          if(maxCount==k) {
              while (maxCount == k && low<n) {
                  if (nums[low] == k) {
                      maxCount--;
                  }
                  low++;
              }
              count +=high-low+1;
          }
          res+=count;
          high++;
       }
       return res;
    }
}
