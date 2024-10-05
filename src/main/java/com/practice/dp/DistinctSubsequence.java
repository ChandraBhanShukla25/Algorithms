package com.practice.dp;

import java.util.Arrays;

public class DistinctSubsequence {

    public static void main(String[] args) {
       String s = "axbxax"; String  t = "axa";
        System.out.println(distinctSubsequences(s,t));
    }

    public static int distinctSubsequences(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return countUtil(s,t,s.length()-1,t.length()-1, dp);
    }

    private  static int countUtil(String s, String t, int i, int j, int[][] dp) {
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        int x= 0; int y=0;
        if(s.charAt(i)==t.charAt(j)){
            int a = countUtil(s,t,i-1,j-1,dp);
            int b = countUtil(s,t,i-1,j,dp);
            x=a+b;
        }else{
            y = countUtil(s,t,i-1,j,dp);
        }

        return dp[i][j]=x+y;
    }
}
