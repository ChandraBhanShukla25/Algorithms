package com.dynamicprogramming;

import java.util.Arrays;

public class LC72EditDistance {

    public static void main(String[] args) {
       String word1 = "horse";
       String word2 = "ros";
       LC72EditDistance editDistance = new LC72EditDistance();
       int x =editDistance.minDistance(word1,word2);
        System.out.println(x);
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return calculateMin(word1,word2,m-1, n-1,dp);
    }

    public int calculateMin(String word1, String word2, int m , int n, int dp[][]){

        if(m<0){
            return n+1;
        }
        if(n<0){
            return m+1;
        }

        int y = 0;

        if(word1.charAt(m)==word2.charAt(n)){
            return calculateMin(word1,word2,m-1,n-1, dp);
        }else{
           int removed =calculateMin(word1, word2, m-1, n, dp);
           int insert = calculateMin(word1,word2, m,n-1, dp);
           int replace = calculateMin(word1,word2,m-1,n-1, dp);
           y = 1+ Math.min(removed, Math.min(replace,insert));
           return y;
        }
    }
}
