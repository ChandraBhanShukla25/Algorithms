package com.revision.dp;

import java.util.Arrays;

public class MCM {

    public static void main(String[] args) {
       int N = 5;
       int arr[] = {40, 20, 30, 10, 30};
       int mul =  matrixMultiplication(N,arr);
        System.out.println(mul);
    }

    static int matrixMultiplication(int N, int arr[]) {
        int dp[][]= new int[N][N];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        int i =1;
        int j = N-1;

        return multiply(arr,i,j,dp);
    }

    private static int multiply(int[] arr, int i, int j, int[][] dp) {
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int ans = multiply(arr, i,k,dp) + multiply(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            mini = Math.min(mini,ans);
        }
        dp[i][j]=mini;
        return mini;
    }
}
