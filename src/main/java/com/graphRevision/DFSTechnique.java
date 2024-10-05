package com.graphRevision;

import java.util.ArrayList;

public class DFSTechnique {

    public static void main(String args[]) {

        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        DFSTechnique sl = new DFSTechnique();
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    private ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        int i=0;
        ArrayList<Integer> result = new ArrayList<>();
        dfs(i, adj, visited, result);
        return result;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for(int i:adj.get(node)){
            if(!visited[i]){
                dfs(i, adj, visited, result);
            }
        }
    }


}
