package com.dynamicprogramming;

import java.util.Arrays;

public class LC714BuyAndSellStocksWithTransactionFees {

    public static void main(String[] args) {
      int[] prices = {1,3,2,8,4,9};
      int fee = 2;
      LC714BuyAndSellStocksWithTransactionFees buyAndSellStocksWithTransactionFees = new LC714BuyAndSellStocksWithTransactionFees();
      System.out.println(buyAndSellStocksWithTransactionFees.maxProfit(prices,fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int n =prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findMaxProfit(prices,n,0,0,fee,dp);
    }

    private int findMaxProfit(int[] prices, int n, int idx, int buy, int fee, int[][] dp) {
        if(idx==n)
            return 0;
        if(dp[idx][buy]!=-1)
            return dp[idx][buy];

        int profit = 0;
        if(buy==0){
            profit = Integer.max(findMaxProfit(prices,n,idx+1,0,fee,dp), -prices[idx]+findMaxProfit(prices,n,idx+1,1,fee,dp));
        }
        if(buy==1){
            profit = Integer.max(findMaxProfit(prices,n,idx+1,1,fee,dp), prices[idx]-fee+findMaxProfit(prices,n,idx+1,0,fee,dp));
        }
        return dp[idx][buy]=profit;
    }
}
