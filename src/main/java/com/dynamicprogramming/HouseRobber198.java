package com.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber198 robber198 = new HouseRobber198();
        int x= robber198.rob(nums);
        System.out.println(x);
    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return robHouse(nums, dp, nums.length-1);
    }

    public int robHouse(int[] nums, int[] dp, int n){

        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int pick=0;
        if(n>=2) {
            pick = nums[n] + robHouse(nums, dp, n - 2);
        }
        int notPick=0;
        notPick = robHouse(nums, dp, n - 1);
        return Math.max(pick,notPick);

    }
}
