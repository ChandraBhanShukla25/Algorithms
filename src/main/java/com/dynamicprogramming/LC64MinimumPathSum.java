package com.dynamicprogramming;

import java.util.Arrays;

public class LC64MinimumPathSum {

    public static void main(String[] args) {
       int[][] grid =  {{1,3,1},{1,5,1},{4,2,1}};
       LC64MinimumPathSum minimumPathSum = new LC64MinimumPathSum();
       int minpath = minimumPathSum.minPathSum(grid);
       System.out.println(minpath);
    }

//    public int minPathSum(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int[] ints : dp) {
//            Arrays.fill(ints, -1);
//        }
//        return minSumPathUtil(grid.length-1, grid[0].length-1, grid, dp);
//    }

    public int minPathSum(int[][] grid) {
        return minPathSumCalculate(grid.length-1, grid[0].length-1, grid);
    }

//    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
//        // Base cases
//        if (i == 0 && j == 0)
//            return matrix[0][0]; // If we're at the top-left cell, return its value
//        if (i < 0 || j < 0)
//            return (int) Math.pow(10, 9); // If we're out of bounds, return a large value
//        if (dp[i][j] != -1)
//            return dp[i][j]; // If we've already calculated this cell, return the stored result
//
//        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
//        int up = matrix[i][j] + minSumPathUtil(i - 1, j, matrix, dp);
//        int left = matrix[i][j] + minSumPathUtil(i, j - 1, matrix, dp);
//
//        // Store the minimum of the two possible paths
//        return dp[i][j] = Math.min(up, left);
//    }
    public int minPathSumCalculate( int m, int n, int[][] grid){
        if(m<0 || n<0){
            return 10000;
        }
        if(n==0 && m==0){
            return grid[m][n];
        }
        int up = grid[m][n] + minPathSumCalculate( m-1, n, grid);
        int left = grid[m][n] + minPathSumCalculate( m, n-1, grid);

        return Integer.min(up, left);

    }
}
