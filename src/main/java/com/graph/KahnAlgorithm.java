package com.graph;

import java.util.*;

public class KahnAlgorithm {

    public static void main(String[] args) {
        int n = 6;
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }

        addEdge(adj,5,0);
        addEdge(adj, 5, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);
        addEdge(adj, 3, 1);
        addEdge(adj, 1, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);

        KahnAlgorithm kahnAlgorithm = new KahnAlgorithm();
        kahnAlgorithm.toplogicalSort(adj,n);

    }

    public static void addEdge(List<Integer>[] adj, int u, int v){
        adj[u].add(v);
    }

    public void toplogicalSort(List<Integer>[] adj, int n){
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(n,0));

        for(int i=0;i<n;i++){
            for(int it:adj[i]){
                indegree.set(it ,indegree.get(it)+1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();

        for(int i=0;i<indegree.size();i++){
            if(indegree.get(i)==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int i:adj[node]){
                indegree.set(i, indegree.get(i)-1);
                if(indegree.get(i)==0){
                    queue.add(i);
                }
            }
        }
        System.out.println("adjhhwdbh");
        for(int i=0;i<n;i++){
            System.out.println(ans.get(i) + "  ");
        }
    }
}
