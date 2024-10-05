package com.graph;

import java.util.*;

public class ShortestPathWithAlternatingColors {

    public static void main(String[] args) {
       int n = 3;
       int[][] redEdges = {{0,1},{1,2}};
       int[][] blueEdges = {};
       int[] result = shortestAlternatingPaths(n, redEdges, blueEdges);
       Arrays.stream(result).forEach(System.out::println);

    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
      List<Integer>[] redGraph = new ArrayList[n];
      List<Integer>[] blueGraph = new ArrayList[n];

      for(int i=0;i<n;i++){
          redGraph[i]= new ArrayList<>();
          blueGraph[i] = new ArrayList<>();
      }

      for(int[] edge: redEdges){
          redGraph[edge[0]].add(edge[1]);
      }

        for(int[] edge: blueEdges){
            blueGraph[edge[0]].add(edge[1]);
        }

        int[] result = new int[n];
        Arrays.fill(result,-1);
        result[0]=0;

        boolean[][] visited = new boolean[n][2]; // 0 -red, 1-blue
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0});
        queue.add(new int[] {0,1,0});
        visited[0][0]=visited[0][1]=true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0]; int color = current[1]; int dist = current[2];
            int nextColor = 1-color;
            List<Integer>[] nextGraph = color==0? blueGraph: redGraph;
            for(int neighbor: nextGraph[node]){
                if(!visited[neighbor][nextColor]){
                    visited[neighbor][nextColor]=true;
                    queue.offer(new int[]{neighbor, nextColor, dist+1});
                    if (result[neighbor]==-1) {
                        result[neighbor]=dist+1;
                    }
                }
            }
        }
   return result;
    }
}
