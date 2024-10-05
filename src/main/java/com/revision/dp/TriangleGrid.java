package com.revision.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TriangleGrid {

    public static void main(String[] args) {
     int[][] triangle= {{-10}};
     int val = minimumTotal(triangle);
        System.out.println(val);

    }

    public static int minimumTotal(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        int val = minimumCost(triangle, 0, 0, dp);

        return val;

    }

    private static int minimumCost(int[][] triangle, int i, int j, int[][] dp) {
        if(i>=triangle.length){
            return 100000;
        }
        if(i==triangle.length-1){
            return triangle[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = triangle[i][j]+ minimumCost(triangle, i+1, j, dp);
        int diagonal = triangle[i][j]+  minimumCost(triangle, i+1,j+1,dp);
        return  dp[i][j]= Math.min(down,diagonal);

    }
}
