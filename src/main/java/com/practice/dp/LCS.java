package com.practice.dp;

import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {
      String str1 = "bdefg";
      String str2 = "bfg";
        System.out.println(lcs(str1,str2));
    }

    public static int lcs( String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return lcsLength(str1, str2, m-1,n-1, dp);
    }

    public static int lcsLength(String s1, String s2, int m, int n, int[][] dp){
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int take = 0;
        int notTake = 0;
        if(s1.charAt(m)==s2.charAt(n)){
            take = 1+lcsLength(s1, s2, m-1,n-1, dp);
        }else{
            notTake = Integer.max(lcsLength(s1,s2, m-1,n, dp), lcsLength(s1,s2,m,n-1,dp));
        }
        return dp[m][n]= Integer.max(take,notTake);
    }
}
