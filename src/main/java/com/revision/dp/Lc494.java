package com.revision.dp;

import java.util.Arrays;

public class Lc494 {

    public static void main(String[] args) {
      int[] nums = {1,1,1,1,1};
      int target = 3;
      int count = findTargetSumWays(nums, target);
      System.out.println(count);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1000000);
        }
        return findTargetWays(nums, target, nums.length-1, dp, 0);
    }

    private static int findTargetWays(int[] nums, int target, int idx, int[][] dp, int val) {
        if(idx<=0){
            return val==target ? 1:0;
        }
        if(val==target){
            return 1;
        }


        if(dp[idx][target]!=-1000000){
            return dp[idx][target];
        }

        int plus = findTargetWays(nums, target, idx-1, dp, val+nums[idx]);
        int minus = findTargetWays(nums, target, idx-1, dp, val-nums[idx]);

        return dp[idx][target] = plus+minus;
    }

}
