package com.practice.dp;

import java.util.Arrays;

public class PalindromicPartitioning {

    public static boolean isPalindrome( int i,int j, String s){
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

    static int f(int i, int n, String str, int[] dp) {
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,str)){
                int cost = 1+ f(i+1,n, str, dp);
                minCost= Integer.min(minCost,cost);
            }
        }
        return dp[i]=minCost;
    }

    static int palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, str, dp) -1;
    }

    public static void main(String[] args) {
        String str = "aab";
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);
    }
}
