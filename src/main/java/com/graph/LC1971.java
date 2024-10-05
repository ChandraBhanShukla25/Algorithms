package com.graph;

import java.util.*;

public class LC1971 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int start=0;
        int end= 2;
        boolean isValid = validPath(n, edges, start, end);
        System.out.println(isValid);
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        visited[start] = true;
        boolean isValid = false;
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current]= true;
            if(current==end){
                isValid=true;
            }
            for(int next: adjList.get(current)){
                if(!visited[next]) {
                    visited[next] = true;
                    if (next == end) {
                        isValid = true;
                    }
                    queue.add(next);
                }
            }
        }
      return isValid;
    }


}
