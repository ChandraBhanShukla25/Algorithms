package com.graph;

import java.util.*;

public class LC787 {

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4;
        int src = 0; int dst = 3;
        LC787 lc847=new LC787();
        int val = lc847.CheapestFLight(n, flights, 0,3,1);
        System.out.println(val);
    }

        public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {

         List<List<int[]>> adjList = new ArrayList<>();
         for(int i=0;i<n;i++){
             adjList.add(new ArrayList<>());
         }
         for(int[] flight: flights){
             adjList.get(flight[0]).add(new int[]{flight[1],flight[2]});
         }

         int[] minDist = new int[n];

         Arrays.fill(minDist, Integer.MAX_VALUE);

         Queue<int[]> q = new LinkedList<>();
         q.offer(new int[]{0,src,0});

         while(!q.isEmpty()){
             int[] arr = q.poll();
             int stops = arr[0];
             int node = arr[1];
             int dist = arr[2];
             if(stops>K)
                 continue;

             for(int[] neighbor: adjList.get(node)){
                 int adjNode = neighbor[0];
                 int edgeWt = neighbor[1];
                 if(dist+edgeWt<minDist[adjNode] && stops<=K){
                     minDist[adjNode] = dist+edgeWt;
                     q.offer(new int[]{stops+1,adjNode,edgeWt+dist});
                 }
             }
         }
            if (minDist[dst]==Integer.MAX_VALUE){
                return -1;
            }
            return minDist[dst];
        }

}
