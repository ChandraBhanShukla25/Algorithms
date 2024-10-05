package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {
        int N = 4;
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m,N));
    }

    public static List<String> findPath(int[][] board, int n) {

       if(board[0][0]==0){
           return new ArrayList<>();
       }
       List<String> lst = new ArrayList<>();
       //findPathInList(board,n,0,0, lst);
       return lst;
    }

}
