package com.recursion;

import java.util.Arrays;

public class PerfectSumProblem {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        int target = 4;
        int n = arr.length;
        int count = perfectSum(arr,n, target);
        System.out.println(count);

    }

    public static int perfectSum(int arr[],int n, int sum) {
       int dp[][] = new int[arr.length][sum+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
       return getCount(arr, n-1, sum, dp);
    }

    private  static int getCount(int[] arr, int n, int sum, int[][] dp) {
        if(sum==0){
            return 1;
        }
        if(n==0){
            return sum==arr[n]?1:0;
        }
        if (dp[n][sum]!=-1) {
            return dp[n][sum]==0 ? 0:1;
        }
        int count1 = 0;
        int count2 = getCount(arr, n-1,sum, dp);
        if(sum-arr[n]>=0){
            count1 = getCount(arr, n-1,sum-arr[n], dp);
        }
        return dp[n][sum]= count1+count2;

    }
}
