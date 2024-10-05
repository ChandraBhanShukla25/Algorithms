package com.revision.dp;


public class RodCutting {

    public static void main(String[] args) {
        int N = 8;
        int Price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int dp[] = new int[N+1];
        int val = cutRod(Price, N);
        System.out.println(val);
    }

    public static int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
           int maxVal = Integer.MIN_VALUE;
           for(int j=0;j<i;j++){
               maxVal = Integer.max(maxVal,price[j] + dp[i-j-1]);
           }
           dp[i]= maxVal;
        }
        return dp[n];
    }
}
