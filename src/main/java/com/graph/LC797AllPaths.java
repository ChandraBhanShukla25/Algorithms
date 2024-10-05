package com.graph;

import java.util.*;

public class LC797AllPaths {

    public static void main(String[] args) {
       int[][] graph =  {{1,2},{3},{3},{}};
       LC797AllPaths allPaths = new LC797AllPaths();
       allPaths.allPathsSourceTarget(graph);
    }

    static class Edge{
        int vertex;

        Edge(int vertex){
            this.vertex=vertex;
        }

        public String toString(){
            return this.vertex +"";
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Edge>> edgeList = new ArrayList<>(graph.length);
        boolean[] visited = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            List<Edge> edgelst = new ArrayList<>();
            for(int j=0;j<graph[i].length; j++){
                edgelst.add(new Edge(graph[i][j]));
            }
            edgeList.add(edgelst);
        }

        System.out.println(edgeList);
        List<List<Integer>> lists=new ArrayList<>();
        Stack<Edge> stack = new Stack<>();
        stack.push(new Edge(0));
        List<Integer> path = new ArrayList<>();
        while(!stack.isEmpty()){
            Edge current = stack.pop();
            path.add(current.vertex);
            visited[current.vertex]=true;
            if(current.vertex==graph.length-1) {
                lists.add(new ArrayList<>(path));
            }
            System.out.println(path);
            List<Edge> edges = edgeList.get(current.vertex);
            for(Edge e: edges) {
                stack.push(e);
            }
        }
        System.out.println(path);
        return null;
    }
}
