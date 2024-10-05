package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC51NQueen {

    public static void main(String[] args) {
        int n = 4;
        LC51NQueen nQueen = new LC51NQueen();
        List<List<String>> lst =nQueen.solveNQueens(n);
        System.out.println(lst);

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> lst = new ArrayList<>();
        solveQueen(board,0, lst);
        return lst;
    }

    private void solveQueen(char[][] board, int row, List<List<String>> lst) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String str = new String(board[i]);
                list.add(str);
            }
            lst.add(list);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row,i)) {
                board[row][i] ='Q';
                solveQueen(board, row+1, lst);
                board[row][i] ='.';
            }
        }
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
