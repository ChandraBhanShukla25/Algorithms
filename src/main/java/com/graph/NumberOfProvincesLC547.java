package com.graph;

import com.disjointset.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvincesLC547 {

    public static void main(String[] args) {
       int [][] cities =  {{1,1,0},{1,1,0},{0,0,1}};
       int [][] cities1 = {{1,0,0},{0,1,0},{0,0,1}};
       NumberOfProvincesLC547 provinces = new NumberOfProvincesLC547();
       long noOfProvinces = provinces.findCircleNum(cities);
       long noOfProvinces1 = provinces.findCircleNum(cities1);
       System.out.println(noOfProvinces);
        System.out.println(noOfProvinces1);
    }
    static class Edge{
        int u;
        int v;
        boolean connected;

        Edge(){

        }
        Edge(int u, int v, boolean connected){
            this.u = u;
            this.v = v;
            this.connected = connected;
        }
    }
    public long findCircleNum(int[][] isConnected) {
        DisjointSet disjointSet = new DisjointSet(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
               if(isConnected[i][j]==1){
                   disjointSet.unionByRank(i,j);
               }
           }
        }
       int count= 0;
        for(int i=1;i<=isConnected.length;i++){
            if(disjointSet.parent.get(i)==i){
                count++;
            }
        }
        return count;
    }
}
