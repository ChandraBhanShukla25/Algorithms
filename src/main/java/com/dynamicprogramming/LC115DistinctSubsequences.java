package com.dynamicprogramming;

import java.util.Arrays;

public class LC115DistinctSubsequences {

    public static void main(String[] args) {
        LC115DistinctSubsequences distinctSubsequences = new LC115DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int x =  distinctSubsequences.numDistinct(s, t);
        System.out.println(x);
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int result = findDistinct(s, t, m-1,n-1, dp);
        return result;
    }


    public int findDistinct(String s, String t, int m , int n, int dp[][]){

       if(n<0){
           return 1;
       }
        if(m<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
       int x=0;
       int y = 0;
       if(s.charAt(m)==t.charAt(n)) {
           x  = findDistinct(s, t, m-1, n-1, dp) + findDistinct(s,t,m-1, n, dp);
       }else{
           y = findDistinct(s,t,m-1,n, dp);
       }
       return dp[m][n] = x+y;
    }
}
