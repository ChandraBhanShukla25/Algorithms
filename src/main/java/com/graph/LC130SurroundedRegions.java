package com.graph;

import java.util.SortedSet;

public class LC130SurroundedRegions {

    private char[][] board; // Member variable to hold the input board
    private int rows; // Number of rows in the board
    private int cols;
    public static void main(String[] args) {
      char[][]  board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
      LC130SurroundedRegions surroundedRegions = new LC130SurroundedRegions();
      surroundedRegions.solve(board);
        System.out.println(board);
    }

    public void solve(char[][] board) {
      this.board=board;
      this.rows = board.length;
      this.cols = board[0].length;

      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              if((i==0 || i==rows-1 || j==0 || j==cols-1) && board[i][j]=='O'){
                  dfs(i,j);
              }
          }
      }

      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              if(board[i][j]=='.'){
                  board[i][j]='O';
              }
              else if(board[i][j]=='O'){
                  board[i][j]='X';
              }
          }
      }
    }

    public void dfs(int row, int col){
        board[row][col]='.';
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nextRow = row+drow[i];
            int nextCol = col+dcol[i];
            if(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<cols && board[nextRow][nextCol]=='O'){
                dfs(nextRow,nextCol);
            }
        }
    }
}
