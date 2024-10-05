package com.matrix;

import java.util.Arrays;

public class MaxPathSumInGrid {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        int maxSum = getMaxPathSum(matrix);
        System.out.println(maxSum);
    }

    public static int getMaxPathSum(int[][] matrix) {
        int maxi = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int ans = maxSum(matrix, 0, j, dp);
            maxi = Math.max(maxi, ans);
        }
       return maxi;
    }

    private static int maxSum(int[][] matrix, int row, int col, int[][] dp) {
        if (col< 0 || col >= matrix.length)
            return (int) Math.pow(-10, 9);
        if(row==matrix.length-1){
            dp[row][col]= matrix[row][col];
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int down = matrix[row][col] + maxSum(matrix, row+1,col, dp);
        int leftDiagonal = matrix[row][col] + maxSum(matrix,row+1,col-1, dp);
        int rightDiagonal = matrix[row][col]+ maxSum(matrix,row+1,col+1, dp);

        return dp[row][col]=Integer.max(down,Integer.max(leftDiagonal,rightDiagonal));
    }
}
