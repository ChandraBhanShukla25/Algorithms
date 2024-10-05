package com.dynamicprogramming;

import java.util.Arrays;

public class LC583 {

    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "b";
        LC583 lc = new LC583();
        int x = lc.minOpt(word1,word2);
        System.out.println(x);
        
    }

    public int minOpt ( String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return s1.length()+s2.length()- 2*minOperarionsNeeded(s1,s2,s1.length()-1,s2.length()-1, dp);
    }


    public int minOperarionsNeeded(String s1,String s2,int m,int n, int dp[][]){

        if(m<0 || n<0){
           return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int opt = 0;
        int notOpt = 0;
        if(s1.charAt(m)==s2.charAt(n)) {
            opt = 1 + minOperarionsNeeded(s1, s2, m - 1, n-1, dp);
        } else{
            notOpt = Integer.max(minOperarionsNeeded(s1, s2, m - 1, n, dp), minOperarionsNeeded(s1, s2, m, n - 1, dp));
        }

        return dp[m][n] = Math.max(opt,notOpt);
    }
}
