package com.graph;

import java.net.Inet4Address;
import java.util.*;

public class BFSTraversal {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        while(!queue.isEmpty()){
            int val = queue.poll();
            result.add(val);
            visited[val]=true;
            ArrayList<Integer> neighbour = adj.get(val);

            for(int x : neighbour){
                if(!visited[x]){
                    queue.add(x);
                }
            }
        }
      return result;
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean[] vis = new boolean[V];
      vis[0]=true;
      ArrayList<Integer> result = new ArrayList<>();
      dfs(0, vis, result, adj);
        System.out.println(result);
        return result;
    }

    private static void dfs(int v, boolean[] vis, List<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        result.add(v);
        vis[v]=true;
        for(int x: adj.get(v)){
            if(!vis[x]){
                dfs(x, vis, result,adj);
            }
        }
    }

    public static void main(String[] args) {
        //adj = {{1,2,3},{},{4},{},{}}
         int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        ArrayList<Integer> l0 = new ArrayList<>();
        l0.add(1);
        l0.add(2);
        l0.add(3);
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(4);
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<Integer> l4 = new ArrayList<>();
        adj.add(l0);
        adj.add(l1);
        adj.add(l2);
        adj.add(l3);
        adj.add(l4);
        List<Integer> ls = bfsOfGraph(V,adj);
        System.out.println(ls);
        List<Integer> res = dfsOfGraph(V,adj);
        System.out.println("DFS::" +res);
    }


}
