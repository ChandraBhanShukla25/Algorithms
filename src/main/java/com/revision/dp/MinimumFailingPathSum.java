package com.revision.dp;

import java.util.Arrays;

public class MinimumFailingPathSum {

    public static void main(String[] args) {
      int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
      int val = minFallingPathSum(matrix);
      System.out.println(val);
    }

    public  static int minFallingPathSum(int[][] matrix) {
      int[][] dp = new int[matrix.length][matrix.length];
      for(int i=0;i<matrix.length;i++) {
          Arrays.fill(dp[i], -1);
      }
     return minPathSum(matrix,dp, 0, 0);
    }

    private static int minPathSum(int[][] matrix, int[][] dp, int i, int j) {
        if(j<0 || j>=matrix.length){
            return (int) Math.pow(-10, 9);
        }
        if(i==matrix.length-1){
            return matrix[0][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int left = matrix[i][j]+minPathSum(matrix,dp,i+1,j-1);
        int right = matrix[i][j]+minPathSum(matrix,dp,i+1,j);
        int down = matrix[i][j]+minPathSum(matrix,dp,i+1,j+1);
        return dp[i][j]= Math.min(left, Math.min(right,down));
    }
}
