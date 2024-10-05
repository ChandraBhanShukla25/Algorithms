package com.revision.dp;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
       int amount = 5;
       int[] coins = {1,2,5};
       int val = change(amount,coins);
        System.out.println(val);
    }

    public static int change(int target, int[] coins) {
        int[][] dp = new int[coins.length][target+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return findWays(coins,dp, target, coins.length-1);
    }

    private static int findWays(int[] coins, int[][] dp, int target, int idx) {
        if(idx<0)
            return 0;
        if(idx==0){
            if(target%coins[idx]==0)
                return 1;
            else return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }

        int take = 0;
        if(target-coins[idx]>=0){
            take = findWays(coins, dp, target-coins[idx], idx);
        }
        int notTake = findWays(coins, dp, target, idx-1);
        return dp[idx][target]= take+notTake;

    }
}
