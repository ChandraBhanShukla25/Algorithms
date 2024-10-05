package com.practice.dp;

import java.util.Arrays;

public class LC416PartitionEqualSubset {

    public static void main(String[] args) {
        int[]  nums = {1,5,11,5};
        boolean can = canPartition(nums);
        System.out.println(can);
    }

    public static boolean canPartition(int[] nums) {
       int sum = Arrays.stream(nums).sum();
       int target = sum/2;

       int dp[][] = new int[nums.length][target+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
       int n = nums.length;
       return canPartitionSubset(nums, dp, target, n-1);
    }

    private static boolean canPartitionSubset(int[] nums, int[][] dp, int target, int n) {
       if(target==0){
           return true;
       }
       if(n==0){
           return target==nums[0];
       }
       if(dp[n][target]!=-1){
           return dp[n][target]!=0;
       }
       boolean notTake = canPartitionSubset(nums, dp, target, n-1);
       boolean take = false;
       if(target>=nums[n]){
           take = canPartitionSubset(nums, dp, target-nums[n], n-1);
       }

       dp[n][target]= take|| notTake ? 1:0;
       return notTake||take;
    }
}
