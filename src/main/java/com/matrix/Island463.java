package com.matrix;

public class Island463 {


    public int islandPerimeter(int[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      int perimeter = 0;
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              if(grid[i][j]==1) {
                  perimeter += 4;
                  if (i < row - 1 && grid[i + 1][j] == 1) {
                      perimeter -= 2;
                  }
                  if (j < col - 1 && grid[i][j + 1] == 1) {
                      perimeter -= 2;
                  }
              }
          }
      }
      return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Island463 island463 = new Island463();
        int result = island463.islandPerimeter(grid);
        System.out.println(result);
    }
}
