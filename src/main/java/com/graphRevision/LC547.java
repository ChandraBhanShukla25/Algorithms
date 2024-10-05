package com.graphRevision;

import java.util.ArrayList;
import java.util.List;

public class LC547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        LC547 lc547 = new LC547();
        int x = lc547.findCircleNum(isConnected);
        System.out.println(x);
    }

    public int findCircleNum(int[][] isConnected) {
       List<List<Integer>> adjList = new ArrayList<>(isConnected.length);
       for(int i=0;i<isConnected.length;i++){
           adjList.add(new ArrayList<Integer>());
       }

       for(int i=0;i<isConnected.length;i++){
           for(int j=0;j<isConnected[i].length;j++){
               if(isConnected[i][j]==1 &&  i!=j){
                   adjList.get(i).add(j);
                   adjList.get(j).add(i);
               }
           }
       }
        System.out.println(adjList);

       int count = 0;
        boolean[] visited = new boolean[isConnected.length];
       for(int i=0;i<isConnected.length;i++){
           if(!visited[i]){
               count++;
               dfs(i, visited, adjList);
           }
       }
       return count;

    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;

        for(int i: adjList.get(node)){
            if(!visited[node]){
                dfs(i, visited, adjList);
            }
        }
    }


}
