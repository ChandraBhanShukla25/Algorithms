package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC332ConnectedComponents {
    public static void main(String[] args) {
        int V = 5, E = 2;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4)
        );

        LC332ConnectedComponents sol = new LC332ConnectedComponents();
        int ans = sol.findNumberOfComponent(E, V, edges);

        System.out.println("The number of components in the given graph is: " + ans);
    }

    private int findNumberOfComponent(int e, int v, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>(v);

        for(int i=0;i<v;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adjList.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        boolean[] visited = new boolean[v];
        int count = 0;
        for(int i=0;i<v;i++){
          if(!visited[i]){
              dfs(adjList,i, visited);
              count++;
          }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, int node, boolean[] visited){
        visited[node] = true;
        for(int it: adjList.get(node)){
            if(!visited[it]){
                dfs(adjList, it, visited);
            }
        }
    }
}
