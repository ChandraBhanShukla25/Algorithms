package com.dynamicprogramming;

import java.util.Arrays;

public class LC322CoinChange {

    public static void main(String[] args) {
       int[] coins = {1,2,5};
       int amount = 11;
       LC322CoinChange coinChange = new LC322CoinChange();
       int count = coinChange.coinChange(coins,amount);
       System.out.println(count);
    }

    public int coinChange(int[] coins, int amount) {
       int[][] dp = new int[coins.length+1][amount+1];
       for(int[] row:dp){
           Arrays.fill(row,-1);
       }
       return getCoinsRequired(coins, amount, coins.length-1, dp);
    }

    public int getCoinsRequired(int[] coins, int target, int n, int[][] dp){
        if(n==0){
            if(target%coins[0]==0){
                dp[n][target]=target/coins[0];
                return target/coins[0];
            }
            return 1000000;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int take = 1000000;
        if(target>=coins[n]) {
            take = 1 + getCoinsRequired(coins, target - coins[n], n, dp);
        }

        int notTake = getCoinsRequired(coins,target, n-1, dp);

        return dp[n][target] = Integer.min(take, notTake);
    }
}
