package com.disjointset;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet2 {

    private List<Integer> rank;
    private List<Integer> size;
    private List<Integer> parent;

    public DisjointSet2(int n){
        rank = new ArrayList<>();
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i=0;i<=n;i++){
            rank.add(i, 0);
            parent.add(i,i);
            size.add(i,1);
        }
    }

    public int findParent(int node){
        if(parent.get(node)==node)
            return node;
        int nodeParent = findParent(parent.get(node));
        parent.set(node, nodeParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent==vParent){
            return;
        }
        if(rank.get(uParent)>rank.get(vParent)){
            parent.set(vParent,uParent);
        }else if(rank.get(vParent)>rank.get(uParent)){
            parent.set(uParent,vParent);
        }else{
            parent.set(uParent,vParent);
            int rankV = rank.get(vParent);
            rank.set(vParent,rankV+1);
        }
    }

    public void unionBySize(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent==vParent){
            return;
        }
        if(size.get(uParent)>size.get(vParent)){
            parent.set(vParent,uParent);
            size.set(uParent,size.get(uParent)+size.get(vParent));
        }else{
            parent.set(uParent,vParent);
            size.set(vParent,size.get(vParent)+size.get(uParent));
        }
    }


    public static void main(String[] args) {
//      {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}, {3,7}}
        DisjointSet2 disjointSet2 = new DisjointSet2(7);
        disjointSet2.unionByRank(1,2);
        disjointSet2.unionByRank(2,3);
        disjointSet2.unionByRank(4,5);
        disjointSet2.unionByRank(6,7);
        disjointSet2.unionByRank(5,6);

        //find if 3 and 7 are in same set
        int u =3;
        int v =7;
        System.out.println("----Union BY RANK--------");
        if(disjointSet2.findParent(u)== disjointSet2.findParent(v)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }
        disjointSet2.unionByRank(3,7);
        if(disjointSet2.findParent(u)==disjointSet2.findParent(v)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }

        System.out.println("----Union BY Size--------");
        //for Union by Size
        DisjointSet2 disjointSet3 = new DisjointSet2(7);
        disjointSet3.unionBySize(1,2);
        disjointSet3.unionBySize(2,3);
        disjointSet3.unionBySize(4,5);
        disjointSet3.unionBySize(6,7);
        disjointSet3.unionBySize(5,6);

        int u1 =3;
        int v1 =7;
        if(disjointSet3.findParent(u1)== disjointSet2.findParent(v1)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }




        disjointSet3.unionBySize(3,7);
        if(disjointSet3.findParent(u)==disjointSet3.findParent(v)){
            System.out.println("same");
        }else{
            System.out.println("Not same");
        }
    }
}
