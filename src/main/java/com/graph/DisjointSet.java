package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n){
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i=0;i<=n;i++){
            rank.add(i,0);
            parent.add(i,i);
            size.add(i,1);
        }
    }

    public int findParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int parentNode = findParent(parent.get(node));
        parent.set(node, parentNode);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ul_u = findParent(u);
        int ul_v = findParent(v);
        if(rank.get(ul_u)<rank.get(ul_v)){
            parent.set(ul_u, ul_v);
        } else if(rank.get(ul_u)>rank.get(ul_v)){
            parent.set(ul_v,ul_u);
        }else{
            parent.set(ul_u,ul_v);
            int rank_v = rank.get(ul_v);
            rank.set(ul_v, rank_v+1);
        }
    }

    public void unionBySize(int u, int v){
        if(findParent(u)==findParent(v)){
            return;
        }
        if(size.get(u)<size.get(v)){
            parent.set(u,v);
        } else if(size.get(v)<size.get(u)){
            parent.set(v,u);
        }else{
            parent.set(v,u);
            int usize = size.get(u);
            int vsize = size.get(v);
            size.set(u,usize+vsize);
        }
    }


}
