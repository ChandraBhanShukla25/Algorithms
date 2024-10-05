package com.dynamicprogramming;

import java.util.Arrays;

public class LC188BuyAndSellStocks {

    public static void main(String[] args) {
       int  k = 2; int[] prices = {3,2,6,5,0,3};
       LC188BuyAndSellStocks buyAndSellStocks = new LC188BuyAndSellStocks();
       int x = buyAndSellStocks.maxProfit(k,prices);
        System.out.println(x);
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int maxProfit = findMaxprofit(prices, n, 0, 0,k, dp);
        return maxProfit;
    }

    private int findMaxprofit(int[] prices, int n, int ind, int buy, int k, int[][][] dp) {
        if(ind==n || k==0){
            return 0;
        }
        if(dp[ind][buy][k]!=-1){
            return dp[ind][buy][k];
        }
        int profit = 0;
        if(buy==0){
           profit = Integer.max(findMaxprofit(prices, n, ind + 1, 0, k, dp), -prices[ind]+ findMaxprofit(prices,n, ind+1, 1, k, dp));
        }
        if(buy==1){
            profit = Integer.max(findMaxprofit(prices, n, ind + 1, 1, k, dp), prices[ind]+ findMaxprofit(prices,n, ind+1, 0, k-1, dp));
        }

        return dp[ind][buy][k]=profit;
    }
}
