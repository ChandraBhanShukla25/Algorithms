package com.dynamicprogramming;

import java.util.Arrays;

public class LC1312MinimumInsertions {

    public static void main(String[] args) {
        String s1 = "leetcode";
        LC1312MinimumInsertions minimumInsertions = new LC1312MinimumInsertions();
       int x=  minimumInsertions.minInsertions(s1);
        System.out.println(x);
    }

    public int minInsertions(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        int longestPalindrome = longestPalindrome(s1,s2, s1.length()-1, s2.length()-1, dp);
        return s1.length()-longestPalindrome;

    }


    public int longestPalindrome(String s1, String s2, int m, int n, int dp[][] ){
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int pick = 0;
        int notPick = 0;
        if(s1.charAt(m)==s2.charAt(n)){
            pick = 1 + longestPalindrome(s1,s2,m-1,n-1, dp);
        }else{
            notPick = Math.max(longestPalindrome(s1,s2,m-1,n, dp), longestPalindrome(s1,s2,m,n-1, dp));
        }

        return dp[m][n] =Integer.max(pick,notPick);
    }

}
