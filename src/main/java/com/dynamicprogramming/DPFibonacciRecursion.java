package com.dynamicprogramming;

import java.util.Arrays;

public class DPFibonacciRecursion {


    public static void main(String[] args) {
        int n =6;
        DPFibonacciRecursion fibonacciRecursion = new DPFibonacciRecursion();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int x =fibonacciRecursion.fibonacciRecursion(n,dp);
        System.out.println(x);
    }

    public int fibonacciRecursion(int n, int[] dp) {
        if (dp[n] < 0) {
            if (n <= 1) {
                dp[n] = n;
            }else {
                dp[n] = fibonacciRecursion(n - 1, dp) + fibonacciRecursion(n - 2, dp);
            }

        }
        return dp[n];
    }
}
