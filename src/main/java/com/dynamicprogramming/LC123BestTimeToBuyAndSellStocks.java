package com.dynamicprogramming;

import java.util.Arrays;

public class LC123BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        LC123BestTimeToBuyAndSellStocks buyAndSellStocks = new LC123BestTimeToBuyAndSellStocks();
        int x = buyAndSellStocks.maxProfit(prices);
        System.out.println(x);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findMaxProfit(prices, n,0,0,2,dp);
    }

    private int findMaxProfit(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        if(ind==n || cap==0)
            return 0;
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit=0;
        if(buy==0){
            profit = Integer.max(findMaxProfit(prices,n,ind+1,0,cap,dp), -prices[ind]+findMaxProfit(prices,n,ind+1,1,cap,dp));
        }

        if(buy==1){
            profit = Integer.max(findMaxProfit(prices,n,ind+1,1,cap,dp), prices[ind]+findMaxProfit(prices,n,ind+1,0,cap-1,dp));
        }
       return dp[ind][buy][cap]=profit;
    }
}
