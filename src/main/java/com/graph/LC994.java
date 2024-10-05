package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC994 {

    public static void main(String[] args) {
       int[][] grid= {{2,1,1},{1,1,0},{0,1,1}};
       int x = orangesRotting(grid);
        System.out.println(x);
    }


    public static int orangesRotting(int[][] grid) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visisted = new boolean[grid.length];
        queue.add(grid[0][0]);
        int connected = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            visisted[node]=true;
            for(int j=0; j<grid[node].length; j++){
                if(!visisted[grid[node][j]]){
                    visisted[grid[node][j]]=true;
                    queue.add(grid[node][j]);
                }
            }
            connected++;
        }
        return connected;
    }
}
