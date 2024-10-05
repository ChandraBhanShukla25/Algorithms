package com.backtracking;

import java.util.ArrayList;

public class RatInMazePractice {

    public static void main(String[] args) {
        int N=4;
        int[][] maze=  {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        ArrayList<String> result = findPath(maze,N);
        System.out.println(result);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> moveList = new ArrayList<>();
        solveMaze(m,n, moveList);
        return moveList;
    }

    private static void solveMaze(int[][] m, int n, ArrayList<String> moveList) {
        int[][] visited = new int[n][n];
        if(m[0][0]==1 && m[n-1][n-1]==1){
            solve(m, n, moveList, 0, 0, visited, "");
        }
    }

    public static void solve(int[][] maze, int N, ArrayList<String> ans, int row, int col, int[][] visited, String move){
        if(row==N-1 && col==N-1){
            ans.add(move);
            return;
        }

        if(row-1>=0 && visited[row][col]!=1 && maze[row][col]==1){
            visited[row][col]=1;
            solve(maze, N, ans, row-1, col, visited, move+ "U");
            visited[row][col]=0;
        }

        if(row+1<N && visited[row][col]!=1 && maze[row][col]==1){
            visited[row][col]=1;
            solve(maze, N, ans, row+1, col, visited, move+"D");
            visited[row][col]=0;
        }

        if(col-1>=0 && visited[row][col]!=1 && maze[row][col]==1){
            visited[row][col]=1;
            solve(maze, N, ans, row, col-1, visited, move+"L");
            visited[row][col]=0;
        }

        if(col+1<N && visited[row][col]!=1 && maze[row][col]==1){
            visited[row][col]=1;
            solve(maze, N, ans, row, col+1, visited, move+"R");
            visited[row][col]=0;
        }
    }
}
