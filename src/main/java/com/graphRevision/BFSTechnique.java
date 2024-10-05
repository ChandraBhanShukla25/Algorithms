package com.graphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTechnique {

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

        BFSTechnique sl = new BFSTechnique();
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    private ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[V];
        visited[0]=true;
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
           int node = queue.poll();
            result.add(node);
           for(int u: adj.get(node)){
               if(!visited[u]){
                   visited[u]=true;
                   queue.add(u);
               }
           }
        }
        return result;
    }
}
