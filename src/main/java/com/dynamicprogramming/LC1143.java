package com.dynamicprogramming;

import java.util.Arrays;

public class LC1143 {

    public static void main(String[] args) {
       String text1 = "abcde";
       String text2 = "ace";
       LC1143 longestCommonSubsequence = new LC1143();
       int length = longestCommonSubsequence.longestCommonSubsequence(text1,text2);
        System.out.println(length);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
         return  getLengthOfSubsequence(text1, text2, text1.length()-1, text2.length()-1, dp);
    }


    public int getLengthOfSubsequence(String s1, String s2, int m, int n, int dp[][]){

        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        int x = 0;
        int y=0;
        if(s1.charAt(m)==s2.charAt(n)){
            x = 1+ getLengthOfSubsequence(s1,s2,m-1,n-1, dp);
        }else{
            y = Integer.max(getLengthOfSubsequence(s1,s2,m,n-1, dp),getLengthOfSubsequence(s1,s2,m-1,n, dp));
        }

        return  dp[m][n]= Integer.max(x,y);

    }
}
