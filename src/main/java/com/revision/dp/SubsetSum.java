package com.revision.dp;

import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean flag = canPartition(nums);
        System.out.println(flag);
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target = sum/2;
        if(sum%2!=0){
            return false;
        }
        Boolean[][] dp = new Boolean[nums.length+1][target+1];
        boolean isPossible = subsetSum(nums, dp,target, nums.length-1);
        return isPossible;
    }

    private static boolean subsetSum(int[] nums,Boolean[][] dp,  int target, int i) {
        if(target==0){
            return true;
        }
        if(i==0 || target<0){
            return false;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }

        boolean res = subsetSum(nums, dp, target-nums[i], i-1) || subsetSum(nums, dp, target, i-1);

        dp[i][target]=res;
        return res;

    }

}
