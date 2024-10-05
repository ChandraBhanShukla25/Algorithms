package com.tree;

import java.util.*;

public class LC834 {

    public static void main(String[] args) {
       int n = 6;
       int [][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
       LC834 lc= new LC834();
       //lc.getSum(edges, n);

    }


    static  class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

}
