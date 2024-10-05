package com.backtracking;

import java.util.Arrays;

public class SudokuSolver37 {

    public static void main(String[] args) {
        SudokuSolver37 sudokuSolver37 = new SudokuSolver37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        sudokuSolver37.solveSudoku(board);
        for(int i=0;i<board.length;i++){
            Arrays.stream(board).forEach(System.out::println);
        }
    }



     public boolean solveSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solveSudoku(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
     }

    private boolean isValid(char[][] board, int row, int col, char num) {
       for(int i=0;i<board.length;i++){
           if(board[row][i]==num)
               return false;

           if(board[i][col]==num)
               return false;
       }

       int srow= row/3 *3;
       int scol = col/3 * 3;

       for(int i=srow;i<srow+3;i++){
           for(int j=scol;j<scol+3;j++){
               if(board[i][j]==num)
                   return false;
           }
       }
       return true;
    }
}
