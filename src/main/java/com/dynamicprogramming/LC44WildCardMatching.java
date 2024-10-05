package com.dynamicprogramming;

import java.util.Arrays;

public class LC44WildCardMatching {

    public static void main(String[] args) {
       String s = "aa";
       String p = "a";
       LC44WildCardMatching wildCardMatching = new LC44WildCardMatching();
       boolean flag = wildCardMatching.isMatch(s,p);
        System.out.println(flag);
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] dp = new int[m+1][n+1];

        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

       int isMatch=  findMatch(s, p, m-1,n-1, dp);
        return isMatch==1? true: false;
    }

    private int findMatch(String s, String p, int m, int n, int[][] dp) {

        if(m<0 && n<0)
            return 1;

        if(m<0 && n>=0)
            return 0;

        if(n<0 && m>=0){
            return isAllStars(s,m)? 1:0;
        }

        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        if(s.charAt(m)==p.charAt(n) || s.charAt(m)=='?')
            return dp[m][n]= findMatch(s,p,m-1,n-1,dp);
        else{
            if(s.charAt(m)=='*'){
                return dp[m][n]= findMatch(s,p,m-1,n,dp)==1 || findMatch(s,p,m,n-1,dp) ==1 ? 1:0;
            }else{
                return 0;
            }
        }
    }

    private boolean isAllStars(String s, int m) {

        for(int i=m;i<s.length();i++){
            if(s.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
}
