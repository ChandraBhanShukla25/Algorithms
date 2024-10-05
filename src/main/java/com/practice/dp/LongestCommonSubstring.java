package com.practice.dp;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "bcdeerr";
        String str2 = "pddeera";
        int x = longestCommonSubstr(str1,str2);
        System.out.println(x);
    }

    public static int longestCommonSubstr(String str1, String str2) {
      int m = str1.length();
      int n = str2.length();
      int[][] dp = new int[m][n];
      for(int[] row: dp){
          Arrays.fill(row,-1);
      }
      return longetSubstring(str1, str2);
    }

    private static int longetSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    int val = 1 + dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
