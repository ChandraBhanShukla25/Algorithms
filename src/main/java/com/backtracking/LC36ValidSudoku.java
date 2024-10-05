package com.backtracking;

public class LC36ValidSudoku {

    public static void main(String[] args) {
      char[][]  board = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
      LC36ValidSudoku validSudoku = new LC36ValidSudoku();
      boolean flag =validSudoku.isValidSudoku(board);
        System.out.println(flag);
    }


    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1' ;ch<='9';ch++) {
                        if (validate(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (isValidSudoku(board))
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

    private boolean validate(char[][] board, int row, int col, char ch){

        for(int i=0;i<board.length;i++){
            if(board[i][col]==ch){
                return false;
            }
            if(board[row][i]==ch){
                return false;
            }
        }

        int srow = (row/3)*3; int scol = (col/3)*3;

        for(int i=srow;i<srow+3;i++){
            for(int j=scol;j<scol+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}
