package com.practice.dp;

import java.util.Arrays;

public class RodcutLc1547 {

    public static void main(String[] args) {
       int n= 9; int[] cuts = {5,6,1,4,2};
        System.out.println(minCost(n,cuts));
    }

    public static int minCost(int n, int[] cuts) {
       int[][]dp = new int[cuts.length][n+1];
       for(int[] row: dp){
           Arrays.fill(row,-1);
       }
       return minCostToCut(cuts.length-1, n, cuts, dp);
    }

    private static int minCostToCut(int idx, int n, int[] cuts, int[][] dp) {
        if(idx==0){
            return n/cuts[idx];
        }
        if(dp[idx][n]!=-1){
            return dp[idx][n];
        }

        int nocut = minCostToCut(idx-1,n,cuts, dp);
        int cut = Integer.MAX_VALUE;
        if(n<=idx+1){
            cut = cuts[idx]+minCostToCut(idx, n-idx, cuts, dp);
        }
        return dp[idx][n]=Integer.min(cut, nocut);
    }
}
