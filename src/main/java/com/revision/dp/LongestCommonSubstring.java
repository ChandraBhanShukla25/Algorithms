package com.revision.dp;

import javax.lang.model.type.IntersectionType;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";
        int lcs = lcs(s1,s2);
        System.out.println(lcs);
    }

    public static int lcs(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        return findLCS(dp, str1, str2, str1.length()-1,str2.length()-1);
    }

    private static int findLCS(int[][] dp, String str1, String str2, int l1, int l2) {
        if(l1==0 || l2==0){
            return 0;
        }
        int max = 0;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max = Integer.max(dp[i][j], max);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}
