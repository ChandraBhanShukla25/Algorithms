package com.practice.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
       int[] coins = {1,2,5};
       int amount = 11;
       int count = coinChange(coins, amount);
        System.out.println(count);
    }

    public static int coinChange(int[] coins, int amount) {
     int[][] dp = new int[coins.length+1][amount+1];
     for(int[] row: dp){
         Arrays.fill(row,-1);
     }

     return findCoins(coins, amount, dp, coins.length-1);
    }

    private static int findCoins(int[] coins, int amount, int[][] dp, int idx) {
        if(idx==0) {
            if (amount % coins[0] == 0) {
                dp[idx][amount] = amount / coins[0];
                return amount / coins[0];
            }else
                return 1000000;
        }

        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }

        int pick = 1001000;
        if(amount>=coins[idx]){
            pick = 1+ findCoins(coins, amount-coins[idx], dp, idx);
        }
        int notPick = findCoins(coins,amount,dp,idx-1);
        return dp[idx][amount]=Integer.min(pick,notPick);
    }
}
