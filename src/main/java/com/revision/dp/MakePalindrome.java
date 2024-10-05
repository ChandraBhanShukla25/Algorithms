package com.revision.dp;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;

public class MakePalindrome {

    public static void main(String[] args) {
        String s1 = "abcdefg";
        int lcs = minInsertion(s1);
//        System.out.println(lcs);

        String str1 = "abcd";
        String str2 = "anc";
//        int x = canYouMake(str1,str2);
//        System.out.println(x);
        int y = canYouMake1(str1,str2);
        System.out.println(y);
    }

    public static int minInsertion(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Integer.min(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return s1.length()-dp[s1.length()][s2.length()];
    }

    public static int canYouMake(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        if(s1.isEmpty()){
            for(int i=0;i<=s2.length();i++){
                dp[0][i]=i;
            }
        }
        if(s2.isEmpty()){
            for(int i=0;i<=s1.length();i++){
                dp[i][0]=i;
            }
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)!=s2.charAt(j-1)){
                    dp[i][j] = 1+ Integer.max(1+dp[i-1][j-1], Integer.max(dp[i-1][j], dp[i][j-1]));
                }else{
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static int canYouMake1(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return canyou(s1,s2,dp, s1.length()-1,s2.length()-1);
    }

    private static int canyou(String s1, String s2, int[][] dp, int l1, int l2) {
        if(l1<0){
            return l2+1;
        }
        if(l2<0){
            return l1+1;
        }
        if(dp[l1][l2]!=-1){
            return dp[l1][l2];
        }

        if(s1.charAt(l1)==s2.charAt(l2)){
            return dp[l1][l2] = canyou(s1,s2,dp,l1-1,l2-1);
        }else{
            return dp[l1][l2] = 1+Math.min( canyou(s1,s2,dp,l1-1,l2-1), Math.min(canyou(s1,s2,dp,l1-1,l2), canyou(s1,s2,dp,l1,l2-1)));
        }

    }
}
