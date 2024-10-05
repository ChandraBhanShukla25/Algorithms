package com.disjointset;

import java.util.ArrayList;

public class DisjointSet {

    public ArrayList<Integer> rank;
    public ArrayList<Integer> parent;

    public DisjointSet(int n){
        this.rank = new ArrayList<>();
        this.parent = new ArrayList<>();
        for(int i=0;i<=n;i++){
            rank.add(i,0);
            parent.add(i, i);
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

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        // {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}}
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        //if 3 and 7 are in same set
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }
        ds.unionByRank(3,7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }
    }
}
