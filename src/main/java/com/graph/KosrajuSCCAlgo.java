package com.graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosrajuSCCAlgo {

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{1,0},{0,2},{2,1},{0,3},{3,4}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i< V;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        KosrajuSCCAlgo kosrajuSCCAlgo = new KosrajuSCCAlgo();
        int answer = kosrajuSCCAlgo.kosrajuSCC(V, adj);
        System.out.println("The no. of Strongly connected components ::" + answer);
    }

    public int kosrajuSCC(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for(int i=0 ;i<V;i++){
            if(visited[i]==0){
                dfs(i, visited, adj, stack);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            visited[i]=0;
            for(Integer it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }

        int scc=0;
        while (!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            if(visited[node]==0){
                scc++;
                dfs3(node,visited,adjT);
            }
        }
        return scc;
    }

    public void dfs3(int node, int[] visited, ArrayList<ArrayList<Integer>> adjT){
        visited[node]=1;
        for(Integer it:adjT.get(node)){
            if(visited[it]==0)
                dfs3(it,visited,adjT);
        }
    }

    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[node] = 1;
        for( Integer it : adj.get(node)){
            if(visited[it]==0){
                dfs(it, visited, adj,stack);
            }
        }
        stack.push(node);
    }



}
