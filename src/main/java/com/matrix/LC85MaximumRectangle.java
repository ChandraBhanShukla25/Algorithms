package com.matrix;

public class LC85MaximumRectangle {

    public static void main(String[] args) {
       String [][] matrix = {{"1","0","1","0","0"},
               {"1","0","1","1","1"},
               {"1","1","1","1","1"},
               {"1","0","0","1","0"}};
       LC85MaximumRectangle maximumRectangle = new LC85MaximumRectangle();
       int  x = maximumRectangle.maximalRectangle(matrix);
        System.out.println(x);
    }

    public int maximalRectangle(String[][] matrix) {
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;
                int width = dp[i][j];
                for(int k = i; k >= 0; k--){
                    width = Math.min(width, dp[k][j]);
                    maxArea = Math.max(maxArea, width * (i - k + 1));
                }
            }
        }
      return maxArea;
    }
}
