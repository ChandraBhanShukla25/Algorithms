package com.dynamicprogramming;

import java.util.Arrays;

public class LC518CoinChangeII {

    public static void main(String[] args) {
      int target = 4; int[] coins = {1,2,4};
      LC518CoinChangeII coinChangeII = new LC518CoinChangeII();
      int countWays = coinChangeII.change(target,coins);
      System.out.println(countWays);
    }

    public int change(int target, int[] coins) {
       int n = coins.length-1;
       int[][] dp = new int[coins.length][target+1];
       for(int arr[]: dp){
           Arrays.fill(arr,-1);
       }
       int totalWays = findWays(coins, target, n, dp);
       return totalWays;
    }

    private int findWays(int[] coins, int target, int n, int[][] dp) {

        if(target==0){
            dp[n][target]=1;
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }

        int take = 0;

        if(target>=coins[n]){
            take = findWays(coins, target-coins[n], n, dp);
        }
        int notTake = findWays(coins,target,n-1,dp);
        return dp[n][target] = take+notTake;

    }
}
