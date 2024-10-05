package com.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABFCED";
        WordSearch wordSearch = new WordSearch();
        boolean doesExists = wordSearch.exist(board, word);
        System.out.println(doesExists);
    }

    private boolean exist(char[][] board, String word) {

        if(word.length()>board.length*board[0].length){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                   if(findmatch(board,i,j,board.length-1,board[0].length-1,0, word))
                       return true;
                }
            }
        }
        return false;
    }

    private boolean findmatch(char[][] board, int i, int j, int row, int col, int index, String word) {
        int l = word.length();
        if(index==l){
            return true;
        }
        if(i<0 || j<0 || i>row || j>col)
            return false;
        if(board[i][j]==word.charAt(index)){
            char temp = board[i][j];
            board[i][j]='#';
            boolean res = findmatch(board,i+1,j,row,col,index+1,word) | findmatch(board,i,j+1,row,col,index+1,word)
                    | findmatch(board,i-1,j,row,col,index+1,word) | findmatch(board,i,j-1,row,col, index+1,word);
            board[i][j]=temp;
            return res;
        }else{
            return false;
        }
    }

}
