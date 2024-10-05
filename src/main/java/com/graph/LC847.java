package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC847 {

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        //int[][] graph1 = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        int dist = shortestPathLength(graph);
        System.out.println( dist);
    }

    static class Edge{
        int vertex;
        int weight;

         Edge(int vertex, int weight){
             this.vertex=vertex;
             this.weight = weight;
         }
    }

    public static int shortestPathLength(int[][] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.weight-o2.weight);
        List<List<Edge>> adj= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
           adj.add(i, new ArrayList<Edge>());
        }
        for(int i=0;i<graph.length;i++){
          for(int j=0;j<graph[i].length;j++){
              adj.get(i).add(new Edge(graph[i][j], 1));
          }
        }

        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            distance[i]= Integer.MAX_VALUE;
        }
        pq.add(new Edge(0,0));
        distance[0]=0;
        StringBuilder sb = new StringBuilder();
        int totalDistance = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            visited[edge.vertex] = true;
            sb.append(edge.vertex + " ");
            for(Edge e: adj.get(edge.vertex)){
                if(distance[edge.vertex]+ e.weight<distance[e.vertex]){
                    sb.append(e.vertex + " ");
                    totalDistance++;
                    distance[e.vertex]=distance[edge.vertex]+ 1;
                    pq.add(e);
                }
            }
        }
        System.out.println(sb.toString());
        return totalDistance;
    }
}
