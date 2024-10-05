package com.revision.dp;

import java.util.Arrays;

public class LCS {

    public static void main(String[] args) {
       String text1 = "abc"; String text2 = "mnp";
       int val = longestCommonSubsequence(text1,text2);
        System.out.println(val);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], 0);
        }
        return findLCS(text1,text2,dp, text1.length()-1,text2.length()-1);
    }

    private static int findLCS(String text1, String text2, int[][] dp, int l1, int l2) {

        if(l1<0 || l2<0){
            return 0;
        }
        if(dp[l1][l2]!=0){
            return dp[l1][l2];
        }
        int x = 0;
        int y=0;
        if(text1.charAt(l1)==text2.charAt(l2)){
            x=1+findLCS(text1,text2,dp,l1-1,l2-1);
        }else if(text1.charAt(l1)!=text2.charAt(l2)){
            y = Math.max(findLCS(text1,text2,dp,l1-1,l2), findLCS(text1,text2,dp,l1,l2-1));
        }

        return dp[l1][l2] = Integer.max(x,y);
    }

}
