package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaTraining {

    public static void main(String[] args) {
        int n=3;
        int[][] arr = {{1,2,5},{3,1,1},{3,3,3}};
        int x= maximumPoints(arr, n);
        System.out.println(x);
    }

    public static int maximumPoints(int arr[][], int N) {
        int[][] dp = new int [arr.length][4];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return getMaxmimumPoint(arr, dp, N-1, 3);
    }

    private static int getMaxmimumPoint(int[][] arr, int[][] dp, int n, int last) {
        if(dp[n][last]!=-1){
            return dp[n][last];
        }
        if(n==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                maxi = Integer.max(maxi, arr[n][i]);
            }
            return dp[n][last] = maxi;
        }
        int maxi = 0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int activity = arr[n][i]
                        + getMaxmimumPoint(arr,dp, n-1,i);
                maxi = Integer.max(maxi,activity);
            }
        }
        return dp[n][last]=maxi;
    }
}
