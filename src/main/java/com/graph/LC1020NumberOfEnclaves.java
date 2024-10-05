package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC1020NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        LC1020NumberOfEnclaves numberOfEnclaves = new LC1020NumberOfEnclaves();
        int count = numberOfEnclaves.numEnclaves(grid);
        System.out.println(count);
    }

    public int numEnclaves(int[][] grid) {

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == rows - 1 || j == cols - 1 || i == 0 || j == 0) && grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1};

        while (!queue.isEmpty()) {
            int[] arr = queue.peek();
            int row = arr[0];
            int col = arr[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                    queue.add(new int[]{nrow, ncol});
                    visited[nrow][ncol] = 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
