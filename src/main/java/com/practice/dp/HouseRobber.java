package com.practice.dp;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       int[] dp1 = new int[nums.length-1];
        Arrays.fill(dp1,-1);

        int[] dp2 = new int[nums.length-1];
        Arrays.fill(dp2,-1);
        int temp1[] = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            temp1[i]=nums[i];
        }

        int temp2[] = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            temp2[i-1]=nums[i];
        }
       return Integer.max(houseRob(temp1, dp1, temp1.length-1), houseRob(temp2, dp2, temp2.length-1));
    }

    private static int houseRob(int[] nums, int[] dp, int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            dp[0]=nums[0];
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        int notTake = houseRob(nums, dp, n-1);
        int take = nums[n]+houseRob(nums, dp, n-2);
        return dp[n]= Integer.max(take,notTake);
    }
}
