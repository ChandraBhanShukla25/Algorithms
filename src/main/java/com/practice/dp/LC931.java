package com.practice.dp;

import java.net.Inet4Address;
import java.util.Arrays;

public class LC931 {

    public static void main(String[] args) {
       int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
       int min = minFallingPathSum(matrix);
        System.out.println(min);
    }

    public static int minFallingPathSum(int[][] matrix) {
      int[][] dp = new int[matrix.length][matrix.length];
      int m = matrix.length;
      int n = matrix[0].length;

      for(int i=0;i<dp.length;i++){
          Arrays.fill(dp[i],-1);
      }
      int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            int ans = getMaxUtil( matrix, dp, 0, j);
            maxi = Math.max(ans, maxi);
        }
      return maxi;
    }

    private static int getMaxUtil(int[][] matrix, int[][] dp, int row, int col) {

        if (col<0 || col >= matrix.length)
            return (int) Math.pow(-10, 9);
        if (row == matrix.length-1)
            return matrix[0][col];

        if (dp[row][col] != -1)
            return dp[row][col];



         return    dp[row][col] = Integer.max(matrix[row][col]+getMaxUtil(matrix,dp,row+1,col),
                    Integer.max(matrix[row][col] + getMaxUtil(matrix,dp,row+1,col+1), matrix[row][col]+ getMaxUtil(matrix,dp, row+1,col-1)));

    }
}
