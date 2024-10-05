package com.practice.dp;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
       int amount = 5; int[] coins = {1,2,5};
        System.out.println(change(amount,coins));
    }

    public static int change(int target, int[] coins) {
        int[][] dp = new int[coins.length][target+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return findWays(coins,dp, target, coins.length-1);
    }

    private static int findWays(int[] coins, int[][] dp, int target, int n) {
        if(n==0){
            if(target%coins[n]==0) return 1;
            else
                return 0;
        }
        if(n<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int pick = 0;
        int notPick = findWays(coins,dp,target,n-1);
        if(target>=coins[n]){
            pick = findWays(coins, dp, target-coins[n], n);
        }
        return dp[n][target]=pick+notPick;
    }
}
