package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExistinGraphLc1971 {


    public static void main(String[] args) {
       int  n = 50;
       int [][] edges = {{31,5},{10,46},{19,31},{5,1},{31,28},{28,29},{8,26},{13,23},{16,34},{30,1},{16,18},{33,46},{27,35},{2,25},{49,33},{44,19},{22,26},{30,13},{27,12},{8,16},{42,13},{18,3},{21,20},{2,17},{5,48},{41,37},{39,37},{2,11},{20,26},{19,43},{45,7},{0,21},{44,23},{2,39},{27,36},{41,48},{17,42},{40,32},{2,28},{35,38},{3,9},{41,30},{5,11},{24,22},{39,5},{40,31},{18,35},{23,39},{20,24},{45,12}};
       int source = 29;
       int destination = 46;
       PathExistinGraphLc1971 pathExists = new PathExistinGraphLc1971();
       boolean exists = pathExists.validPath(n,edges,source,destination);
       System.out.println(exists);
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int [] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(adjList.get(source));
        while(!queue.isEmpty()){
            List<Integer> lst = queue.poll();
            visited[source]=true;
            if(lst.contains(destination))
                return true;
            for(int i: lst){
                visited[i]=true;
               if(!visited[i]){
                   queue.add(adjList.get(i));
               }
            }

        }
        return false;
    }
}
