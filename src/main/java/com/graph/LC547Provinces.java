package com.graph;

import java.util.ArrayList;
import java.util.List;

public class LC547Provinces {

    public static void main(String[] args) {
      int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
      int x = new LC547Provinces().findCircleNum(isConnected);
      System.out.println(x);
    }

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        int components = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                components++;
                dfsTraversal(i, isConnected, vis);
            }
        }
        return components;
    }



    private void dfsTraversal(int v, int[][] isConnected, boolean[] vis) {
        vis[v]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[v][i]==1 && !vis[i]){
                dfsTraversal(i, isConnected,vis);
            }
        }
    }
}
