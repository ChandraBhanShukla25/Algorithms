package com.dynamicprogramming;

import java.util.Arrays;

public class LC122BuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices  = {1,2,3,4,5};
        LC122BuyAndSellStocks stocks = new LC122BuyAndSellStocks();
        int value = stocks.maxProfit(prices);
        System.out.println(value);

    }

    public int maxProfit(int[] prices) {
        int n = 0;
        int buy = 0;
        int[][] dp = new int[prices.length][2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return findMaxProfit(prices, n, buy, dp);
    }

    private int findMaxProfit(int[] prices, int n, int buy, int[][] dp) {
        if(n==prices.length){
            return 0;
        }
        int maxProfitBuy = 0;
        int maxProfitSell = 0;
        if(dp[n][buy]!=-1){
            return dp[n][buy];
        }
        if(buy==0){
            maxProfitBuy = Integer.max(-prices[n]+ findMaxProfit(prices, n+1,1, dp), findMaxProfit(prices,n+1,0, dp));
        }else{
            maxProfitSell = Integer.max(prices[n]+findMaxProfit(prices,n+1, 0, dp), findMaxProfit(prices, n+1, 1, dp));
        }

        return dp[n][buy] =Integer.max(maxProfitBuy,maxProfitSell);
    }
}
