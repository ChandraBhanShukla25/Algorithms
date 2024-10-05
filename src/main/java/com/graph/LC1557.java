package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LC1557 {

    public static void main(String[] args) {
       int n = 6;
       int[][] arr = {{0,1},{0,2},{2,5},{3,4},{4,2}};
      // List<Integer> res = findSmallestSetOfVertices(n, edges);
       //System.out.println(res);
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
       for(List<Integer> edge: edges){
           visited[edge.get(1)]=true;
       }

       List<Integer> result = new ArrayList<>();
       for(int i=0;i<n;i++){
           if(!visited[i]){
               result.add(i);
           }
       }
       return result;
    }


}
