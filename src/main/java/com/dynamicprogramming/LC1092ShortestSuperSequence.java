package com.dynamicprogramming;

public class LC1092ShortestSuperSequence {

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        LC1092ShortestSuperSequence shortestSuperSequence = new LC1092ShortestSuperSequence();
        String superSequence = shortestSuperSequence.shortestCommonSupersequence(str1,str2);
        System.out.println(superSequence);
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[m][n];

        int i = m;
        int j = n;
        int index = len - 1;
        String str = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str += str1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += str1.charAt(i - 1);
                i--;
            } else {
                str += str2.charAt(j - 1);
                j--;
            }
        }

        while (i > 0) {
            str += str1.charAt(i-1);
            i--;
        }
        while (j > 0) {
            str += str2.charAt(j-1);
            j--;
        }
      String res = new StringBuilder(str).reverse().toString();;

      return res;
    }

}
