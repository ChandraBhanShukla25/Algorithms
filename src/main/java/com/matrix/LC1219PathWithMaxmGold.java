package com.matrix;

public class LC1219PathWithMaxmGold {

    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        LC1219PathWithMaxmGold pathWithMaxmGold = new LC1219PathWithMaxmGold();
        int maxGold = pathWithMaxmGold.getMaximumGold(grid);
        System.out.println(maxGold);
    }

    public int getMaximumGold(int[][] grid) {
       int maxGold = Integer.MIN_VALUE;

       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
              maxGold = Integer.max(maxGold, maximum(grid,i,j));
           }
       }
       return maxGold;
    }

    public int maximum(int[][] grid, int row, int col){
       if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
           return 0;
       }
       if(grid[row][col]==0)
           return 0;

       int gold = grid[row][col];
       grid[row][col]=0;
       int max = Integer.max(Integer.max(maximum(grid,row+1,col),maximum(grid,row,col+1)),
               Integer.max(maximum(grid,row-1,col), maximum(grid,row,col-1)));
       grid[row][col]=gold;
       return gold+max;
    }


}
