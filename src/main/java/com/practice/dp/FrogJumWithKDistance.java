package com.practice.dp;

import java.util.Arrays;

public class FrogJumWithKDistance {

    public static void main(String[] args) {
        int n = 4; int k = 2;
        int[] height = {10, 40, 30, 10};
        int x = frogJump(n,k,height);
        System.out.println(x);
    }


    public static int frogJump(int n, int k, int[] heights){
        int[] dp = new int[heights.length];
        Arrays.fill(dp,-1);
        return calculateFrogJump(n-1, k, heights, dp);
    }

    private static int calculateFrogJump(int n, int k, int[] heights, int[] dp) {
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0) {
                int jump = calculateFrogJump(n - i, k, heights, dp) + Math.abs(heights[n] - heights[n - i]);
                minSteps = Integer.min(minSteps,jump);
            }
        }
        return dp[n]=minSteps;
    }
}
