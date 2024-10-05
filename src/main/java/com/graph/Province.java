package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Province {

    public static void main(String[] args) {
       int arr[][] = {{1,1,0,0,0},{1,1,1,0,0},{0,1,1,0,0},{0,0,0,1,1},{0,0,0,1,1}};
       int x= findCircleNum(arr);
        System.out.println(x);
       int t= findCircleNumUsingDFS(arr);
       System.out.println(t);
    }

    private static int findCircleNumUsingDFS(int[][] arr) {
        boolean[] visited = new boolean[arr.length];
        int noOfProvinces = 0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                noOfProvinces++;
                dfs(i, arr, visited);
            }
        }
        return noOfProvinces;
    }

    static void dfs(int node, int[][] graph,boolean[] visited){
        visited[node]=true;

        for(int j=0;j<graph[node].length;j++){
            if(graph[node][j]==1 && !visited[j]){
                dfs(j, graph, visited);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        // ToDo: Write Your Code Here.
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        int noOfProvinces = 0;
        for(int i=0;i<isConnected.length;i++) {
            if (!visited[i]) {
                noOfProvinces++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;
                    for (int j = 0; j < isConnected[node].length; j++) {
                        if (!visited[j] && isConnected[node][j] == 1) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return noOfProvinces;
    }
}
