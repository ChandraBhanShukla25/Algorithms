package com.revision.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
      int[] coins = {1,2,5};
      int amount = 11;
      int noOfCoins  = coinChange(coins, amount);
      System.out.println(noOfCoins);
    }

    public static int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length+1][amount+1]; //4,12
      for(int i=0;i<dp.length;i++){
          Arrays.fill(dp[i],-1);
      }
      int x =  noOfCoins(coins, dp, amount, coins.length-1);
        if(x==1000000){
            return -1;
        }
        return x;
    }

    private static int noOfCoins(int[] coins, int[][] dp, int amount, int idx) {
        if(idx==0){
            if(amount%coins[idx]==0){
                dp[idx][amount] = amount/coins[idx];
                return amount/coins[idx];
            }else{
                return 1000000;
            }
        }

        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }

        int take = Integer.MAX_VALUE;
        if(amount-coins[idx]>=0){
            take = 1 + noOfCoins(coins, dp, amount-coins[idx], idx);
        }

        int notTake = noOfCoins(coins, dp, amount, idx-1);

        return dp[idx][amount]=Integer.min(take,notTake);
    }


}
