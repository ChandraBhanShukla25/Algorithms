package com.graph;

import java.util.*;

public class LC1091ShortestPath {

    public static void main(String[] args) {
       int[][] grid = {{0,1},{1,0}};
       LC1091ShortestPath shortestPath = new LC1091ShortestPath();
       int x = shortestPath.shortestPathBinaryMatrix(grid);
        System.out.println(x);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || (grid[grid.length-1][grid[0].length-1]!=0)) return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int dist = grid[row][col];
            if(row==grid.length-1 && col==grid[0].length-1){
                return dist;
            }
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,-1,0,1};
            for(int i=0;i<4;i++){
                int nRow = row+delRow[i]; int nCol = col+delCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]==0){
                    queue.add(new int[]{nRow,nCol});
                    grid[nRow][nCol]=1+dist;
                }
            }
        }
    return -1;
    }

}
