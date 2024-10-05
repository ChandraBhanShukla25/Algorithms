package com.graph;

import java.util.*;

public class LC802EventualSafeStates {

    public static void main(String[] args) {
       int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
       LC802EventualSafeStates eventualSafeStates = new LC802EventualSafeStates();
       List<Integer> lst = eventualSafeStates.eventualSafeNodes(graph);
        System.out.println(lst);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
       int[] outdegree = new int[n];
       List<Integer> safeNodes  = new ArrayList<>();
       List<List<Integer>> adjList = new ArrayList<>();

       for(int i=0;i<n;i++){
           adjList.add(new ArrayList<>());
        }

       for(int i=0;i<graph.length;i++){
           for(int neighbor : graph[i]){
               adjList.get(neighbor).add(i);
               outdegree[i]++;
           }
       }

       Queue<Integer> queue = new LinkedList<>();

       for(int i=0;i<n;i++){
           if(outdegree[i]==0){
               queue.add(i);
           }
       }

       while(!queue.isEmpty()){
           int node = queue.poll();
           safeNodes.add(node);
           for(int adj: adjList.get(node)){
               outdegree[adj]--;
               if(outdegree[adj]==0){
                   queue.add(adj);
               }
           }
       }
       Collections.sort(safeNodes);
       return safeNodes;
    }
}
