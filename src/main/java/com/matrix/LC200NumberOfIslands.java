package com.matrix;

public class LC200NumberOfIslands {

    public int numIslands(String[][] grid) {
      int noOfIslands = 0;
      int m = grid.length;
      int n = grid[0].length;

      if(m==0 && n==0){
          return 0;
      }

      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(grid[i][j].equals("1")){
                  noOfIslands++;
                  dfs(grid,i,j);
              }
          }
      }

      return noOfIslands;
    }

    public void dfs(String[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || !grid[i][j].equals("1"))
            return;
        grid[i][j]="X";
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }


    public static void main(String[] args) {
      LC200NumberOfIslands numberOfIslands = new LC200NumberOfIslands();
        String [][] grid = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };

        String[][] grid1 = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        String[][] grid2 = {
                {"1","1","1"},
                {"0","1","0"},
                {"1","1","1"}};
        int numberofislands = numberOfIslands.numIslands(grid);
        int numberofislands1 = numberOfIslands.numIslands(grid1);
        int numberofislands2 = numberOfIslands.numIslands(grid2);
        System.out.println(numberofislands);
        System.out.println(numberofislands1);
        System.out.println(numberofislands2);
    }
}
