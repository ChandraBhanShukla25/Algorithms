package com.tree;

import java.net.Inet4Address;
import java.util.*;

public class LC310MinHeightTrees {

    public static void main(String[] args) {
      int arr[][] = {{1,0},{1,2},{1,3}};
      int n =4;

      int n1 = 6;
      int[][] edges1 = {{3,0},{3,1},{3,2},{3,4},{5,4}};
      LC310MinHeightTrees minHeightTrees = new LC310MinHeightTrees();
      List<Integer> result = minHeightTrees.findMinHeightTrees(n, arr);
      //[[0,1],[0,2],[0,3],[3,4],[4,5]]
        List<Integer> result1 = minHeightTrees.findMinHeightTrees(n1, edges1);
        System.out.println(result);
        System.out.println(result1);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if(n==1){
            return List.of(0);
        }

        int[] degree = new int[n];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adjList.get(x).add(y);
            adjList.get(y).add(x);
            degree[x]++;
            degree[y]++;
        }
        for(int i=0;i<n;i++){
            if(degree[i]==1){
               queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            ans.clear();
            int size = queue.size();
            for(int i=0;i<size;i++){
               int current = queue.poll();
               ans.add(current);
               for(int val: adjList.get(current)){
                   degree[val]--;
                   if(degree[val]==1)
                       queue.add(val);
               }
            }
        }
        return ans;
    }
}
