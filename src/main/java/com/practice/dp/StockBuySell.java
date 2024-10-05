package com.practice.dp;

import java.util.Arrays;

public class StockBuySell {

    public static void main(String[] args) {
      int[] arr = {1, 3, 2, 8, 4, 9};
      int fee = 2;
      System.out.println(stockBuySell(arr, arr.length, fee));
    }

    public static int stockBuySell(int[] arr, int n, int fee) {
        int[][] dp = new int[arr.length][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return maximize(arr, dp, 0, fee, 0);
    }

    private static int maximize(int[] arr, int[][] dp, int n, int fee, int buy) {
        if(n==arr.length){
            return 0;
        }
        if(dp[n][buy]!=-1){
            return dp[n][buy];
        }

        int profit = Integer.MIN_VALUE;
        if(buy==0){
            profit = Integer.max(-arr[n]+ maximize(arr, dp, n+1, fee, 1), maximize(arr, dp, n+1, fee, 0));
        }
        if(buy==1){
            profit = Integer.max(arr[n]-fee+ maximize(arr,dp, n+1,fee, 0), maximize(arr,dp,n+1,fee, 1));
        }

        return dp[n][buy]= profit;
    }
}
