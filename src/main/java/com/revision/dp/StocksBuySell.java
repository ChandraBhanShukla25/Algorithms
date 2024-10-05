package com.revision.dp;

import java.util.Arrays;

public class StocksBuySell {
    public static void main(String[] args) {
        int N = 6;
        int[] PRICES = {3, 2, 6, 5, 0, 3};
        int  K = 2;
       int x =  maximumProfit(PRICES,N,K);
        System.out.println(x);
    }

    public static int maximumProfit(int[] prices, int n, int k)
    {
       int dp[][][] = new int[prices.length][2][k+1];

       for(int i=0;i<dp.length;i++){
           for(int j=0;j<2;j++){
               Arrays.fill(dp[i][j],-1);
           }
       }
        int val = findMaxProfit(prices, 0, k, dp, 0);
        return val;
    }

    private static int findMaxProfit(int[] prices, int n, int k, int[][][] dp, int buy) {
        if(k==0 || n==prices.length){
            return 0;
        }
        if(dp[n][buy][k]!=-1){
            return dp[n][buy][k];
        }

       int profit = 0;
        if(buy==0){
            profit = Math.max(-prices[n]+ findMaxProfit(prices,n+1,k,dp,1), findMaxProfit(prices, n+1,k,dp,0));
        }else{
            profit = Integer.max(prices[n] + findMaxProfit(prices,n+1, k-1,dp, 0 ),findMaxProfit(prices, n+1,k,dp,1));
        }

         dp[n][buy][k]=profit;
        return profit;


    }
}
