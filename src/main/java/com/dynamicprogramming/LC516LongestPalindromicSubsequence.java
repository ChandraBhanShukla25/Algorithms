package com.dynamicprogramming;

import java.util.Arrays;

public class LC516LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s= "bbbab";
        LC516LongestPalindromicSubsequence longest = new LC516LongestPalindromicSubsequence();
        int x = longest.longestPalindromeSubseq(s);
        System.out.println(x);
    }

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return getLongestPalindrome(s,s2,s.length()-1,s.length()-1, dp);
    }

    public int getLongestPalindrome(String s1, String s2, int m, int n , int[][] dp){
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int x = 0;
        int y = 0;
        if(s1.charAt(m)==s2.charAt(n)){
            x=  1 + getLongestPalindrome(s1,s2,m-1,n-1, dp);
        }else{
            y = Integer.max(getLongestPalindrome(s1,s2,m,n-1, dp),getLongestPalindrome(s1,s2,m-1,n, dp));
        }

        return dp[m][n]= Integer.max(x,y);
    }
}
