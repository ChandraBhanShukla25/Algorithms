package com.practice.dp;

import java.util.Arrays;

public class UniquePaths63 {

    public static void main(String[] args) {
        int[][]  obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int x = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(x);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int x= getUniquePaths(obstacleGrid,dp, m-1, n-1);
        System.out.println(x);
        return x;
    }

    private static int getUniquePaths(int[][] obstacleGrid, int[][] dp, int m, int n) {

        if(m>=0 && n>=0 && obstacleGrid[m][n]==-1)
            return 0;
        if(m==0 && n==0 ){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up =0;
        int down = 0;
        if(m-1>=0 && obstacleGrid[m-1][n]!=1){
            up = getUniquePaths(obstacleGrid, dp, m - 1, n);
        }
        if(n-1>=0 && obstacleGrid[m][n-1]!=1) {
            down = getUniquePaths(obstacleGrid, dp, m, n - 1);
        }
        return dp[m][n]=up+down;
    }
}
