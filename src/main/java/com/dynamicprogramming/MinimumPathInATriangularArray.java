package com.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathInATriangularArray {

    public static void main(String[] args) {
      int[][] grid = {{1}, {2,3}, {3,6,7}, {8,9,6,1}};
      MinimumPathInATriangularArray minPath = new MinimumPathInATriangularArray();
     int x=  minPath.minimumPathSum(grid, 4);
        System.out.println(x);
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        return findMinimumPath(triangle, 0,0, n);
    }

    private static int findMinimumPath(int[][] triangle, int i,int j, int n) {
        if(i==n-1){
            return triangle[i][j];
        }

        int goDown = triangle[i][j]+ findMinimumPath(triangle, i+1, j, n);
        int goDiagonal = triangle[i][j]+ findMinimumPath(triangle, i+1, j+1, n);

        return Integer.min(goDown,goDiagonal);

    }
}
