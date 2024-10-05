package com.revision.dp;

public class RodCutting1 {

    public static void main(String[] args) {
      int[] price = {3, 5, 6, 7, 10, 12};
      int n = 6;
      int val = cutRod(price, n);
        System.out.println(val);
    }
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int maxVal = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                maxVal= Integer.max(maxVal, dp[i-j-1]+price[j]);
            }
            dp[i]=maxVal;
        }

        return dp[n];
    }

}
