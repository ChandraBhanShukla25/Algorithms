package com.dynamicprogramming;

import java.util.Arrays;

public class FrogJumpMinimalEnerygy {

    public static void main(String[] args) {
      int[] arr = {10, 20, 30, 10};
      int[] arr1 = {10,50,10};
      int[] arr2 = {4};
      int x = frogJump(arr.length-1, arr);
        int y = frogJump(arr1.length-1, arr1);
        int z = frogJump(arr2.length-1, arr2);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp,-1);

        int dp1[] = new int[arr.length+1];
        Arrays.fill(dp1,-1);

        int dp2[] = new int[arr.length+1];
        Arrays.fill(dp2,-1);

        //using memoization
        int dpx = frogJumpUsingMemoization(arr.length-1, arr, dp);
        int dpy = frogJumpUsingMemoization(arr1.length-1, arr1, dp1);
        int dpz = frogJumpUsingMemoization(arr2.length-1, arr2, dp2);
        System.out.println(dpx);
        System.out.println(dpy);
        System.out.println(dpz);

       //using tabulation
        int dpx1 = frogJumpUsingTabulation(arr.length-1, arr);
        int dpy1 = frogJumpUsingTabulation(arr1.length-1, arr1);
        int dpz1 = frogJumpUsingTabulation(arr2.length-1, arr2);
        System.out.println(dpx1);
        System.out.println(dpy1);
        System.out.println(dpz1);
    }

    public static int frogJumpUsingTabulation(int n, int[] heights){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int left =  Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) {
                right = Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = dp[i-1] + Integer.min(right,left);
        }
        return dp[n];
    }
    public static  int frogJumpUsingMemoization(int n, int heights[], int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int oneStep=Integer.MAX_VALUE;
        if(n>=1){
            oneStep = frogJumpUsingMemoization(n-1,heights, dp)+Math.abs(heights[n]-heights[n-1]);
        }
        int twoSteps = Integer.MAX_VALUE;
        if(n>1){
            twoSteps = frogJumpUsingMemoization(n-2,heights, dp)+Math.abs(heights[n]-heights[n-2]);
        }
        dp[n]=Math.min(oneStep,twoSteps);
        return dp[n];
    }
    public static int frogJump(int n, int heights[]) {

        if(n==0){
            return 0;
        }
        int oneStep=Integer.MAX_VALUE;
        if(n>=1) {
            oneStep = frogJump(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        }
        int twoStep=Integer.MAX_VALUE;
        if(n>1) {
            twoStep = frogJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return Integer.min(oneStep,twoStep);
    }
}
