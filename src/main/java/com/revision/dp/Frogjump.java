package com.revision.dp;

import java.util.Arrays;

public class Frogjump {

    public static int minimizeCost(int n, int k, int[] heights){
       int[] dp = new int[heights.length+1];
        Arrays.fill(dp,-1);
        int x = minCost(n-1, k, heights, dp);
        return x;
    }

    public static  int minCost(int n, int k, int[] heights, int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int minSteps = Integer.MAX_VALUE;
        int take = 0;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                take = minCost(n-i, k, heights, dp)+ Math.abs(heights[n]-heights[n-i]);
                minSteps = Integer.min(minSteps,take);
            }
        }
        return dp[n] = minSteps;

    }

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int[] height = {2, 5, 2};
        int x = minimizeCost(n,k,height);
        System.out.println(x);
    }
}
