package com.array;

import java.util.LinkedList;
import java.util.Queue;

public class LC542Matrix {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result  = updateMatrix(mat);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;

       Queue<int[]> queue = new LinkedList<>();
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(mat[i][j]==0){
                   queue.add(new int[]{i,j});
               }else{
                   mat[i][j]=Integer.MAX_VALUE;
               }
           }
       }

       int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

       while(!queue.isEmpty()){
           int[] cell = queue.poll();
           for(int[] dir: directions){
               int r= cell[0]+dir[0];
               int c = cell[1]+dir[1];

               if(r<0 || c<0 || r>=m || c>=n || mat[r][c]<=mat[cell[0]][cell[1]]+1) continue;
               queue.add(new int[]{r,c});
               mat[r][c]= mat[cell[0]][cell[1]]+1;
           }
       }
       return mat;
    }
}
