package com.revision.dp;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int val = rob(nums);
        System.out.println(val);
    }

    public static int rob(int[] nums) {
      int[] arr1 = new int[nums.length-1];
      int[] arr2 = new int[nums.length-1];
      for(int i=0;i<nums.length-1;i++){
          arr1[i] = nums[i];
      }
      for(int i=1;i<nums.length;i++){
          arr2[i-1] = nums[i];
      }
      int[] dp1 = new int[arr1.length+1];
      int[] dp2 = new int[arr2.length+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
      return Integer.max(maxRob(arr1, arr1.length-1,dp1 ), maxRob(arr2,arr2.length-1,dp2));
    }

    private static int maxRob(int[] arr1, int idx, int[] dp) {
        if(idx<0){
            return 0;
        }
        if(idx==0){
            return arr1[0];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int take = arr1[idx] + maxRob(arr1, idx - 2, dp);
        int notTake =  maxRob(arr1, idx - 1, dp);
        return dp[idx] = Integer.max(take,notTake);

    }

    }
