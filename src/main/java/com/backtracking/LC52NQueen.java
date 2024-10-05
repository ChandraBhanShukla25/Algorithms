package com.backtracking;

import java.util.Arrays;

public class LC52NQueen {


    public static void main(String[] args) {
        LC52NQueen lc52NQueen = new LC52NQueen();
        int n = 1;
        lc52NQueen.totalNQueens(n);
    }


    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],'.');
        }
        int x = getTotalNQueen(n, board, 0, 0);
        System.out.println(x);
        return x;
    }

    private int getTotalNQueen(int n,char[][] board, int row, int col) {
        int x = 0;
        if(row==board.length){
            return 1;
        }

        for(int i=0;i<n;i++){
            if(isSafe(board,row,i)){
                board[row][i]='Q';
                x += getTotalNQueen(n, board, row+1,i);
                board[row][i]='.';
            }
        }
        return x;
    }

    private boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col]=='Q') {
                return false;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (board[row][j]=='Q') {
                return false;
            }
        }
        int x = row;
        int y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y]=='Q') {
                return false;
            }
            x = x - 1;
            y = y - 1;
        }

        x = row;
        y = col;

        while(x>=0 && y<board.length){
            if(board[x][y]=='Q'){
                return false;
            }
            x=x-1;
            y=y+1;
        }

        x = row;
        y = col;
        while(x<board.length && y<board.length){
            if(board[x][y]=='Q'){
                return false;
            }
            x=x+1;
            y=y+1;
        }

        x = row;
        y = col;
        while(x<board.length && y>=0){
            if(board[x][y]=='Q'){
                return false;
            }
            x=x+1;
            y=y-1;
        }

        return true;
    }
}
