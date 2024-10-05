package com.array;

public class LC2373 {

    public static void main(String[] args) {
       int [][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
       LC2373 maxLocal = new LC2373();
        int[][] maxGrid = maxLocal.largestLocal(grid);
        System.out.println(maxGrid);
    }


    public int[][] largestLocal(int[][] grid) {
        int gridSize = grid.length;
        int maxLocal[][] = new int[gridSize-2][gridSize-2];

        for(int i=0;i<=gridSize-3;++i){
            for(int j=0;j<=gridSize-3;++j){
                int maxVal = Integer.MIN_VALUE;
                for(int x=i;x<=i+2;++x){
                    for(int y=j;y<=j+2;++j){
                        maxVal = Integer.max(maxVal, grid[x][y]);
                    }
                }
                maxLocal[i][j]=maxVal;
            }
        }
        return maxLocal;
    }



}
