package com.dynamicprogramming;

import java.util.Arrays;

public class LC132PalindromicPartitioning {

    public static void main(String[] args) {
        String s = "aab";
        LC132PalindromicPartitioning palindromicPartitioning = new LC132PalindromicPartitioning();
        int x = palindromicPartitioning.minCut(s);
        System.out.println(x);
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minimumCut(0, n, s, dp) - 1;
    }

    public int minimumCut(int index, int n, String s, int[] dp){
        if(index==n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i=index;i<n;i++){
            if(isPalindrome(s, i, index)){
               int cost = 1+ minimumCut(i+1,n,s,dp);
               minCost = Integer.min(cost,minCost);
            }
        }
        return dp[index]=minCost;
    }

    public boolean isPalindrome(String s, int j, int i){
        int x = i;
        int y=j;
        while(y>x){
            if(s.charAt(y)!=s.charAt(x))
                return false;
            y--;
            x++;
        }
        return true;
    }
}
