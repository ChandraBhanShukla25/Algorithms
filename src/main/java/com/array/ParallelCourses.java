package com.array;

import java.util.*;

public class ParallelCourses {

    static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight){
            this.src=src;
            this.dest = dest;
            this.weight=weight;
        }
    }
//    public int minimumTime(int n, int[][] relations, int[] time) {
//        Set<Integer> completed = new HashSet<>();
//        Set<Integer> uncompleted = new HashSet<>(0);
//        List<List<Edge>> edgeList = new ArrayList<>();
//        for(int i=0;i<=n;i++){
//            edgeList.add(i,new ArrayList<>());
//        }
//        for(int[] arr: relations){
//          Edge edge = new Edge(arr[0],arr[1], time[arr[0]-1]);
//          edgeList.get(arr[0]).add(edge);
//        }
//        LinkedList<Edge> edge = new
//        while(!completed.containsAll(uncompleted)){
//
//        }
//    }

    public static void main(String[] args) {
        int n = 5;
        int [][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};
        int[] time = {1,2,3,4,5};


    }
}
