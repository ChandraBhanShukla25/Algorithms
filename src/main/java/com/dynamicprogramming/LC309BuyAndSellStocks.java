package com.dynamicprogramming;

import java.util.Arrays;

public class LC309BuyAndSellStocks {

    public static void main(String[] args) {
       int[] prices = {1};
       LC309BuyAndSellStocks buyAndSellStocks = new LC309BuyAndSellStocks();
       int x = buyAndSellStocks.maxProfit(prices);
        System.out.println(x);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findMaxProfit(prices,n,0 ,0,dp);
    }

    private int findMaxProfit(int[] prices, int n, int idx, int buy, int[][] dp) {
        if(idx==n){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy==0){
            profit= Integer.max(findMaxProfit(prices,n,idx+1,0,dp), -prices[idx]+findMaxProfit(prices,n,idx+1,1,dp));
        }
        if(buy==1){
            profit= Integer.max(findMaxProfit(prices,n,idx+1,1,dp), prices[idx]+findMaxProfit(prices,n,idx+1,2,dp));
        }
        if(buy==2){
            profit= findMaxProfit(prices,n,idx+1,0,dp);
        }
        return dp[idx][buy]=profit;
    }
}
