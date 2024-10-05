package com.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC542 {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        LC542 lc542 = new LC542();
        int[][] dist =lc542.updateMatrix(matrix);
        System.out.println(dist);
    }

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length; int cols = mat[0].length;
      int[][] distance = new int[rows][cols];

      for(int row[]: distance){
          Arrays.fill(row,-1);
      }

        Deque<int[]> queue =  new ArrayDeque<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                    distance[i][j]=0;
                }
            }
        }
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,-1,0,1};

        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[0]; int col = position[1];
            for(int i=0;i<4;i++){
                int nrow = row+dRow[i];
                int ncol = col+dCol[i];

                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && distance[nrow][ncol]==-1){
                    distance[nrow][ncol]= 1+distance[row][col];
                    queue.offer(new int[] {nrow,ncol});
                }
            }
        }
      return distance;
    }
}
