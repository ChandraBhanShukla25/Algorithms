package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) {
        //int arr[] ={1,2,3,1,3,5,8,1,9};
        List<Integer> l = Arrays.asList(1,2,3,1,3,5,8,1,9);
        int sum = maximumNonAdjacentSum(l);
        System.out.println(sum);
    }

    public static int maximumNonAdjacentSum(List<Integer> nums) {
        int dp[] = new int[nums.size()];
        Arrays.fill(dp,-1);
        return maximumSum(nums, nums.size()-1, dp);
    }

    private static int maximumSum(List<Integer> nums, int index, int dp[]) {
        int n = nums.size();
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums.get(index);
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = nums.get(index)+maximumSum(nums, index-2, dp);
        int notPick = maximumSum(nums, index-1,dp);
        dp[index] = Integer.max(pick,notPick);
        return dp[index];
    }
}
