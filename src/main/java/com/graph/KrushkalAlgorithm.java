package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KrushkalAlgorithm {


    public static void main(String[] args) {
        int v = 5;
        int[][] edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        KrushkalAlgorithm krushkalAlgorithm = new KrushkalAlgorithm();
        int minCost = krushkalAlgorithm.mst(edges, v);
        System.out.println(minCost);
    }

    static class Edge implements Comparable<Edge>{
        int u;
        int v;

        int weight;

        Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge target){
            return this.weight-target.weight;
        }
    }
    public int mst(int[][] edges, int v){

        List<Edge> edgeList = new ArrayList<>();

        for (int[] current : edges) {
            Edge edge = new Edge(current[0], current[1], current[2]);
            edgeList.add(edge);
        }
        Collections.sort(edgeList);
        int minCost = 0;
        DisjointSet disjointSet = new DisjointSet(v);
        for(Edge edge : edgeList){
            if(disjointSet.findParent(edge.u)!=disjointSet.findParent(edge.v)){
                disjointSet.unionBySize(edge.u,edge.v);
                minCost = minCost+edge.weight;
            }
        }
        return minCost;
    }
}
