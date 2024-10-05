package com.dynamicprogramming;

import java.util.Arrays;

public class LC560SubArraySumEqualsK {

    public static void main(String[] args) {
       int[] nums = {1,1,1};
       int k = 3;
        int[][] dp = new int[nums.length][k+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      boolean count =  countSubsets(nums, 0,0,k,dp);

        System.out.println(count);
    }

    private static boolean countSubsets(int[] nums, int index,int sum, int k,int[][] dp) {
        if(sum== k){
            return true;
        }
        if(index>=nums.length){
            return sum==k;
        }
        if(dp[index][k]!=-1){
            return dp[index][k]==k;
        }
        boolean taken= false;
        if(k>=sum) {
            taken = countSubsets(nums, index + 1, sum + nums[index], k, dp);
        }
        boolean notTaken= countSubsets(nums, index + 1, sum, k, dp);

        return taken|| notTaken;
    }
}
