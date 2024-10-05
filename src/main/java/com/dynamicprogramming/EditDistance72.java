package com.dynamicprogramming;

public class EditDistance72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
               if(i==0){
                   dp[i][j]=j;
               }
               else if(j==0){
                   dp[i][j]=i;
               }
               else if(word1.charAt(i-1)==word2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1];
               }else{
                   dp[i][j]= 1+ Integer.min(dp[i][j-1], Integer.min(dp[i-1][j], dp[i-1][j-1]));
               }
            }

        }
        return dp[m][n];

    }

    public static void main(String[] args) {
       String word1 = "horse";
       String word2 = "ros";

       EditDistance72 distance72 = new EditDistance72();
       int dist = distance72.minDistance(word1,word2);
        System.out.println(dist);
    }
}
