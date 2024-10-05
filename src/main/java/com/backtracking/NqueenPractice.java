package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NqueenPractice {

    public static void main(String[] args) {
        int N=4;
        char[][] mat = new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                mat[i][j]='.';
            }
        }
        NqueenPractice nqueenPractice = new NqueenPractice();
        List<List<String>> res = new ArrayList<List<String>>();
        nqueenPractice.solveNQueen(mat, 0, res);
        System.out.println(res);
    }

    public void solveNQueen(char[][] mat, int col, List<List<String>> res){
        if(col == mat[0].length){
            res.add(construct(mat));
            return;
        }
        for(int row = 0; row<mat.length; row++){
            if(checkGrid(mat, row, col)){
                mat[row][col]='Q';
                solveNQueen(mat, col+1, res);
                mat[row][col]='.';
            }
        }
    }

    public boolean checkGrid(char[][] mat, int row, int col){

        for(int i=0;i<mat.length;i++){
            if(mat[i][col]=='Q')
                return false;
        }

        for(int j=0;j<mat[0].length;j++){
            if(mat[row][j]=='Q')
                return false;
        }

        int i = row; int j =col;
        while(i>=0 && j>=0){
            if(mat[i][j]=='Q')
                return false;
            i--;
            j--;
        }

         i = row;  j =col;
        while(i<mat.length && j<mat[0].length){
            if(mat[i][j]=='Q')
                return false;
            i++;
            j++;
        }

        i = row; j=col;
        while(i<mat.length && j>=0){
            if(mat[i][j]=='Q')
                return false;
            i++;
            j--;
        }

        i = row; j=col;
        while(i>=0 && j<mat[0].length){
            if(mat[i][j]=='Q')
                return false;
            i--;
            j++;
        }

        return true;
    }

    public List<String> construct(char[][] board){
        List<String> lst = new ArrayList<>();
        for(char[] characterArr: board){
            lst.add(new String(characterArr));
        }
        return lst;
    }

}
