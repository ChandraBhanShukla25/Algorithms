package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
       int[][] grid = {{1,2}};
       RottenOranges rottenOranges = new RottenOranges();
       int x =  rottenOranges.orangesRotting(grid);
       System.out.println(x);
    }

    static  class Pair{
        int row;
        int col ;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int maxTime = 0;
        int cntFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    visited[i][j]=2;
                    queue.add( new Pair(i, j, 0));
                }else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int[] dRow = {0,-1,0,1};
        int[] dcol = {-1,0,1,0};
        int cnt=0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int time = pair.time;
            int row = pair.row;
            int col = pair.col;
            maxTime = Integer.max(maxTime,time);
            for(int i=0;i<4;i++){
                int nrow = row+dRow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]!=2){
                    queue.offer(new Pair(nrow,ncol,time+1));
                    visited[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
      if(cnt!=cntFresh){
          return  -1;
      }
       return maxTime;
    }
}
