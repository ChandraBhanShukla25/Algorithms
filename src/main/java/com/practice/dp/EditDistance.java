package com.practice.dp;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";
        System.out.println(editDistance(s1,s2));
    }

    public static int editDistance(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return countUtil(s,t,s.length()-1,t.length()-1, dp);
    }

    private static int countUtil(String s, String t, int i, int j, int[][] dp) {
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int editCount = 0;
        if(s.charAt(i)==t.charAt(j)){
            editCount=countUtil(s,t,i-1,j-1,dp);
        }else{
            editCount = 1+ Integer.min(countUtil(s,t,i-1,j,dp), Integer.min(countUtil(s,t,i-1,j-1,dp), countUtil(s,t,i,j-1,dp)));

        }
        return dp[i][j]=editCount;
    }
}
