package com.codingNinjas.dp;

import java.util.Arrays;

public class FrogJump {


    public static void main(String[] args) {
        int[] height ={30,10,60,10,60,50};
        int n=height.length;
        System.out.println(frogJump(n,height));
    }
    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1, heights, dp );
    }

    public static int solve(int idx, int[] heights, int[] dp){
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = solve(idx-1,heights,dp)+Math.abs(heights[idx] - heights[idx-1]);
        if(idx>1){
            jumpTwo = solve(idx-2,heights,dp)+Math.abs(heights[idx] - heights[idx-2]);
        }
        return dp[idx]= Math.min(jumpOne, jumpTwo);
    }
}
