package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC847BellManFord {

    public static void main(String[] args) {
       // int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph1 = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        int dist = shortestPathLength(graph1);
        System.out.println(dist);
    }

    static class Edge {
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight) {
            this.src= src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int shortestPathLength(int[][] graph) {

        int src = 0;
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        List<List<Edge>> adj= new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(i, new ArrayList<Edge>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(new Edge(i, graph[i][j], 1));
            }
        }

        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int u = adj.get(i).get(j).src;
                int v = adj.get(i).get(j).dest;
                int weight = adj.get(i).get(j).weight;

                if(distance[u] != Integer.MAX_VALUE && distance[u]+weight <distance[v]){
                    distance[v]=distance[u]+weight;
                }
            }
        }
        for(int i=0;i<distance.length;i++){
          //  System.out.println(distance[i]);
        }
        return distance[graph.length-1];
    }

}
